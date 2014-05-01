package models

import scala.slick.driver.PostgresDriver.simple._
import utils.Connection


trait DataDAL {
  def insertData(data: Data): Int
  def searchDataByEmail(email: String): Option[String]
}

/**
 * Data Access Layer for user table
 */
object DataDAL extends domains with DataDAL {

  /**
   * Inserting new user to DB
   */
  def insertData(data: Data): Int = {
    Connection.databaseObject withSession { implicit session =>
      dataTable.insert(data)
    }
  }

   /**
   * Searching user by Email
   */
  def searchDataByEmail(email: String): Option[String] = {
    Connection.databaseObject withSession { implicit session: Session =>
      (for { data <- dataTable if (data.email === email) } yield data.email).firstOption
    }
  }

}
