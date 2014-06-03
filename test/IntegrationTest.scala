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
  def test1() {
    for (i <- 0 to 6) {
      running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
            browser.goTo("http://www.dzone.com/links/r/a_nonblocking_email_sending_functionality_in_scala.html")
//            browser.goTo("http://www.dzone.com/links/r/knolx_session_static_analysis_of_scala_programs.html")
//            browser.goTo("http://www.dzone.com/links/knolx_session_static_analysis_of_scala_programs.html")
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
//            browser.goTo("http://www.dzone.com/links/r/create_a_public_google_doc_via_google_drive_api_i.html")
//            browser.goTo("http://blog.knoldus.com/2014/05/12/create-a-public-google-doc-via-google-drive-api-in-scala/")
//            browser.goTo("http://www.dzone.com/links/automated_ui_testing_in_a_play_scala_application.html")
//            browser.goTo("http://www.dzone.com/links/how_to_obtain_geolocation_in_play_scala_applicati.html")
//            assertThat(browser.pageSource()).contains("h")
//            browser.goTo("http://www.dzone.com/links/r/how_to_obtain_geolocation_in_play_scala_applicati.html")
//            browser.goTo("http://www.dzone.com/links/r/automated_ui_testing_in_a_play_scala_application.html")
//            assertThat(browser.pageSource()).contains("a")
//            browser.goTo("http://blog.knoldus.com/2014/03/09/providing-a-sign-in-with-linkedin-functionality-using-scala/")
//            browser.goTo("http://blog.knoldus.com/2014/03/15/adding-an-email-sending-functionality-in-play-using-scala/")
//            browser.goTo("http://blog.knoldus.com/2014/03/29/create-upload-delete-google-docs-using-play-scala-application/")
//            browser.goTo("http://blog.knoldus.com/2014/04/05/using-cookies-in-play-framework/")
//            browser.goTo("http://blog.knoldus.com/2014/04/12/mock-unit-testing-using-mockito-in-play-scala-project/")
//            browser.goTo("http://blog.knoldus.com/2014/03/09/providing-a-sign-in-with-linkedin-functionality-using-scala/")
            assertThat(browser.pageSource()).contains("e")
            /*val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("email")*/
          }
        });
    }
  }

 /* @Test
  def test2() {
    for(i <- 0 to 237) {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://www.knoldus.com/home.knol")
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("e")
          }
        });
    }
  }*/
  /*@Test
  def test3() {
    for(i <- 0 to 11) {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://www.dzone.com/links/r/automated_ui_testing_in_a_play_scala_application.html")
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("e")
          }
        });
    }
  }
  @Test
  def test4() {
    for(i <- 0 to 11) {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://blog.knoldus.com/2014/03/09/providing-a-sign-in-with-linkedin-functionality-using-scala/")
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("e")
          }
        });
    }
  }
  @Test
  def test5() {
    for(i <- 0 to 11) {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://blog.knoldus.com/2014/03/15/adding-an-email-sending-functionality-in-play-using-scala/")
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("e")
          }
        });
    }
  }
  @Test
  def test6() {
    for(i <- 0 to 11) {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://blog.knoldus.com/2014/03/29/create-upload-delete-google-docs-using-play-scala-application/")
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("e")
          }
        });
    }
  }
  @Test
  def test7() {
    for(i <- 0 to 11) {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://blog.knoldus.com/2014/04/05/using-cookies-in-play-framework/")
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("e")
          }
        });
    }
  }
  @Test
  def test8() {
    for(i <- 0 to 800) {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
//            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://www.knoldus.com/home.knol")
            val email = "himanshu@knoldus.com"
            val password = "123456"
            val confirm_password = "123456"
            browser.$("#email").text(email)
            browser.$("#password").text(password)
            browser.$("#confirm_password").text(confirm_password)
            browser.$("#submit").click()
            assertThat(browser.pageSource()).contains("e")
          }
        });
    }
  }*/
  /*@Test
  def test9() {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://himanshu2014.wordpress.com/2014/04/12/mock-unit-testing-using-mockito-in-play-scala-project/")
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
  @Test
  def test10() {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://himanshu2014.wordpress.com/2014/04/12/mock-unit-testing-using-mockito-in-play-scala-project/")
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
  @Test
  def test11() {
    running(testServer(9000, fakeApplication(inMemoryDatabase())), FIREFOX,
        new Callback[TestBrowser]() {
          def invoke(browser: TestBrowser) {
            val indexPage = IndexPage.IndexPage(browser.getDriver(), 9000)
            browser.goTo("http://himanshu2014.wordpress.com/2014/04/12/mock-unit-testing-using-mockito-in-play-scala-project/")
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
  }*/
}
