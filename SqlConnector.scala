import com.sun.webkit.perf.WCGraphicsPerfLogger.log
import com.sun.webkit.perf._
import org.apache.log4j
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.slf4j.LoggerFactory

import java.io.FileInputStream
import java.util.Properties
import org.apache.log4j.PropertyConfigurator

import java.sql.DriverManager
import scala.collection.JavaConverters._
//import scala.collection.JavaConverters.dictionaryAsScalaMapConverter

object SqlConnector {
  def main(args: Array[String]): Unit = {
//    val spark = SparkSession.builder().master("local[*]").appName("talking_to_mysql").getOrCreate()
//    val sc = spark.sparkContext
//    val sparkconf = new SparkConf()
    val localconf = new Properties
    localconf.load(getClass().getClassLoader().getResourceAsStream("sqlconnect.properties"))
//    localconf.load(getClass().getClassLoader().getResourceAsStream("D:/Intellij Workspace/XMLParser/src/main/sqlconnect.properties"))
    PropertyConfigurator.configure(localconf)

//    val path = localconf.getProperty("path")
    val jdbcHostname = localconf.getProperty("jdbcHostname")
    val jdbcPort = localconf.getProperty("jdbcPort")
//    val jdbcDatabase = ""
    val jdbcUsername = localconf.getProperty("jdbcUsername")
    val jdbcPassword = localconf.getProperty("jdbcPassword")
    val classname = localconf.getProperty("classname")
    val topic = localconf.getProperty("topic");
    val topic_tail_constant = localconf.getProperty("topic_tail_constant")

    val jdbcUrl = s"jdbc:mysql://${jdbcHostname}:${jdbcPort}"

    Class.forName(classname)
    val connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)
    val statement = connection.createStatement()

    val resultset = statement.executeQuery("select * from RA_IOT.topic_partitions_offset where topic = '" + (topic+topic_tail_constant) + "'")

    while (resultset.next()) {
        val my_offsets = resultset.getString("offset")
        println(my_offsets)
    }





//    def printConfigValue(offset1: Int) = {
//      println(offset1)
//    }

//    println(printConfigValue)




    }
}
