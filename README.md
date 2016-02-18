# akka-camel-oaq-example

**Sample code using Scala/Akka/Camel to enqueue and dequeue messages to/from an Oracle Queue (OAQ).**

### Required

 - JDK 8 +
 - Scala (2.11.7 +)
 - sbt (0.13 +)
 - oracle artifacts (*aqapi12 and ojdbc5*) aren't found on Maven Central,
 	so you have to put them on your local maven repo


### Create and start a queue/table on Oracle

```
BEGIN DBMS_AQADM.CREATE_QUEUE_TABLE(
     Queue_table        => 'MY_QUEUE',
     Queue_payload_type => 'SYS.AQ$_JMS_MESSAGE');
  END;

  BEGIN DBMS_AQADM.CREATE_QUEUE(
     Queue_name          => 'MY_QUEUE',
     Queue_table         => 'MY_QUEUE');
  END;

  BEGIN DBMS_AQADM.START_QUEUE(
     Queue_name          => 'MY_QUEUE');
  END;
```

### Run the project

Review the file **MyConfig** before you run:

```
$ sbt run
```
