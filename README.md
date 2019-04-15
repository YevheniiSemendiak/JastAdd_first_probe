# Reference Attribute Grammars with JastAdd

If there are questions regarding the exercise, please refer to Johannes Mey
at johannes.mey@tu-dresden.de. However, before asking questions, please read the
JastAdd reference manual:

* <http://jastadd.org/web/documentation/reference-manual.php>

## Building and Running JastAdd with Gradle

This exercise uses gradle to get dependencies and build and test its solutions.
Gradle is bundled for Linux/Mac and Windows and the bundled version should be
used with `./gradlew` or `gradlew.bat`, respectively.


The following gradle tasks are helpful to solve the tasks:

* `run` runs the main method in class `de.tudresden.inf.st.most.ExerciseMain`
* `test` runs the tests. There are tests that should succeed after a
 particular task has been solved.
* `DrAST` is an editor that displays syntax trees. It can be used to load and
 display `json` or `exp` files. Attribute values and reference attribute
 references are shown.
* `RagDoll` is a javadoc variant for JastAdd.

## Structure of the Exercise

All JastAdd files that must be edited are in the `src/main/jastadd` folder. The contents are as follows:

* `expressions.ast` is the grammar
* `expressions.flex` contains the jflex lexer specification
* `expressions.parser` contains the beaver parser specification
* `Printing.jrag` contains the pretty-printer
* `NameResolution.jrag` should contain the name resolution
* `Evaluation.jrag` should contain an evaluation attribute
* `Optimization.jrag` should contain the rewrites and their helper attributes
* `Analysis.jrag` should contain the unused definitions attribute
* `ASTPrinting.jadd` contains helper methods to display the AST

Additionally, the main class `de.tudresden.inf.st.most.ExerciseMain` can be
modified to test the code. Please be careful when editing, because DrAST
relies on a certain structure (in particular, on field `DrAST_root_node`
containing an AST root node).

## Editing the Lexer and Parser

No additional help is given for editing the lexer and parser specifications as
this is more or less trivial copy-and-paste. If more help is required, please
refer to the websites:
* <http://www.jflex.de/>
* <http://beaver.sourceforge.net/>

## Submitting the Exercise

Please submit `src/main/` and its subfolders.