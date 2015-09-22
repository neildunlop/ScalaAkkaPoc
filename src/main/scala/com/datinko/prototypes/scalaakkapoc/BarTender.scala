package com.datinko.prototypes.scalaakkapoc

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging}

/**
 * Created by Neil on 22/09/2015.
 */
class BarTender extends Actor with ActorLogging {

  override def receive: Receive = {

    case Cash =>
      log.info("One pint, coming up")
      Thread.sleep(1000);
      log.info("Here's your pint!")

      sender ! Pint

    case EmptyPint =>
      log.info("No more for you!")
      context.system.shutdown()
  }
}
