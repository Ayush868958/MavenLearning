# JUnit vs Maven — Complete Notes

## 1. Introduction

JUnit aur Maven Java development mein commonly use hote hain, lekin dono ka purpose alag hai.

- **JUnit:** Java code ko test karne ke liye testing framework.
- **Maven:** Java project ki dependencies manage karne, code build karne aur build lifecycle automate karne wala build management tool.

Simple example:

Suppose hum Calculator application bana rahe hain.

- Calculator ka addition method sahi answer de raha hai ya nahi — ye JUnit check karega.
- Project ki required libraries download karna, code compile karna aur tests execute karna — ye Maven automate kar sakta hai.

**Yaad rakhna:** JUnit aur Maven competitors nahi hain. Ye ek saath kaam kar sakte hain.

---

## 2. What is JUnit?

JUnit ek Java testing framework hai jo automated tests likhne aur execute karne mein help karta hai.

### Why do we use JUnit?

1. Code ki correctness verify karne ke liye.
2. Bugs jaldi identify karne ke liye.
3. Manual testing kam karne ke liye.
4. Code changes ke baad existing functionality check karne ke liye.
5. Regression testing mein help ke liye.

### Example

Suppose humne ye method likha:

```java
public int add(int a, int b) {
    return a + b;
}
```

Ab humein verify karna hai ki `add(10, 5)` ka result `15` hai.

JUnit test:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 5);

        assertEquals(15, result);
    }
}
```

### Important JUnit concepts

**`@Test`**

JUnit ko batata hai ki method ek test method hai.

**`assertEquals(expected, actual)`**

Expected aur actual result ko compare karta hai.

```java
assertEquals(15, result);
```

Agar `result` ki value `15` hai, assertion pass hogi. Agar value different hai, assertion fail hogi.

**`assertThrows()`**

Check karta hai ki given operation expected exception throw karta hai ya nahi.

Example:

```java
assertThrows(
    ArithmeticException.class,
    () -> calculator.divide(10, 0)
);
```

Ye tab pass hoga jab integer division operation `ArithmeticException` throw karega.

---

## 3. What is Maven?

Maven ek build automation aur dependency management tool hai. Ye Java projects ko build aur manage karna easy banata hai.

### Why do we use Maven?

1. Dependencies download aur manage karne ke liye.
2. Java code compile karne ke liye.
3. Tests run karne ke liye.
4. JAR/WAR packages generate karne ke liye.
5. Standard build lifecycle follow karne ke liye.
6. Team members ke liye project setup consistent rakhne ke liye.

### What is `pom.xml`?

`pom.xml` ka full form hai **Project Object Model**.

Ye Maven project ki main configuration file hai. Ismein project details, dependencies, plugins aur build configuration define ki ja sakti hain.

Example:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ayush</groupId>
    <artifactId>Calculator</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.12.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

*Note: Ye JUnit dependency ka illustrative configuration example hai. Real project mein apne chosen JUnit version aur compatible Maven test plugin configuration ko verify karna chahiye.*

### Dependency kya hoti hai?

Dependency ek external library ya component hota hai jiski functionality hum apne project mein use karte hain.

For example, JUnit ek dependency ho sakta hai.

Maven mein dependency declare karne ke baad Maven required artifacts ko configured repositories se resolve karne ki koshish karta hai.

---

## 4. JUnit vs Maven — Main Difference

| Feature | JUnit | Maven |
|---|---|---|
| Type | Testing framework | Build automation and dependency management tool |
| Main purpose | Code test karna | Project build aur manage karna |
| Tests likhta hai? | Haan | Nahi |
| Assertions provide karta hai? | Haan | Nahi |
| Dependencies manage karta hai? | Nahi | Haan |
| Code compile karta hai? | Nahi, khud build tool nahi hai | Haan, compiler plugin ke through |
| Tests execute karwa sakta hai? | Test framework execution provide karta hai | Suitable test plugin ke through |
| Configuration | Test classes aur annotations | `pom.xml` aur build configuration |
| Example | `@Test`, `assertEquals()` | `mvn test`, `mvn package` |

### One-line difference

**JUnit tests likhne aur verify karne ke liye hai; Maven dependencies manage karne aur build process automate karne ke liye hai.**

---

## 5. JUnit Without Maven

JUnit use karne ke liye Maven mandatory nahi hai.

Hum normal Java project mein JUnit JAR manually add karke bhi tests likh sakte hain.

### Steps

1. JUnit standalone JAR download karna.
2. JAR ko project ke `lib` folder mein rakhna.
3. IntelliJ mein