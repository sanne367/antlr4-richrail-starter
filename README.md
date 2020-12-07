# ANTLR4 RichRail Starter
A starter project for the RichRail command line DSL.
This project is part of an assignment for
Patterns and Frameworks at the Hogeschool Utrecht.

# How do I set this up?
* The project uses Java 11, but you can change this in `pom.xml` if need be
* Install packages using Maven (see `pom.xml`)
* This automatically generates
 the required classes through ANTLR4
* For manually updating/regenerating the required classes
 based on the grammar, you can let Maven execute the
 antlr4:antlr4 command

# How to start?
`Main.java` is the entry point. This sets up
all the required wagons.
It requests input, tokenizes it, parses it
and walks over the ParseTree using our custom 
`RichRailCli`, which is a Listener that *extends*
the `RichRailBaseListener` generated by ANTLR4. The
Listener listens to `enter` and `exit` events.

To configure our own actions, we need to override
the relevant methods.

# What is going on?
ANTLR4 generates Parser, Visitor and Listener
classes based on the `RichRail.g4` grammar
found in `src/main/antlr4/rail.parser`.
These classes contain context and methods needed
for visiting the nodes in the parse tree or
for listening to events when entering or exiting
the nodes in a parse tree.
In this example, a Visitor approach has been used.

The `RichRailCli` is a custom class that extends
the base listener generated by ANTLR4. In this custom class,
we can overwrite the steps taken when traversing each node
in a certain expression.

# Where are all the classes?
ANTLR4 generates these class files
in the target directory. You can use the
maven commands defined in the `pom.xml`.

The generated classes are output to 
the `target/generated-sources/antlr4` directory
and reside in the project's `rail.parser` package.
This is due to the standard configuration of ANTLR4,
matching the location of the grammar file (`src/antlr4/rail.parser`).
No further configuration required.

# Author
Alex Rothuis: [@arothuis](https://twitter.com/arothuis)

[arothuis.nl](http://arothuis.nl)
