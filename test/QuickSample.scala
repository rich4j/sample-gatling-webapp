package heroic

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class QuickSample extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8080")
		.disableAutoReferer

	val grabDynamicInput = css("input[id=numberText]", "name").saveAs("dynamicField")

	val userCredentials = csv("users.csv")	

	val headers_0 = Map(
		"Accept-Encoding" -> "gzip, deflate, sdch",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Cache-Control" -> "max-age=0",
		"Origin" -> "http://localhost:8080",
		"Referer" -> "http://localhost:8080/",
		"Upgrade-Insecure-Requests" -> "1")

    val uri1 = "http://localhost:8080"

	val scn = scenario("QuickSample")
		.feed(userCredentials)
		.repeat(2) {
			exec(http("Goto Site")
				.get("/")
				.headers(headers_0))
			.pause(2)
			.exec(http("Enter Credentials")
				.post("/j_security_check")
				.headers(headers_1)
				.formParam("j_username", "${username}")
				.formParam("j_password", "${password}")
				.check(grabDynamicInput))
			.pause(2)
			.exec(http("Perform Age Check")
				.post("/capture.jsp")
				.headers(headers_1)
				.formParam("${dynamicField}", "6")
				.check(css("#answer").is("6")))
			.pause(2)
			.exec(http("Return to Home")
				.get("/index.jsp"))
			.pause(2)
			.exec(http("Logout")
				.get("/logout.jsp"))
		}

	setUp(scn.inject(rampUsers(9) over(5 seconds))).protocols(httpProtocol)
}