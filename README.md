## rmq-test

Simple RabbitMQ Java publisher and consumer.  The `Publisher` creates a fanout exchange called `logs`, and publishes a message to it every 0.5 seconds.  The `Consumer` creates a queue specified by the command line parameter, and binds it to the `logs` exchange.  It prints out messages as they are received.

## Requirements

To successfully use the examples you will need a RabbitMQ node running locally.

You'll need to download the following JAR files from Maven Central, into the project `lib` directory:

 * [RabbitMQ Java Client](https://repo1.maven.org/maven2/com/rabbitmq/amqp-client/5.14.2/amqp-client-5.14.2.jar)
 * [SLF4J API](https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar)
 * [SLF4J Simple](https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.36/slf4j-simple-1.7.36.jar)

For example, with `wget`:

``` shell
wget -P lib https://repo1.maven.org/maven2/com/rabbitmq/amqp-client/5.14.2/amqp-client-5.14.2.jar
wget -P lib https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar
wget -P lib https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.36/slf4j-simple-1.7.36.jar
```

You can set an environment variable for the jar files on the classpath, eg.

MacOS:

``` shell
export CP=.:./target:lib/amqp-client-5.14.2.jar:lib/slf4j-api-1.7.36.jar:lib/slf4j-simple-1.7.36.jar
```

To compile you only need the RabbitMQ Java client jar on the classpath.

``` shell
javac -cp $CP -d target Consume.java
javac -cp $CP -d target Publish.java
```

To run them you'll need all the dependencies.

The `Publish` app takes one argument, an identifier (for running multiple instances of the app).  Eg:

``` shell
javac -cp $CP -d target Publish.java p0
```

The `Consume` app takes a single argument, the queue name.  Eg:

``` shell
javac -cp $CP -d target Consume.java q0
```

