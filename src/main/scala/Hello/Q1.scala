package Hello

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {
  def receive: Receive = {
    case "hello" => println("Hello akka")
    case _ => println("I don't know")
  }
}

object Hello extends App {
  val system = ActorSystem("HelloActorSystem")
  val helloActor = system.actorOf(Props[HelloActor],"helloactor")
  helloActor ! "hello"
  helloActor ! "i don't know"

  system.terminate()
}
