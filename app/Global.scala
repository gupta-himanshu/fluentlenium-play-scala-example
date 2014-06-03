import play.api._
import play.api.Logger
import play.api.mvc.SimpleResult
import play.api.mvc.RequestHeader
import play.api.mvc.Results.InternalServerError
import play.api.mvc.Result
import utils.Connection
import slick.driver.PostgresDriver.simple._
import models.domains
import scala.slick.driver.PostgresDriver.simple._

object Global extends GlobalSettings with domains {

  override def onStart(app: Application): Unit = {
    Logger.info("Application has started")

    /*try {
      Connection.databaseObject.withSession { implicit session: Session =>
        dataTable.ddl.create
        Logger.info("All tables have been created")
      }

    } catch {
      case ex: Exception => Logger.info(ex.getMessage() + ex.printStackTrace())
    }*/
  }

  override def onStop(app: Application): Unit = {
    Logger.info("Application shutdown.......")
  }
}