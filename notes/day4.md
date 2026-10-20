# Maven Notes — Day 4
## Topic: Maven Build Lifecycles

## 1. What is a Maven Build Lifecycle?

A Maven Build Lifecycle is a predefined sequence of phases used to build, test, package, verify and deploy a project.

Maven has three main built-in lifecycles:

1. Default Lifecycle
2. Clean Lifecycle
3. Site Lifecycle

Each lifecycle contains multiple phases that perform specific tasks.

## 2. Default Lifecycle

The Default Lifecycle manages the main build process of a project.

Important phases in their usual order:

```text
validate → compile → test → package → verify → install → deploy
```

### 2.1 validate

Command:

```bash
mvn validate
```

Purpose:
- Checks whether the project is sufficiently correct for the build to proceed.
- Performs basic project validation.

### 2.2 compile

Command:

```bash
mvn compile
```

Purpose:
- Compiles the project's main Java source code.
- Generates `.class` bytecode files.
- Compiled files are usually placed inside `target/classes`.

### 2.3 test

Command:

```bash
mvn test
```

Purpose:
- Runs the project's configured unit tests.
- Test source files are usually stored in `src/test/java`.
- A failing test can cause the build to fail.

### 2.4 package

Command:

```bash
mvn package
```

Purpose:
- Packages compiled code and resources into a distributable artifact.
- A project with JAR packaging typically produces a `.jar` file.
- A project with WAR packaging typically produces a `.war` file.

Example output:

```text
target/MavenLearning-1.0-SNAPSHOT.jar
```

### 2.5 verify

Command:

```bash
mvn verify
```

Purpose:
- Performs verification and configured quality checks.
- May include integration tests or other checks when configured.

### 2.6 install

Command:

```bash
mvn install
```

Purpose:
- Runs the preceding required build phases.
- Installs the project's artifact into the local Maven repository.
- The default local repository is usually located at `.m2/repository`.

This allows other Maven projects on the same computer to use the installed artifact as a dependency.

### 2.7 deploy

Command:

```bash
mvn deploy
```

Purpose:
- Publishes the project's artifact to a configured remote Maven repository.
- Allows other developers or projects to obtain the artifact.
- May require repository configuration, permissions and credentials.

Note: Maven `deploy` is different from `git push`. It publishes build artifacts, not Git source-code history.

## 3. Clean Lifecycle

The Clean Lifecycle removes generated files from previous builds.

Its important phases are:

| Phase | Purpose |
|---|---|
| `pre-clean` | Performs configured tasks before cleaning |
| `clean` | Removes generated build output |
| `post-clean` | Performs configured tasks after cleaning |

Command:

```bash
mvn clean
```

The clean plugin usually removes the project's `target/` directory.

It does not normally delete the original source code in `src/`.

## 4. Site Lifecycle

The Site Lifecycle generates and can publish project documentation.

Its important phases are:

| Phase | Purpose |
|---|---|
| `pre-site` | Runs configured tasks before site generation |
| `site` | Generates project documentation |
| `post-site` | Runs configured tasks after site generation |
| `site-deploy` | Publishes the generated site to a configured destination |

Command:

```bash
mvn site
```

Site generation may require the relevant Maven Site Plugin and configuration.

The `site-deploy` phase does not automatically publish a website to GitHub Pages.

## 5. Important Rule: Lifecycle Phases Are Cumulative

When a lifecycle phase is requested, Maven executes the preceding phases in that lifecycle, in order.

For example:

```bash
mvn test
```

Runs the required phases up to `test`, including:

```text
validate → compile → test
```

Similarly:

```bash
mvn package
```

Runs the required preceding phases up to `package`.

```bash
mvn install
```

Runs the preceding Default Lifecycle phases up to `install`.

```bash
mvn deploy
```

Runs the preceding Default Lifecycle phases up to `deploy`.

If a required phase fails, Maven normally stops that build rather than continuing to later phases.

Note: `clean` belongs to a separate lifecycle. Running `mvn package` does not automatically run `clean`.

## 6. Difference Between the Three Lifecycles

| Lifecycle | Main purpose |
|---|---|
| Default | Builds, tests, packages, verifies, installs and deploys artifacts |
| Clean | Removes generated build output |
| Site | Generates and publishes project documentation |

## 7. Maven Plugins and Lifecycle Phases

Maven plugins perform the actual tasks associated with lifecycle phases.

Examples:

| Plugin | Purpose |
|---|---|
| `maven-compiler-plugin` | Compiles Java source code |
| `maven-surefire-plugin` | Runs unit tests |
| `maven-jar-plugin` | Creates JAR packages |
| `maven-clean-plugin` | Removes generated build output |
| `maven-install-plugin` | Installs artifacts into the local repository |
| `maven-deploy-plugin` | Publishes artifacts to a remote repository |

Maven's default lifecycle bindings can associate phases with plugin goals, so every plugin does not always need to be declared manually.

## 8. Common Commands for Practice

```bash
mvn clean
mvn validate
mvn compile
mvn test
mvn package
mvn verify
mvn install
```

Run these commands from the directory containing the project's `pom.xml`.

To clean the project and then package it:

```bash
mvn clean package
```

This runs the Clean Lifecycle's `clean` phase and then the Default Lifecycle up to `package`.

## 9. Quick Revision

- `validate`: Checks basic project correctness.
- `compile`: Compiles main Java source code.
- `test`: Runs configured unit tests.
- `package`: Creates a JAR, WAR or other configured package.
- `verify`: Runs verification and configured quality checks.
- `install`: Stores the artifact in the local Maven repository.
- `deploy`: Publishes the artifact to a remote Maven repository.
- `clean`: Removes generated build output.
- `site`: Generates project documentation.
- `site-deploy`: Publishes the generated documentation to a configured destination.

## Conclusion

Maven provides three main lifecycles: Default, Clean and Site. The Default Lifecycle manages the main build process, the Clean Lifecycle removes generated output, and the Site Lifecycle handles project documentation. Maven plugins execute the tasks associated with lifecycle phases.