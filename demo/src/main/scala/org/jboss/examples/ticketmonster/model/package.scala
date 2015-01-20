package org.jboss.examples.ticketmonster.model


import java.io.Serializable;

import scala.annotation.meta.field
import scala.beans.BeanProperty

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;


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
    @BeanProperty var country:String
  ) extends Serializable {
    // ideally would be type Option[String]
    // used for initial compatibility during migration
    def this() = this(null, null, null)
}

@Entity
case class TicketCategory(
    /**
     * <p>
     * The description of the of ticket category.
     * </p>
     *
     * <p>
     * The description forms the natural id of the ticket category, and so must be unique.
     * </p>
     *
     * <p>
     * The description must not be null and must be one or more characters, the Bean Validation constrain <code>@NotEmpty</code>
     * enforces this.
     * </p>
     */
    // need@field on the annotation, to tell scala it goes there, and not the the constructor, or getter/setter
    @(Column@field)(unique = true)
    @(NotEmpty@field)
    @BeanProperty var description: String
  )( // subsequent parameter lists are not used in toString/hashCode/equals
    /**
     * The synthetic id of the object.
     */
    @(Id@field) @(GeneratedValue@field)(strategy = IDENTITY)
    @BeanProperty var id: Long
  ) extends Serializable {
    // ideally would be type Option[String]
    // used for initial compatibility during migration
    def this() = this(null)(0)
}
