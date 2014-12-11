
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8081")
		.inferHtmlResources()
		.acceptHeader("""application/json, text/plain, */*""")
		.acceptEncodingHeader("""gzip, deflate""")
		.acceptLanguageHeader("""en-US,en;q=0.5""")
		.connection("""keep-alive""")
		.contentTypeHeader("""application/x-www-form-urlencoded""")
		.userAgentHeader("""Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:31.0) Gecko/20100101 Firefox/31.0""")

	val headers_0 = Map("""Accept""" -> """text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8""")

	val headers_9 = Map("""If-Modified-Since""" -> """Thu, 16 Oct 2014 08:36:49 GMT""")

	val headers_10 = Map("""If-Modified-Since""" -> """Tue, 18 Nov 2014 14:27:25 GMT""")

	val headers_12 = Map("""If-Modified-Since""" -> """Fri, 07 Nov 2014 16:20:45 GMT""")

	val headers_13 = Map("""If-Modified-Since""" -> """Tue, 11 Nov 2014 10:16:54 GMT""")

	val headers_18 = Map(
		"""Accept""" -> """image/png,image/*;q=0.8,*/*;q=0.5""",
		"""If-Modified-Since""" -> """Thu, 16 Oct 2014 08:36:49 GMT""")

	val headers_21 = Map("""If-Modified-Since""" -> """Mon, 20 Oct 2014 15:32:19 GMT""")

	val headers_22 = Map("""If-Modified-Since""" -> """Thu, 06 Nov 2014 10:07:33 GMT""")

    val uri1 = """http://localhost:8081"""

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("""/""")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + """/img/favicon.ico""")
			.headers(headers_0)
			.check(status.is(404)),
            http("request_2")
			.get(uri1 + """/build/fonts/OpenSans.woff""")
			.headers(headers_0))
			.check(status.is(401)))
		.pause(7)
		.exec(http("request_3")
			.post("""/auth""")
			.headers(headers_0)
			.formParam("""email""", """manager@opgtest.com""")
			.formParam("""password""", """Password1""")
			.formParam("""submit""", """Sign In""")
			.resources(http("request_4")
			.get(uri1 + """/favicon.ico""")
			.headers(headers_0)
			.check(status.is(404)),
            http("request_5")
			.get(uri1 + """/api/permission"""),
            http("request_6")
			.get(uri1 + """/api/user?email=manager@opgtest.com"""),
            http("request_7")
			.get(uri1 + """/api/user"""),
            http("request_8")
			.get(uri1 + """/api/case?page=1""")))
		.pause(4)
		.exec(http("request_9")
			.get("""/core/templates/person.html""")
			.headers(headers_9)
			.resources(http("request_10")
			.get(uri1 + """/modules/timeline/timeline.html""")
			.headers(headers_10)
			.check(status.is(304)),
            http("request_11")
			.get(uri1 + """/modules/person-details/person-details.html""")
			.headers(headers_9)
			.check(status.is(304)),
            http("request_12")
			.get(uri1 + """/modules/timeline/timeline-facets.html""")
			.headers(headers_12)
			.check(status.is(304)),
            http("request_13")
			.get(uri1 + """/modules/person-details/more-case-info.template.html""")
			.headers(headers_13)
			.check(status.is(304)),
            http("request_14")
			.get(uri1 + """/modules/person-details/more-person-info.template.html""")
			.headers(headers_9)
			.check(status.is(304)),
            http("request_15")
			.get(uri1 + """/api/warning?person%5Bid%5D=41"""),
            http("request_16")
			.get(uri1 + """/api/person/41"""),
            http("request_17")
			.get(uri1 + """/api/event?cases%5B%5D=18&donorId=41&page=1&summary=true"""),
            http("request_18")
			.get(uri1 + """/build/img/pdf-icon.png""")
			.headers(headers_18)
			.check(status.is(304)))
			.check(status.is(304)))
		.pause(11)
		.exec(http("request_19")
			.get("""/core/js/action-widget/timeline/templates/editCase.inc.html""")
			.headers(headers_9)
			.resources(http("request_20")
			.get(uri1 + """/modules/multi-page-form/multiPageForm.template.html""")
			.headers(headers_12)
			.check(status.is(304)),
            http("request_21")
			.get(uri1 + """/modules/multi-page-form/fieldCollection.template.html""")
			.headers(headers_21)
			.check(status.is(304)),
            http("request_22")
			.get(uri1 + """/modules/multi-page-form/field.template.html""")
			.headers(headers_22)
			.check(status.is(304)),
            http("request_23")
			.get(uri1 + """/api/case/18"""))
			.check(status.is(304)))

	setUp(scn.inject(atOnceUsers(5))).protocols(httpProtocol)
}