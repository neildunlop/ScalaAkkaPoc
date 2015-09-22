package com.datinko.prototypes.scalaakkapoc

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging}

/**
 * Created by Neil on 22/09/2015.
 */
class BarTender extends Actor with ActorLogging {

  var pintsBeingDrunk = 0

  override def receive: Receive = {

    case Token(quantity) =>
      pintsBeingDrunk = pintsBeingDrunk + quantity
      log.info(s"I'll get $quantity pints ready for [${sender.path}]")

      for(number <- 1 to quantity) {
        log.info(s"Pint $number coming right up for [${sender.path}}]")
        Thread.sleep(1000);
        log.info(s"Pint $number is ready, here you go [${sender.path}}]")

        sender ! Pint(number)
      }

    case EmptyPint(number) =>
      pintsBeingDrunk match {
        case 1 =>
          log.info("You all drank those pints quick, time to close up shop!")
          context.system.shutdown()

        case n =>
          pintsBeingDrunk = pintsBeingDrunk - 1
          log.info(s"You drank pint $number quick, but there are still $pintsBeingDrunk pints out there being drunk")
      }
  }
}
