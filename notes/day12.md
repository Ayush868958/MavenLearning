
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
