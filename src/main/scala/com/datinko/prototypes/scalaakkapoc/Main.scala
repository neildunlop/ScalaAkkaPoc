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

  //create our customers
  val alice = system.actorOf(Props(new Person), "alice")
  val bob = system.actorOf(Props(new Person), "bob")
  val charlie = system.actorOf(Props(new Person), "charlie")

  //hand out some tokens to our customers
  zed.tell(Token(2), alice);
  zed.tell(Token(3), bob);
  zed.tell(Token(1), charlie);


  system.awaitTermination()

}
