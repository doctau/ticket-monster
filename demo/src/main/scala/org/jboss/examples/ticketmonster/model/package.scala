package org.jboss.examples.ticketmonster.model


import java.io.Serializable;

import scala.beans.BeanProperty

import javax.persistence.Embeddable;


/**
 * <p>
 * A reusable representation of an address.
 * </p>
 * 
 * <p>
 * Addresses are used in many places in an application, so to observe the DRY principle, we model Address as an embeddable
 * entity. An embeddable entity appears as a child in the object model, but no relationship is established in the RDBMS..
 * </p>
 * 
 * @author Marius Bogoevici
 * @author Pete Muir
 */
@Embeddable
case class Address(
    @BeanProperty var street: String,
    @BeanProperty var city: String,
    @BeanProperty var country:String)
    extends Serializable {
  // ideally would be type Option[String]
  // used for initial compatibility during migration
  def this() = this(null, null, null)
}