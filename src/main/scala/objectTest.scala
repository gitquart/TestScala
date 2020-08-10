import java.nio.file.Paths
import java.util.Iterator

import com.datastax.oss.driver.api.core.CqlSessionBuilder
import com.datastax.oss.driver.api.core.cql.{ResultSet, Row, SimpleStatementBuilder}
import org.apache.parquet.format.event.Consumers.Consumer



object objectTest extends App{

  var session = new CqlSessionBuilder()
    .withAuthCredentials("quartadmin", "P@ssw0rd33")
    .withCloudSecureConnectBundle(Paths.get("C:\\Users\\UlysesRico\\IdeaProjects\\proScalaTest\\secure-connect-dbquart.zip"))
    .withKeyspace("thesis")
    .build()

  var query="select id_thesis from thesis.tbthesis where period_number=10"

  var st= new SimpleStatementBuilder(query)
    .setIdempotence(true)
    .setPageSize(1000)
    .build()

  var rs: ResultSet=session.execute(query)
  while(rs.iterator().hasNext){

    

  }


  println("Done")

}


