### What is UnitTesting?

#### Unit testing...

- validates that the individual units of source code are working properly
- a Unit is the smallest testable part of an application.
- in Java it is usually an individual function (or at most a class)
- is part of the development work
- is a (tipically) automated test-type
- performed as a white-box testing

#### Benefits of Unit Testing

- reduces test complexity:
  - testing the smallest parts
  - testing parts in isolation (by removing dependencies from other code parts)

- test early:
  - even when the complete software is not yet ready
  - detect unintended changes early (like breaking existing functionality when refactoring the
    code/implementing new features)

- test often:
  - unit tests are quick in execution
  - unit test execution is automated therefore easily repeatable (even very frequently)
  - unit tests fit nicely into the build process (Continuous Integration)

### What is JUnit?

- JUnit is the de facto standard unit testing library for Java
- Easy to use, open-source
- separation of application code and test code
- grouping and categorization of tests
- integrated into IDEs
- supports annotations

#### What are the Assertions?

A Unit Test **must fail** if and only if the behaviour that is experienced during the test does not match with the expected one.

In practice the tested functions are called with a well-planned combination of test-input data and the returned value/exception is validated.

To save time, these checks are not implemented repetitively with if-else-throw... etc statements, but Assertion functions/frameworks are used.

See the `CalculatorTest...` files for examples of the different approaches.

### How to run the example code of this repository?

1. In Eclipse, use `File/Import/Maven/Existing Maven Projects` to import the project from your local filesystem

2. Wait, till all Java dependencies are downloaded

3. Right click on the test package or on the individual test class under the test package, and select `Run as/JUnit test`


### What is the Test-Driven-Development approach?

Design the software with testing in mind:

- The development of new software features is performed in small cycles:

  - Requirement turned into test-cases
  - Software is developed to fulfill the tests
  - The new feature is only considered to be ready if all tests pass

The Test-Driven Development cycle:

1. first, add only the tests of the new feature
2. the new tests fail (as the feature is not yet implemented)
3. write the code of the new feature
4. all tests pass OK - confidence in the quality of the new feature + already existing code did not get
broke
5. clean up the growing codebase by refactoring the code (to help maintainability, readability)
6. continue the development according to the cycle



### What is test-code-coverage?

Via measuring the tests' “code coverage” you can determine which lines of the tested class got
executed during the run of the unit tests.

To visualize tested and untested code within your project
code coverage tools are used (such as Emma or Cobertura).

This helps to write better tests and to ensure that the most relevant parts of the code do not remain untested.


### Exercise

Look into the `org.junittraining.exercise` packages. 

1. Find the `IPAddressCalculations` interface and check its Javadoc
2. Plan the tests for this interface. Consider as many usecases and patterns with different inputs as possible to achieve a complete coverage.
3. Implement the test according to your plans
4. Execute the tests on the dummy implementation `IPAddressCalculationsHorribleImpl`
5. Summarize the issues you have found with your tests
6. Repoint your tests to execute on the yet empty `IPAddressCalculationsImpl` implementation
7. Start the implementation in this class, and meanwhile execute your tests repeatedly to see how you are progressing. 
8. You are done if all your tests pass. 

Congratulations, you have experienced the basics of unit testing in Java!

