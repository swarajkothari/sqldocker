version := "0.1"

scalaVersion := "2.12.10"

name := "XMLParser"



// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.1.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.1.2"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.8.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kafka-0-10
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "3.1.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-avro
libraryDependencies += "org.apache.spark" %% "spark-avro" % "3.1.2"

// https://mvnrepository.com/artifact/com.databricks/spark-xml
libraryDependencies += "com.databricks" %% "spark-xml" % "0.13.0"
