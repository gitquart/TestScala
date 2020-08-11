import java.nio.file.Paths
import java.time.Duration
import java.util.function.Consumer
import com.datastax.oss.driver.api.core.CqlSessionBuilder
import com.datastax.oss.driver.api.core.cql.{Row, SimpleStatementBuilder}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object objectTest extends App{

  //Spark
/*
  val conf = new SparkConf()
  conf.setMaster("local")
      .setAppName("appSparkCassandra")

  val sc= new SparkContext(conf)

  val lst:List[String]= List("hello","there")
  val lst2:List[String]=List("hhh","popopo")
  val rdd1= sc.makeRDD(lst)
  val rdd2= sc.makeRDD(lst2)


 */

  val currentDirectory:String = System.getProperty("user.dir")
  var session = new CqlSessionBuilder()
    .withAuthCredentials("quartadmin", "P@ssw0rd33")
    .withCloudSecureConnectBundle(Paths.get(currentDirectory+"\\secure-connect-dbquart.zip"))
    .withKeyspace("thesis")
    .build()

  var query="select * from thesis.tbthesis where period_number>4 ALLOW FILTERING"

  //With 2 mins of TimeOut I got the 5th period complete
  //With 1 min of Time Out I got the whole database
  var st= new SimpleStatementBuilder(query)
    .setIdempotence(true)
    .setPageSize(1000)
    .setTimeout(Duration.ofMinutes(1))
    .build()


  var contar:Int=0

  println("Go...")
  session.execute(st).forEach(new Consumer[Row] (){

    override def accept(row: Row): Unit = {

      contar+=1
      //println(row.getFormattedContents())
      println(contar.toString)
    }
  })

  println("DONE")
}


