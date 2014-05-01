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

object Application extends Controller {
  
  val signupForm = Form(
    mapping(
      "email" -> email,
      "password" -> nonEmptyText,
      "confirm_password" -> nonEmptyText)(SignUpData.apply)(SignUpData.unapply))

  def index = Action {implicit request =>
    Ok(views.html.index(signupForm, "Ok"))
  }

  def addData: Action[play.api.mvc.AnyContent] = Action { implicit request =>
    signupForm.bindFromRequest.fold(
      formWithErrors => {
        Ok(views.html.index(signupForm, "Wrong data"))//Redirect("/")
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