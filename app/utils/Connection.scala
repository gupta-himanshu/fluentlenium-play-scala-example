package utils

import scala.slick.driver.PostgresDriver.simple.Database
import play.api.Play.current
import play.api.db.DB

object Connection {

  def databaseObject(): Database = {
    Database.forDataSource(DB.getDataSource())
  }

}