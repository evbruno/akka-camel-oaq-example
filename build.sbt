name			:= "akka-camel-oaq-example"
organization	:= "etc.bruno"
version 		:= "1.0"
scalaVersion	:= "2.11.7"

libraryDependencies ++= {
	val akkaV = "2.4.2-RC2"
	val camelV = "2.15.5"
	Seq(

		"com.typesafe.akka" %% "akka-actor" % akkaV,
		"com.typesafe.akka" %% "akka-camel" % akkaV,
		"org.apache.camel" % "camel-jms" % camelV,

		"org.slf4j" % "slf4j-api" % "1.7.2",
		"ch.qos.logback" % "logback-classic" % "1.0.7",

		"javax.jms" % "jms" % "1.1",
		"javax.transaction" % "jta" % "1.1",

		"oracle" % "ojdbc5" % "11.1.0.7.0",
		"oracle" % "aqapi12" % "10.1.0.5.0"
	)
}

//fork in run := true

scalacOptions 	:= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint", "-feature")

resolvers += Resolver.mavenLocal
