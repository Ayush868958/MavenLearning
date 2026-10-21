# Day 5 — Maven Practical: Clean, Package, Install & Local Repository

## 1. What I Learned Today

Today I practised Maven commands using my existing `MavenLearning` project.

Project location:

```text
D:\MavenLearning\MavenLearning
```

Project coordinates:

- **groupId:** `com.ayush`
- **artifactId:** `MavenLearning`
- **version:** `1.0-SNAPSHOT`
- **packaging:** `jar`

## 2. Git Commands — Saving Notes

I added my Maven lifecycle notes, committed them and pushed them to GitHub.

```powershell
git add notes/day4.md
git commit -m "Maven life cycle"
git push
```

The commit and push completed successfully.

**Important:** `git add` stages files, `git commit` saves a snapshot in local Git history, and `git push` uploads commits to the remote Git repository.

## 3. Practical 1 — `mvn clean`

Command:

```powershell
mvn clean
```

### What happened?

Maven deleted the generated `target/` directory.

The build output was removed, but my original source code in `src/` remained safe.

**Key point:** `clean` belongs to Maven's Clean Lifecycle. It is separate from the Default Lifecycle.

## 4. Practical 2 — `mvn package`

Command:

```powershell
mvn package
```

### What happened?

Maven executed the required earlier phases, including resource processing, compilation and the test phase, before packaging the project.

My build completed successfully and generated:

```text
target/
├── classes/
├── test-classes/
├── maven-archiver/
└── MavenLearning-1.0-SNAPSHOT.jar
```

The exact contents of `target/` can vary by project and plugins.

### Understanding the output

- `target/classes/` contains compiled main Java classes.
- `target/test-classes/` contains compiled test classes, when present.
- `target/MavenLearning-1.0-SNAPSHOT.jar` is the generated JAR.

The build showed a compiler warning recommending `--release 21` rather than only `-source 21` and `-target 21`. This warning did not stop the build, but the compiler configuration can be improved later.

**Key point:** `package` creates the configured artifact, such as a JAR or WAR. It does not automatically install the artifact into the local Maven repository.

## 5. Practical 3 — `mvn install`

Command:

```powershell
mvn install
```

### What happened?

Maven ran the required build phases and successfully installed both the POM and JAR into my local Maven repository.

The output confirmed these locations:

```text
C:\Users\AYUSH\.m2\repository\com\ayush\MavenLearning\1.0-SNAPSHOT\
```

Files installed:

```text
MavenLearning-1.0-SNAPSHOT.pom
MavenLearning-1.0-SNAPSHOT.jar
```

### Why is this useful?

Installing an artifact locally makes it available for other Maven projects on the same computer to resolve as a dependency, provided its coordinates and dependency requirements match.

**Important:** `mvn install` does not install the application into Windows. It installs the Maven artifact into the local repository.

## 6. Local Maven Repository

The default local repository on my computer is:

```text
C:\Users\AYUSH\.m2\repository
```

It stores downloaded dependencies and locally installed artifacts.

To open my installed project artifact's folder in Windows PowerShell:

```powershell
explorer "$env:USERPROFILE\.m2\repository\com\ayush\MavenLearning\1.0-SNAPSHOT"
```

The `.m2/repository` directory is normally not committed to GitHub. Each developer can maintain their own local Maven repository.

## 7. Difference Between `package` and `install`

| Command | Purpose |
|---|---|
| `mvn clean` | Removes generated build output. |
| `mvn compile` | Compiles main Java source code. |
| `mvn test` | Executes the test phase and configured tests. |
| `mvn package` | Creates the configured JAR/WAR artifact. |
| `mvn install` | Runs the required build phases and installs the artifact locally. |
| `mvn deploy` | Publishes the artifact to a configured remote Maven repository. |

Remember: Maven phases are cumulative. Running a later phase executes the required earlier phases in the Default Lifecycle.

## 8. Useful Commands for Practice

```powershell
mvn clean
mvn compile
mvn test
mvn package
mvn clean package
mvn install
mvn dependency:tree
mvn -version
```

To inspect the contents of my generated JAR:

```powershell
jar tf target\MavenLearning-1.0-SNAPSHOT.jar
```

The `jar tf` command lists the files contained in the archive.

## 9. What I Need to Learn Next

- Inspect the JAR contents and understand compiled classes.
- Understand direct and transitive dependencies using `mvn dependency:tree`.
- Locate dependencies in `.m2/repository`.
- Use my installed artifact from a second Maven project.
- Learn dependency scopes and Maven Wrapper.
- Investigate build failures and test reports.

## Final Summary

Today I successfully ran `mvn clean`, `mvn package` and `mvn install`.

I learned that Maven removes generated build output, compiles Java code, packages the project into a JAR, and installs the artifact into the local Maven repository.

**Practical status:** `BUILD SUCCESS` for clean, package and install.