# Day  — JUnit 5 Without Maven

## 1. What is JUnit?

JUnit is a Java testing framework used to test whether our Java code works as expected.

For example, suppose we create a calculator:

```java
public int add(int a, int b) {
    return a + b;
}
```

We expect `add(10, 5)` to return `15`. JUnit helps us verify this automatically.

**Why use JUnit?**
- Detect bugs early.
- Verify methods automatically.
- Avoid checking every result manually.
- Make code safer to modify.

## 2. What is Unit Testing?

Unit testing means testing a small, individual unit of code, usually a method.

Example:

```java
int result = calculator.add(10, 5);
```

We can test whether the result is `15`.

Here, the `add()` method is the unit being tested.

## 3. What is JUnit 5?

JUnit 5 is a modern generation of the JUnit testing framework.

Its architecture has three main parts:

- **JUnit Platform:** Provides the foundation for launching testing frameworks and test execution.
- **JUnit Jupiter:** Provides the programming model and APIs used to write JUnit 5 tests.
- **JUnit Vintage:** Supports running older JUnit 3 and JUnit 4 tests on the JUnit Platform.

For our practice, we use JUnit Jupiter.

## 4. Setting Up JUnit Without Maven

In a normal Java project, we can add JUnit manually instead of using Maven.

Steps performed:

1. Created a Java project named `JUnitWithoutMaven`.
2. Downloaded `junit-platform-console-standalone-1.14.4.jar`.
3. Placed the JAR file inside the `lib` folder.
4. Added the JAR as a dependency in IntelliJ IDEA.
5. Created Java classes inside `src`.
6. Wrote test methods using JUnit Jupiter.
7. Ran the tests using IntelliJ IDEA.

### Project Structure

```text
JUnitWithoutMaven/
├── .gitignore
├── lib/
│   └── junit-platform-console-standalone-1.14.4.jar
├── src/
│   ├── Calculator.java
│   └── CalculatorTest.java
└── Junitwithoutmaven.iml
```

The exact project structure may vary depending on IntelliJ settings.

## 5. Creating the Calculator Class

File: `Calculator.java`

```java
public class Calculator {

    public int divide(int a, int b) {
        return a / b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
```

This class contains three methods:

- `divide()` divides two integers.
- `add()` adds two integers.
- `subtract()` subtracts the second integer from the first.

Note: Integer division truncates the fractional part. Division by zero with integers throws an `ArithmeticException`.

## 6. Writing JUnit Tests

File: `CalculatorTest.java`

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();

        int result = calculator.divide(10, 2);

        assertEquals(5, result);
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 5);

        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();

        int result = calculator.subtract(10, 5);

        assertEquals(5, result);
    }
}
```

The `testSubtract()` method is an additional practice exercise; add `subtract()` to `Calculator.java` before running it.

## 7. Understanding the Important JUnit Components

### `@Test`

```java
@Test
public void testAdd() {
    // Test logic
}
```

`@Test` tells JUnit that the method is a test method.

### `assertEquals()`

```java
assertEquals(15, result);
```

It checks whether the expected value matches the actual value.

General form:

```java
assertEquals(expected, actual);
```

Examples:

```java
assertEquals(15, calculator.add(10, 5));
assertEquals(5, calculator.divide(10, 2));
```

If the expected and actual values differ, the test fails.

### `@Test` import

```java
import org.junit.jupiter.api.Test;
```

This imports the JUnit Jupiter `@Test` annotation.

### `assertEquals` import

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
```

This static import lets us call `assertEquals()` directly without writing `Assertions.assertEquals()`.

## 8. Maven vs. JUnit Without Maven

| Feature | With Maven | Without Maven |
|---|---|---|
| Dependency declaration | `pom.xml` | Manually add JAR |
| Test execution | `mvn test` | IntelliJ Run button or configured JUnit Console |
| Dependency management | Maven handles dependencies | Developer manages JARs |
| Build automation | Easier to automate | More manual configuration |
| Team collaboration | Easier to reproduce setup | More setup work for each developer |

**Important:** JUnit does not require Maven. Maven is a build and dependency management tool; JUnit is a testing framework.

Also, running tests from IntelliJ uses IntelliJ's configured test runner. Running the standalone JAR directly from a terminal is a separate option.

## 9. Understanding Test Results

A successful run can show:

- Green check mark
- Test status: Passed
- No failures
- Process finished with exit code `0`

A failed assertion can show an error similar to:

```text
AssertionFailedError:
expected: <10>
but was: <5>
```

This means the test expected `10`, but the actual method returned `5`.

A failed test does not necessarily mean the program cannot run. It means the test's expectation did not match the observed result.

## 10. What Is `assertThrows()`?

Sometimes we expect a method to throw an exception instead of returning a value.

For example, integer division by zero throws `ArithmeticException`.

JUnit can verify this:

```java
import static org.junit.jupiter.api.Assertions.assertThrows;

@Test
public void testDivideByZero() {
    Calculator calculator = new Calculator();

    assertThrows(
        ArithmeticException.class,
        () -> calculator.divide(10, 0)
    );
}
```

`assertThrows()` passes when the expected exception is thrown. If no exception is thrown, or an incompatible exception is thrown, the test fails.

This is an additional exercise to try after the basic tests.

## 11. Key Takeaways

1. JUnit automates testing of Java code.
2. Unit testing checks individual units of code.
3. JUnit 5 uses the JUnit Platform, Jupiter, and Vintage components.
4. `@Test` identifies test methods.
5. `assertEquals(expected, actual)` checks results.
6. JUnit can be configured without Maven by adding its JAR manually.
7. Maven makes dependency management and build automation easier.
8. `assertThrows()` verifies expected exceptions.
9. A test failure helps identify a mismatch between expected and actual behavior.

## 12. Practice Tasks

- [ ] Add and test a `subtract()` method.
- [ ] Change an expected value intentionally and observe a failed test.
- [ ] Test division by zero using `assertThrows()`.
- [ ] Explain the difference between JUnit and Maven in your own words.

## Interview Questions

**Q1. What is JUnit?**

JUnit is a Java testing framework used to write and execute automated tests.

**Q2. What is unit testing?**

Unit testing verifies an individual unit of code, such as a method, independently.

**Q3. What is the purpose of `@Test`?**

It marks a method as a test method recognized by the JUnit test engine.

**Q4. What is the difference between JUnit and Maven?**

JUnit is a testing framework; Maven manages project builds, dependencies, and build lifecycle tasks.

**Q5. Can JUnit be used without Maven?**

Yes. We can configure JUnit manually using its JAR files or another suitable build setup.

**Q6. What does `assertEquals()` do?**

It compares an expected value with an actual value and fails the test if they do not match.

**Q7. What does `assertThrows()` do?**

It verifies that executing a particular operation throws the expected exception.

---

**Today's achievement:** Configured JUnit 5 manually in a Java project, wrote calculator tests, and learned the fundamentals of assertions and test execution.
