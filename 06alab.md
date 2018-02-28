
# Advanced Java

## Lab for Chapter 6a - Synchronisation

1. Write a function that encapsulates the acquisition and release of a ```Lock``` object,
   which initially will be a ``ReentrantLock``` for the execution of another piece of code.
   The function (which you can implement as a static method for now) should accept the ```Lock```
   that is to be used and the code to execute while the lock is held. Make sure your function behaves
   correctly in the situation where the code throws an exception (ie ```RuntimeException```).

1. Provide an implementation of the "Producer/Consumer" application described in the chapter that uses
   a ```Blocking Queue``` implementation to manage the resources.
  
  
