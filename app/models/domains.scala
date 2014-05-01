package models

import scala.slick.driver.PostgresDriver.simple._

case class Data(email: String, password: String, id: Int = 0)
case class SignUpData(email: String, password: String, confirm_password: String)

trait domains {

  class data(tag: Tag) extends Table[Data](tag, "datas") {
    def email: Column[String] = column[String]("email")
    def password: Column[String] = column[String]("password")
    def id: Column[Int] = column[Int]("id",O.AutoInc,O.PrimaryKey)
    def * = (email, password, id) <> (Data.tupled, Data.unapply)
  }

  val dataTable = TableQuery[data]
}
