# Advanced Java

## Lab for Chapter 5 - Java 8 Date/Time APIs

1. Write a program that displays, for the next 5 years, the day of the week on which your birthday occurs

1. Write a program that determines the months of the current year for which the 13th falls on a Friday.

1. Write a program that, for a given month, displays the dates of all the Wednesdays.

1. Write function called ```measure```,
   which accepts as its argument an instance of the ```Runnable``` functional interface 
   (this could be an object that represents the task or a lambda expression).
   The function should return a ```Duration``` object that represents how long it
   took to run the task. Test this with some tasks, for example:
   ```
   () -> {try { Thread.sleep(1500); } catch ( Exception e ) {} }
   ```
   
   Now see if you can provide overloaded versions of the ```measure``` method for the
   ```Supplier<T>``` and ```Consumer<T>``` functional interfaces. 

