package com.datinko.prototypes.scalaakkapoc

import akka.actor.{Actor, ActorLogging}

/**
 * An actor in our system that can receieve messages, but is only interested in doing something if the received
 * message is a 'pint'.
 */
class Person extends Actor with ActorLogging {

  def receive: Receive = {

    //route that defines what we do if we receive a 'pint' message.
    case Pint(number) =>
      log.info(s"Thanks for pint number $number!");
      Thread.sleep(1000)
      log.info(s"Done! Here is the empty glass for pint number $number.")

      sender ! EmptyPint(number)
  }

}
