
Setup
* add scala maven plugin


First class
* create package.scala
* migrate Address to case class
** Need to add @BeanProperty to generate getters and setters (scala has different names for methods)
** Need to mark var (default is val)
** Need to add "def this() = this(null, null, null)", to create zero-arg constructor
*** Note that Option[String] would be better than null, but fix that later
* Testing fails, because scala-library.jar is missing from the Arquillian deployment -- move first?
** Add via ShrinkWrap Maven resolver

Seconds class
* Migrate TicketCategory
** Don't want id used to toString/hashCode/equals
*** classes can have multiple parameter lists, only the first is used for this
**** MUST have val/var on later parameter lists
*** Wait a minute hashCode/equals depends on a mutable field?!? that's dangerous
**** It's even used in a HashMap in BookingService
** parameter annotations go to the constructor by default
*** need @field on the annotation to tell it to go there
*** e.g. @(Id@field)


Fixing migration warts
* Remove usage of null