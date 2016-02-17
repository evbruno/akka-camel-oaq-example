import java.util.Date

import akka.actor.{ActorSystem, Props}
import akka.camel.{Oneway, Producer}

import scala.concurrent.duration._
import scala.language.postfixOps

object Enqueuer extends App {

	val system = ActorSystem("EnqueuerSystem")
	MyConfig.registerComponent(system)

	val actor = system.actorOf(Props[EnqueuerActor])

	actor ! s"Hello World @ ${new Date}"

	import system.dispatcher
	system.scheduler.scheduleOnce(30 seconds) {
		system.terminate()
	}

}


class EnqueuerActor extends Producer with Oneway {

	def endpointUri = MyConfig.JMS_ENDPOINT

}