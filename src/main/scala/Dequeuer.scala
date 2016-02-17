import akka.actor.{Props, ActorLogging, ActorSystem}
import akka.camel.{CamelMessage, Consumer}

object Dequeuer extends App {

	val system = ActorSystem("DequeuerSystem")
	MyConfig.registerComponent(system)

	val actor = system.actorOf(Props[DequeuerActor])
}

class DequeuerActor extends Consumer with ActorLogging {

	def endpointUri = MyConfig.JMS_ENDPOINT

	def receive = {
		case msg: CamelMessage => log.info(s"\n\n>> message arrived: ${msg.bodyAs[String]} \n")
	}
}