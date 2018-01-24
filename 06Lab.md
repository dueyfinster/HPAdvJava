# Advanced Java

## Lab for Chapter 6 - Concurrency and Asynchronous Programming

1. A PowerPoint source file, ending with the suffix .pptx, is actually a zip archive file containing a hierarchy of XML files, 
   each of which describes some aspect of the presentation. 
   You will find a selection of PowerPoint source files for some of the chapters of this course, 
   and you can examine the contents of these files manually using an unzip utility, or the standard `jar` utility.

   The Java classes in the package `java.util.zip` allow these files to be processed. 
   In particular, the class `java.util.zip.ZipFile` represents a zip archive file, 
   and provides a number of methods that allow it to be read and analysed. 
   You can find out more details of this in the appropriate JavaDoc API page.

   The method entries on a `ZipFile` instance returns an `Enumeration` of the entries contained in the zip archive. 
   Each slide in the presentation is represented by a file in the (archived) directory `ppt/slides`, with name `slidenn.xml`.
   
   Write a method that returns the number of slides in a given presentation, by counting these files. 
   Write a further function that calls this for each of the pptx files in the attached directory, 
   and returns the total number of slides in all the files.
   
   Now refactor the counting function so that instead of returning an Int to represent the number of slides, 
   it runs asynchronously using a `CompleteableFuture<Int>` to represent the result. 
   Invoke the functions so that we can still return the total number of slides.
   
   If possible, measure the time taken to perform both the initial, synchronous, 
   version and the modified asynchronous version and (hopefully) illustrate a difference!
