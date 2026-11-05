# Java Development – Complete Learning Notes

**Learning Track:** Java → Maven → Git/GitHub → JUnit  
**Purpose:** Revision, practical development and interview preparation

---

# PART 1: JAVA

## 1. What is Java?

Java is a high-level, object-oriented programming language used to develop applications.

Examples:
- Enterprise applications
- Banking software
- Web applications
- Android applications
- Backend systems

### How Java works

1. Developer writes Java code in `.java` file.
2. Java compiler (`javac`) converts source code into bytecode.
3. Bytecode is stored in `.class` files.
4. JVM executes the bytecode.

**Flow:**

`Java Source Code → Compiler → Bytecode → JVM → Execution`

### JDK, JRE and JVM

- **JDK:** Java Development Kit. Contains tools required to develop Java applications, including compiler.
- **JRE:** Java Runtime Environment. Provides the runtime environment for Java applications.
- **JVM:** Java Virtual Machine. Executes Java bytecode.

Remember:
- JDK = Development
- JRE = Runtime environment
- JVM = Execution engine

## 2. Class and Object

### Class
A class is a blueprint or template used to create objects.

### Object
An object is an instance of a class.

Example:

```java
class Student {
    String name;
    int rollNo;

    void study() {
        System.out.println("Student is studying");
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.name = "Aman";
        s1.rollNo = 101;

        s1.study();
    }
}
```

Here:
- `Student` is a class.
- `s1` is an object reference.
- `new Student()` creates an object.
- `name` and `rollNo` are instance variables.
- `study()` is a method.

## 3. Constructor

A constructor initializes an object.

Important points:
- Constructor name must match class name.
- Constructor does not have a return type.
- It executes when an object is created.
- A no-argument constructor takes no parameters.

Example:

```java
class Student {
    String name;

    Student() {
        name = "Aman";
    }
}
```

Parameterized constructor:

```java
class Student {
    String name;

    Student(String n) {
        name = n;
    }
}
```

If you define a parameterized constructor, Java does not automatically provide the default no-argument constructor.

## 4. Packages

A package is used to organize related classes.

Example:

```java
package tools;

public class Calc {
    public int add(int a, int b) {
        return a + b;
    }
}
```

Using another package:

```java
import tools.Calc;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();
        System.out.println(c.add(10, 20));
    }
}
```

Benefits:
- Organizes code.
- Avoids naming conflicts.
- Provides access control.

Important: Package names are case-sensitive.

## 5. Access Modifiers

Access modifiers control where a class member can be accessed.

| Modifier | Accessibility |
|---|---|
| `private` | Same class |
| Default | Same package |
| `protected` | Same package and subclasses, subject to Java access rules |
| `public` | Everywhere |

Example:

```java
class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }
}
```

We cannot directly access `