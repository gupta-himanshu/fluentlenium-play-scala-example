import org.fluentlenium.core.FluentPage
import org.openqa.selenium.WebDriver
import org.fluentlenium.core.filter.FilterConstructor.withText 
import org.fluentlenium.core.filter.FilterConstructor.withId

object IndexPage extends FluentPage {
  var URL = ""

  def IndexPage (webDriver: WebDriver, port: Int) {
    super.initFluent(webDriver)
    this.URL = "http://localhost:" + port
  }

  override def getUrl(): String = {
    this.URL
  }

  override def isAt() {
    assert(title().equals("Sign Up"))
  }

}