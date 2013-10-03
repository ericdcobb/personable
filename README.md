#Personable

A Trivial Programming Language Example Built with Antlr4 and Maven.

##Building

	mvn clean install

##Running

```
java -jar target/personable-1.0-SNAPSHOT.jar personCommands.txt
```

This will run the following commands:

```
define Cobb
define Leela

blame Cobb
blame Leela

hug Cobb
hug Leela

//Do some removing
remove Cobb

//Should log an exception
blame Cobb

remove Leela
```

*Expected Output:*

```
++ Defining Cobb
[Cobb]
++ Defining Leela
[Cobb, Leela]
++ It's all Cobb's fault.
[Cobb, Leela]
++ It's all Leela's fault.
[Cobb, Leela]
Giving Cobb a hug.
[Cobb, Leela]
Giving Leela a hug.
[Cobb, Leela]
[Leela]
++ You must define a person before blaming him or her.
[Leela]
[]
```