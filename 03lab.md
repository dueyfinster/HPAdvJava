# Advanced Java

## Lab for Chapter 4 - Streams

1. The method `listFiles()` defined on the type `java.io.File` generates a `List` of the contents of the current directory (or whatever directory path is supplied in the call) as instances of the `java.io.File`.

   Use this as the starting point for the following questions, each of which should be answered by constructing a `Stream`and then using a chain of processing calls.

   * Generate a list of the names of all the _files_ in the current directory (i.e. not subdirectories). Exclude 'hidden' files (files whose names start with the '.' character).

   * Generate a `Map`, where the keys are the names of the files and the corresponding values are the appropriate size in bytes.

   * Generate a list of the 10 smallest files in the directory, in order, together with their sizes. Do the same for the 10 largest files.

   * Generate a data structure that arranges the contents of the directory according to the first letter of their name. In other words, for the letter 'a', there should be a list of entries whose names start with 'a', and so on...

