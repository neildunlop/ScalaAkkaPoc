package com.datinko.prototypes.scalaakkapoc

import akka.actor.{Props, ActorSystem}

/**
 * Created by Neil on 22/09/2015.
 */
object Main extends App {

  println("Hello Akka!");

  //sets up a new actor system that contains our akka system of actors and messages
  val system = ActorSystem("akka-poc")

  //create a bartender called zed
  val zed = system.actorOf(Props(new BarTender), "zed")

  //create a new person actor called alice
  val alice = system.actorOf(Props(new Person), "alice")

  //send a pint to alice
  zed.tell(Cash, alice);


  system.awaitTermination()

}
