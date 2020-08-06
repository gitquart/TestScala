
import java.nio.file.Paths
import com.datastax.oss.driver.api.core.CqlSessionBuilder
import com.datastax.oss.driver.api.core.cql._

object objectTest extends App{

  val session = new CqlSessionBuilder()
    .withAuthCredentials("quartadmin", "P@ssw0rd33")
    .withCloudSecureConnectBundle(Paths.get("C:\\Users\\UlysesRico\\IdeaProjects\\proScalaTest\\secure-connect-dbquart.zip"))
    .withKeyspace("thesis")
    .build()

  val query="select id_thesis from thesis.tbthesis where period_number=10"

  val rs:ResultSet= session.execute(query)

  println("ok")



}


