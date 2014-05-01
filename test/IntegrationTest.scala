import org.junit.Test
import play.test.TestBrowser
import play.libs.F.Callback
import play.test.Helpers.FIREFOX
import play.test.Helpers.inMemoryDatabase
import play.test.Helpers.fakeApplication
import play.test.Helpers.testServer
import play.test.Helpers.running
import org.fest.assertions.Assertions.assertThat

class IntegrationTest {

  @Test
  def test() {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo(IndexPage.getUrl)
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("email")
          }
        });
  }
}