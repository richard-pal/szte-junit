### What is UnitTesting?

#### Unit testing...

- validates that the individual units of source code are working properly. A Unit is the smallest testable part of an application. In Java, it is usually an individual function (or at most a class)
- is part of the development work
- is a (tipically) automated test-type
- performed as a white-box testing

#### Benefits of Unit Testing

- reduces test complexity:
  - tests the smallest parts
  - tests parts in isolation (by removing dependencies from other code parts)

- tests "early":
  - even when the complete software is not yet ready
  - detects unintended changes early (like breaking existing functionality when refactoring the
    existing code or when implementing new features)

- tests "often":
  - unit tests are quick in execution
  - unit test execution is automated, therefore easily repeatable (even very frequently)
  - unit tests fit nicely into the build process (Continuous Integration)

### What is JUnit?

- JUnit is the de facto standard unit testing library for Java
- Easy to use, open-source
- separation of application code and test code
- grouping and categorization of tests
- integrated into IDEs
- supports annotations

#### What are the Assertions?

A Unit Test **must fail** if and only if the behaviour that is experienced during the test does not match with the expected outcome.

In practice, the tested functions are called with a well-planned combination of test-input data (arguments) and the returned value/exception is validated (compared with the expected outcome).

To save time, the validation checks are not implemented repetitively with if-else-throw... etc statements, but Assertion functions/frameworks are used instead.

See the `CalculatorTest...` files for examples of the different approaches.

### How to run the example test code of this repository?

#### With Eclipse

1. use `File/Import/Maven/Existing Maven Projects` to import the project from your local filesystem

2. Wait, till all Java dependencies are downloaded

3. Right click on the test package or on the individual test class under the test package, and select `Run as/JUnit test`

#### with VSCode

1. install the `Extension Pack for Java`

2. Wait, till all Java dependencies are downloaded (status bar shows: "Java: Ready")

3. In the Unit test file's editor, use the "play" icon left to the test class and the test functions.

4. Locate the "Testing" view. Locate the test package or a test class and use the "play" icon to execute the tests. 

#### with IntelliJ Idea

1. Import the extracted folder as a Maven project

2. Wait, till all Java dependencies are downloaded (watch the status bar)

3. In the Unit test file's editor, use the "play" icon left to the test class and the test functions.

4. In the Project browser view, locate the src/test/java package or a test class, rightclick and use the "Run tests" feature to execute the tests. 


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
4. when finally all tests pass OK - it results in confidence in the quality of the new feature + already existing code did not get broken
5. clean up the growing codebase by refactoring the code (to help maintainability, readability)
6. continue the development according to the cycle


### How to remove code-dependencies during testing a class?

The scope of a unit test is restricted to **one** class (or ideally **one** method).

However, most classes call other classes' functionality. To eliminate that complexity in tests and to
prevent the "side-effects" of those classes, we simply replace these dependencies during the test with some dummy implementation (we call them "mocks"). Mocked functions return whatever we intend to have during the testcase execution.

It is a common strategy to simulate different cases with these mocks (like returning different values, throwing Exception, etc. in the replaced functions).

Using mocks in tests also facilitate Test-Driven-Development and helps in situations when we have to do coding+testing work that relies on classes/interfaces that are not yet implemented.

### What is test-code-coverage?

Via measuring the tests' “code coverage” you can determine which lines of the tested class got
executed during the run of the unit tests.

To visualize tested and untested code within your project code coverage tools are used (such as Emma or Cobertura).

This helps to write better tests and to ensure that the most relevant parts of the code do not remain untested.


### Exercise

Look into the `org.junittraining.exercise` packages. 

1. Find the `IPAddressCalculations` interface and check its Javadoc
2. Plan the tests for this interface. Consider as many usecases and patterns with different inputs as possible to achieve a complete coverage.
3. Implement the test according to your plans
4. Execute the tests on the dummy implementation `IPAddressCalculationsHorribleImpl`
5. Summarize the issues you have found with your tests (test report)
6. Repoint your tests to execute on the yet empty `IPAddressCalculationsImpl` implementation
7. Start the implementation in this class, and meanwhile execute your tests repeatedly to see how you are progressing. 
8. You are done if all your tests pass. 

Congratulations, you have experienced the basics of unit testing in Java!

