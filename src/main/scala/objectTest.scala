import java.nio.file.Paths
import java.time.Duration
import java.util.function.Consumer
import com.datastax.oss.driver.api.core.CqlSessionBuilder
import com.datastax.oss.driver.api.core.cql.{Row, SimpleStatementBuilder}
import java.util.Calendar
import com.datastax.spark.connector._

object objectTest extends App{

  val currentDirectory:String = System.getProperty("user.dir")

  //This is for Cassandra Datastax, it may work for spark as well
  var session = new CqlSessionBuilder()
    .withAuthCredentials("test", "testquart")
    .withCloudSecureConnectBundle(Paths.get(currentDirectory+"\\secure-connect-dbtest.zip"))
    .withKeyspace("test")
    .build()

  //Spark


  /*
  Datastax connection only


  var query="select * from test.tbthesis where period_number>4 ALLOW FILTERING"

  //With 2 mins of TimeOut I got the 5th period complete
  //With 1 min of Time Out I got the whole database
  var st= new SimpleStatementBuilder(query)
    .setIdempotence(true)
    .setPageSize(1000)
    .setTimeout(Duration.ofMinutes(1))
    .build()


  var contar:Int=0
  print("Start:"+Calendar.getInstance.getTime.toString)

  session.execute(st).forEach(new Consumer[Row] (){

    override def accept(row: Row): Unit = {

      contar+=1
      //println(row.getFormattedContents())

    }
  })
  println(contar.toString)
  print("End:"+Calendar.getInstance.getTime.toString)
  println("DONE")

   */


}


