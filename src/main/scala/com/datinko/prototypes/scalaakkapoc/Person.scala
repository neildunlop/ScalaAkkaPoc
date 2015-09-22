package com.datinko.prototypes.scalaakkapoc

import akka.actor.{Actor, ActorLogging}

/**
 * An actor in our system that can receieve messages, but is only interested in doing something if the received
 * message is a 'pint'.
 */
class Person extends Actor with ActorLogging {

  def receive: Receive = {

    //route that defines what we do if we receive a 'pint' message.
    case Pint =>
      log.info("Thanks for the pint!");
      Thread.sleep(1000)
      log.info("I'm ready for another one..")

      sender ! EmptyPint
  }

}
