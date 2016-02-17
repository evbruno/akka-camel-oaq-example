import akka.actor.ActorSystem
import akka.camel.CamelExtension
import oracle.jdbc.pool.OracleDataSource
import oracle.jms.AQjmsFactory
import org.apache.camel.component.jms.{JmsComponent, JmsConfiguration}

object MyConfig {

	val username = "system"
	val password = "oracle"
	val url = "jdbc:oracle:thin:@localhost:1521:SID"

	def factory = {
		val ds = new OracleDataSource
		ds.setUser(username)
		ds.setPassword(password)
		ds.setURL(url)
		AQjmsFactory.getConnectionFactory(ds)
	}

	def registerComponent(system: ActorSystem) {
		val camel = CamelExtension(system)

		val component = new JmsComponent(new JmsConfiguration(factory))
		camel.context.addComponent("jms", component)
	}

	val JMS_ENDPOINT = "jms:queue:MY_QUEUE?testConnectionOnStartup=true"

}
