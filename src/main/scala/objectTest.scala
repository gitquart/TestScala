import java.nio.file.Paths
import java.time.Duration
import com.datastax.oss.driver.api.core.CqlSessionBuilder
import com.datastax.oss.driver.api.core.cql.{Row, SimpleStatementBuilder}
import java.util.function.Consumer

import com.datastax.oss.driver.api.core.data.CqlDuration



object objectTest extends App{

  var session = new CqlSessionBuilder()
    .withAuthCredentials("quartadmin", "P@ssw0rd33")
    .withCloudSecureConnectBundle(Paths.get("C:\\Users\\UlysesRico\\IdeaProjects\\proScalaTest\\secure-connect-dbquart.zip"))
    .withKeyspace("thesis")
    .build()

  var query="select id_thesis, period_number from thesis.tbthesis where period_number=10"

  var st= new SimpleStatementBuilder(query)
    .setIdempotence(true)
    .setPageSize(1000)
    .setTimeout(Duration.ofSeconds(1000))
    .build()


  session.execute(st).forEach(new Consumer[Row] (){

    override def accept(row: Row): Unit = {

      println(row.getFormattedContents())
    }
  })

  println("Done")
}


