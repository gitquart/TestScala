
import java.nio.file.Paths
import com.datastax.oss.driver.api.core.CqlSessionBuilder




object objectTest extends App{

  val session = new CqlSessionBuilder()
    .withAuthCredentials("quartadmin", "P@ssw0rd33")
    .withCloudSecureConnectBundle(Paths.get("C:\\Users\\UlysesRico\\IdeaProjects\\proScalaTest\\secure-connect-dbquart.zip"))
    .withKeyspace("thesis")
    .build()

  if (session.isClosed) {
    println("Connection is closed")

  }else{
    println("Hurra, is open!")
  }

  //val query="select id_thesis from thesis.tbthesis where period_number=10"

}


