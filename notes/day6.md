# Maven Learning — Day 6
## Topic: Maven Revision, Build Lifecycle & Local Repository

### 1. What is Maven?
Apache Maven is a build automation and dependency management tool mainly used for Java projects.

**Maven helps us to:**
- Manage external libraries and dependencies.
- Compile Java source code.
- Run the test phase.
- Package applications into JAR or WAR files.
- Install artifacts into the local Maven repository.

### 2. Understanding `pom.xml`
`pom.xml` stands for Project Object Model. It contains project information, dependencies, build configuration and plugin settings.

Important elements:

- `groupId`: Identifies the organization or project group.
- `artifactId`: Name of the project or artifact.
- `version`: Current version of the artifact.
- `packaging`: Output type, such as `jar` or `war`.
- `dependencies`: External libraries required by the project.
- `properties`: Shared configuration values.

### 3. Maven Build Commands

| Command | Purpose |
|---|---|
| `mvn clean` | Removes the generated `target/` directory. |
| `mvn compile` | Compiles main Java source code. |
| `mvn test` | Runs the test phase. |
| `mvn package` | Packages the project into a JAR or WAR. |
| `mvn install` | Installs the artifact and POM in the local repository. |
| `mvn dependency:tree` | Displays the project's dependency hierarchy. |

**Important:** Maven lifecycle phases are cumulative. For example, `mvn package` runs the earlier phases in the default lifecycle before packaging.

### 4. Understanding the `target/` Directory
Maven generates build output inside `target/`.

Common contents include:
- `classes/`: Compiled main Java classes.
- `test-classes/`: Compiled test classes, if present.
- `maven-status/`: Compiler-related status information.
- `maven-archiver/`: Packaging metadata.
- `*.jar`: The generated JAR artifact.

The exact contents depend on the project and plugins.

### 5. What Happens During `mvn install`?
When we execute:

```powershell
mvn install
```

Maven runs the required build lifecycle phases and installs the resulting artifact and its POM in the local repository.

Default local repository location on Windows:

```text
C:\Users\<username>\.m2\repository
```

For the project `com.ayush:MavenLearning:1.0-SNAPSHOT`, the artifact is installed under:

```text
.m2/repository/com/ayush/MavenLearning/1.0-SNAPSHOT/
```

This allows other local Maven projects to use that artifact as a dependency, provided it exposes the classes or resources they need.

**Remember:** `mvn install` does not publish the artifact to GitHub or a remote Maven repository.

### 6. Maven Dependency Management
Dependencies are declared inside the `dependencies` element of `pom.xml`.

Example:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.21.0</version>
</dependency>
```

Maven resolves the required library and makes it available on the appropriate classpath.

### 7. Local Repository vs Remote Repository

**Local repository**
- Stored on your computer.
- Caches downloaded dependencies.
- Stores artifacts installed using `mvn install`.

**Remote repository**
- Hosted on a server.
- Can provide dependencies to multiple developers.
- Artifacts can be published to a configured repository using `mvn deploy`.

### 8. Practical Commands for Revision

Run these commands from your Maven project directory:

```powershell
mvn clean
mvn compile
mvn package
mvn install
jar tf target\MavenLearning-1.0-SNAPSHOT.jar
```

The `jar tf` command lists the contents of the generated JAR.

### 9. Key Interview Questions

1. What is Maven, and why is it used?
2. What is the purpose of `pom.xml`?
3. What is the difference between `mvn package` and `mvn install`?
4. What is the difference between a local and remote repository?
5. What is the purpose of the `target/` directory?
6. What is a Maven dependency?
7. Does `mvn clean` delete your Java source files?
8. What is the difference between `mvn install` and `mvn deploy`?

### 10. Next Learning Goals
- Maven plugins and plugin configuration.
- Dependency scopes and transitive dependencies.
- Maven Wrapper.
- Dependency conflict troubleshooting.
- Using a locally installed library from another Maven project.
- Integrating Maven with a Spring Boot application.

## Day 6 Summary
Maven automates common Java build tasks, manages dependencies, and packages projects. The most important practical commands are `mvn clean`, `mvn compile`, `mvn package`, and `mvn install`.
