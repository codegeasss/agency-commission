# Requirements

Java 8 runtime environment

# Testing

The tests are in `CommissionTest.java` file which gets initiated from `main` method inside `App.java`.
In practice these can be covered using JUnit tests but I wrote the tests as simple manual tests so that it can be 
run directly using jar file without any need for dependencies or compiling the files.

To run tests:
The project is already packaged into a jar file and running the jar file would execute all the tests. jar file is checked 
into the root folder of the project. Execute the following command from the root folder to run the jar file
```
java -jar agency-commission.jar
```
