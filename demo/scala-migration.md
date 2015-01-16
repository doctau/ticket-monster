
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



Fixing migration warts
* Remove usage of null