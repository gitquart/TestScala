import java.nio.file.Paths
import java.time.Duration
import com.datastax.oss.driver.api.core.CqlSessionBuilder
import com.datastax.oss.driver.api.core.cql.{Row, SimpleStatementBuilder}
import java.util.function.Consumer

object objectTest extends App{

  var session = new CqlSessionBuilder()
    .withAuthCredentials("quartadmin", "P@ssw0rd33")
    .withCloudSecureConnectBundle(Paths.get("C:\\Users\\UlysesRico\\IdeaProjects\\proScalaTest\\secure-connect-dbquart.zip"))
    .withKeyspace("thesis")
    .build()

  var query="select id_thesis, period_number from thesis.tbthesis where period_number>4 ALLOW FILTERING"

  //With 2 mins of TimeOut I got the 5th period complete
  //With 1 min of Time Out I got the whole database
  var st= new SimpleStatementBuilder(query)
    .setIdempotence(true)
    .setPageSize(1000)
    .setTimeout(Duration.ofMinutes(1))
    .build()


  var contar:Int=0

  session.execute(st).forEach(new Consumer[Row] (){

    override def accept(row: Row): Unit = {

      contar+=1
      println(row.getFormattedContents())
      println(contar.toString)



    }
  })

  println("DONE")
}


