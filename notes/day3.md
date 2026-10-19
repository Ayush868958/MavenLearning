# Maven Notes — Day 3
## Topic: Remote Repository, Local Repository and `.m2`

### 1. What is a Repository?

A repository is a place where files or software packages are stored and managed.

In Maven, repositories store Java libraries and dependencies that a project needs.

There are three main types of Maven repositories:

1. Local Repository
2. Remote Repository
3. Central Repository

### 2. What is a Local Repository?

A Local Repository is stored on our own computer.

Maven downloads dependencies and stores them locally so they can be reused in future builds.

On Windows, the default location is:

```text
C:\Users\YourUsername\.m2\repository
```

Example: When Maven downloads Spring Security Core, its files can be stored in the local repository.

### 3. What is the `.m2` Folder?

The `.m2` folder is Maven's default user-specific configuration and storage directory.

It commonly contains:

- `repository/` — Stores downloaded dependencies and other Maven artifacts.
- `settings.xml` — Can contain custom Maven settings, repository configurations, proxy settings and credentials.

Default Windows location:

```text
C:\Users\YourUsername\.m2\
```

The `.m2` folder is usually hidden because its name starts with a dot.

### 4. What is a Remote Repository?

A Remote Repository is a repository hosted on a remote server.

Maven downloads required dependencies from remote repositories when they are not already available locally.

Examples include:

- Maven Central
- Organization-specific Maven repositories
- Private artifact repositories

### 5. What is Maven Central?

Maven Central is a widely used public repository for Java libraries and dependencies.

For example, a project may use libraries such as:

- Spring Security Core
- Apache Commons Lang
- Jackson

Maven can download these libraries from configured repositories, including Maven Central when the artifacts are available there.

### 6. How Does Maven Download a Dependency?

Suppose `pom.xml` contains a dependency for Spring Security Core.

The general process is:

1. We declare the dependency in `pom.xml`.
2. Maven checks the local repository for the required artifact.
3. If it is missing, Maven tries configured remote repositories.
4. Maven downloads the required artifact and its dependencies when needed.
5. The downloaded files are stored in the local repository.

This helps avoid repeatedly downloading the same dependency.

### 7. What Is a Dependency?

A dependency is an external library that our project needs.

Example:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.21.0</version>
</dependency>
```

Here:

- `groupId` identifies the organization or group.
- `artifactId` identifies the library.
- `version` specifies the library version.

Maven uses this information to locate the required artifact.

### 8. Important Difference: Git Remote vs Maven Remote Repository

**Git Remote Repository**
- Stores project source code and Git history.
- Example: A repository hosted on GitHub.
- Common commands: `git push`, `git pull`, `git clone`.

**Maven Remote Repository**
- Stores Java libraries and build artifacts.
- Example: Maven Central.
- Maven uses it to resolve project dependencies.

These are different concepts, even though both use the term “remote repository.”

### 9. Useful Commands

Open the local Maven repository in Windows PowerShell:

```powershell
explorer "$env:USERPROFILE\.m2\repository"
```

Compile the Maven project:

```powershell
mvn compile
```

Package the Maven project:

```powershell
mvn package
```

### 10. Important Points to Remember

- `pom.xml` declares project dependencies.
- A Maven repository stores libraries and build artifacts.
- The local repository is usually inside `.m2/repository`.
- Remote repositories provide artifacts over a network.
- Maven Central is a commonly used public remote repository.
- The `.m2` directory should not normally be committed to GitHub.
- The `pom.xml` file allows Maven to resolve the dependencies on another computer.

### Summary

Maven manages dependencies using repository configuration. It stores downloaded artifacts in the local repository and can obtain missing artifacts from configured remote repositories. The `.m2` directory contains the default local repository and user-specific Maven settings.