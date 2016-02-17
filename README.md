# akka-camel-oaq-example

**Sample code using Scala/Akka/Camel to enqueue and dequeue messages to/from an Oracle Queue (OAQ).**

### Required

 - [JDK 8 +](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 - [Scala 2.11.7 +](http://www.scala-lang.org/download/)
 - [sbt 0.13 +](http://www.scala-sbt.org/download.html)
 - oracle artifacts (*aqapi12 and ojdbc5*) aren't found on Maven Central,
 	so you have to put them on your local maven repo


### Create and start a queue/table on Oracle

```
BEGIN
  DBMS_AQADM.CREATE_QUEUE_TABLE(
     Queue_table        => 'MY_QUEUE',
     Queue_payload_type => 'SYS.AQ$_JMS_MESSAGE');
  
  DBMS_AQADM.CREATE_QUEUE(
     Queue_name          => 'MY_QUEUE',
     Queue_table         => 'MY_QUEUE');
  
  DBMS_AQADM.START_QUEUE(
     Queue_name          => 'MY_QUEUE');
  END;
```

*Check this [docker image](https://hub.docker.com/r/wnameless/oracle-xe-11g/) if you need an Oracle installation*
### Run the project

Review the file **MyConfig** before you run:

```
$ sbt run
```
