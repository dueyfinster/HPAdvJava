# Advanced Java

## Lab for Chapter 2 - Lambdas

1. Define a class called `FunctionBuilder`, 
which has a single (static) method called `buildFunc`.

This method should take a single argument, which is a `String`,
representing an arithmetic operation on two `int` values.
Examples include `add`, `subtract` or `multiply`
(leave divide for now).
The method should return an instance of one of the Java 8 Functional Interfaces
(choose which is the most appropriate) which will carry out the operation that
is represented by its argument.

For example, you should be able to evaluate the following expression:
```
FuncBuilder.buildFunc("add").apply(3,4)
```
to yield the value 7.
