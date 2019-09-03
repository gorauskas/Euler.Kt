# Euler

Solutions to the Project Euler problems written in Kotlin.

Clone this repo and then run the following from the command line:

    ./gradlew clean build
    java -jar build/libs/euler.jar -p <problem number>

## Usage

    Usage: euler [OPTIONS]
    
    Options:
      -p, --problem INT  Specify the problem/solution number you want to run
      -v, --verbose      Verbose outputs the problem statement and the solution
      -V, --version      Show the version and exit
      -h, --help         Show this message and exit

## Tests

Alternatively, there is a full set of unit tests written with jUnit that can be
run by invoking `gradlew` at the root of the project, like so:

    ./gradlew clean test

## How it works...

The main program in the `Euler` class will try to import one of the solution
classes from `com.gorauskas.euler.solutions` based on the problem number passed
in via the command line. From that package, it will load a class called `Euler#`
where `#` is for the problem number. If the user requests verbose output, the
program calls the `problem` property of the loaded `Euler#` class and then
calls the `answer` property.

All `Euler#` classes are implemented using the `EulerInterface` common interface for all
classes. This is the key construct that allows classes to be loaded and executed
dynamically.