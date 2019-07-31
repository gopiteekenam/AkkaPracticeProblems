package Hello

import akka.actor.{ActorSystem, Props}
import akka.testkit.TestKit
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

import scala.concurrent.duration._
import scala.language.postfixOps

class Q1(_system:ActorSystem)
  extends TestKit(_system)
  with Matchers
  with FlatSpecLike
  with BeforeAndAfterAll{


  val helloActor = system.actorOf(Props[HelloActor],"helloactor")

  def this() = this(ActorSystem("Q1"))
  override def afterAll: Unit = {
    shutdown(system)
  }

  "A HelloActor" should "pass on a greeting message when instructed to" in {
    within(500 millis){
      helloActor ! "hello"
      expectNoMsg
    }
  }

}
