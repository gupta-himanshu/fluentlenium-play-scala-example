package controllers

import play.api._
import play.api.mvc._
import models.SignUpData
import models.Data
import play.api.Play.current
import play.api.data._
import play.api.data.Forms._
import utils.EncryptionUtility._
import models.DataDAL._
import java.net.URL
import java.io.StringWriter
import java.io.BufferedReader
import java.io.InputStreamReader
import play.api.libs.json._

object Application extends Controller {

  val signupForm = Form(
    mapping(
      "email" -> email,
      "password" -> nonEmptyText,
      "confirm_password" -> nonEmptyText)(SignUpData.apply)(SignUpData.unapply))

  def index = Action { implicit request =>
    /*var ipAddress: String = request.remoteAddress
    println(ipAddress)*/
    val ipAddress = "122.162.83.159"
    val key: String = Play.current.configuration.getString("ipinfodb_api_key").get;
    val ipInfoDBURL = new URL("http://api.ipinfodb.com/v3/ip-city" + "/?key=" + key + "&ip=" + ipAddress + "&format=" + "json")
    val conn = ipInfoDBURL.openConnection

    //    val response1 = conn.getInputStream()
    val in = new BufferedReader(
      new InputStreamReader(conn.getInputStream))
    val response = new StringBuffer
    for (i <- 0 to 12) {
      //    if (in.readLine != null) {
      response.append(in.readLine)
      //    }
    }
    println("")
    in.close()
    val nullExpr = "null".r
    val dataString = nullExpr.replaceAllIn(response.toString, "")
    val dataList = dataString.split(",").toList
    /*val locationValues = dataList map {
            case info => Json.parse("({" + info + "})")
          }*/
          val cityName = dataList(5).split(":")(1).toString()
    println(cityName)
    /*val data = conn.getHeaderFields().entrySet()
    println(data)*/
    /*val fields = data.getClass().getDeclaredFields()
    for(field <- fields){
      field.setAccessible(true)
      println(field)
    }*/
    //    println(new java.io.InputStreamReader(data))
    /*request.containerRequest.map(r =>
      ipAdd = r.remoteAddress)*/
    Ok(views.html.index(signupForm, "Ok"))
  }

  def addData: Action[play.api.mvc.AnyContent] = Action { implicit request =>
    signupForm.bindFromRequest.fold(
      formWithErrors => {
        Ok(views.html.index(signupForm, "Wrong data")) //Redirect("/")
      },
      data => {
        searchDataByEmail(data.email) match {
          case None =>
            val encryptedPassword = encryptPassword(data.password)
            val response = insertData(Data(data.email, encryptedPassword))
            Redirect("/")
          case Some(data) => Ok(views.html.index(signupForm, "Email Id Already Exist !"))

        }
      })
  }
}