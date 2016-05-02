[
  adopted from http://www.cs.rochester.edu/u/www/courses/171/Fall-03/files/readme.txt
  by Deger Cenk Erdil
  for CS654 Distributed Systems
  This is a template README file about how you should form your own README file.
  In general,
        you should remove anything in between square brackets (i.e. [..]), and
        you should replace anything in between <> with a value.
]

CS542 Design Patterns
Spring 2016
PROJECT <4> README FILE

Due Date: <PROJECT DUE DATE, IN FORMAT: Tuesday, April 21, 2016>
Submission Date: <DATE YOU SUBMIT, IN FORMAT: Tuesday, April 21, 2016>
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): PHANIKIRAN HARI AND DEEDEEPYA SREE PAVAN JAGARAPU
e-mail(s): phari2@binghamton.edu
e-mail(s): djagar1@binghamton.edu


PURPOSE:

[
  To learn Visitor pattern in Java
]

PERCENT COMPLETE:

[
 100
]

PARTS THAT ARE NOT COMPLETE:

[
 NONE
]

BUGS:

[
 None
]

FILES:

[
  Input file has to be given as one of the command line arguments for the program to compile
]

SAMPLE OUTPUT:

[
Average Performance time for one iteration is 61ms
The total number of words is: 6749
The most frequently used word is: [of]
The frequency of most frequently used word is: 248
The number of characters (without whitespaces) is: 36522
The word "the" occurs the following times: 242
]

TO COMPILE:

[
  Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=the

## To create tarball for submission
ant -buildfile src/build.xml tarzip

## To untar the tarball submitted
ant -buildfile src/build.xml untarzip

]

TO RUN:

[
## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile src/build.xml run
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<PHANIKIRAN HARI>
<DEEDEPYA SREE PAVAN JAGARAPU>

[
  
]

ACKNOWLEDGEMENT:

[
 
]

CHOICE OF DATA STRUCTURE[

BST as it follows a in order approach in inserting strings into tree and is very efficient in searching


]