# Git Notes — 29 October 2026

## 1. What is Git?

Git ek **Version Control System (VCS)** hai jo code mein hone wale changes ko track karta hai.

Example: Tum Java mein ek Bank Account Management System bana rahe ho.

- Day 1: Basic account class banayi.
- Day 2: Deposit aur withdraw methods add kiye.
- Day 3: Bug fix kiya.

Git ki help se tum dekh sakte ho ki kis file mein kya change hua, kab hua aur kis commit mein hua.

## 2. What is GitHub?

GitHub ek online platform hai jahan Git repositories host kar sakte ho.

| Git | GitHub |
|---|---|
| Version control tool | Online code hosting platform |
| Local computer par use hota hai | Internet par repositories host karta hai |
| Changes aur history track karta hai | Code share aur collaborate karne deta hai |

**Yaad rakho:** Git aur GitHub same cheez nahi hain.

## 3. Important Git Terms

- **Repository (Repo):** Project aur uski Git history.
- **Working Directory:** Jahan tum apni files edit karte ho.
- **Staging Area:** Changes jo next commit ke liye select kiye gaye hain.
- **Commit:** Changes ka saved snapshot.
- **Branch:** Main code se alag development line.
- **Remote:** Online repository ka reference, jaise GitHub.
- **Push:** Local commits ko remote par bhejna.
- **Pull:** Remote changes ko fetch aur integrate karna.
- **Clone:** Remote repository ki local copy banana.

## 4. Git Workflow

```text
Working Directory
       |
       | git add
       v
 Staging Area
       |
       | git commit
       v
 Local Repository
       |
       | git push
       v
 GitHub Repository
```

## 5. Important Git Commands

### Check Git installation

```bash
git --version
```

Git ka installed version show hota hai.

### Initialize a repository

```bash
git init
```

Current project folder mein Git repository initialize karta hai.

### Check project status

```bash
git status
```

Batata hai kaunsi files modified, untracked ya staged hain.

### Add files to staging

```bash
git add Main.java
```

Ek specific file staging area mein add hoti hai.

```bash
git add .
```

Current directory ke changes stage karta hai, subject to Git ignore rules.

### Commit changes

```bash
git commit -m "Add account management feature"
```

Staged changes ka commit banata hai.

### View commit history

```bash
git log --oneline
```

Commits ki short history show karta hai.

### Check changes

```bash
git diff
```

Unstaged changes ka difference dikhata hai.

```bash
git diff --staged
```

Staged changes ka difference dikhata hai.

## 6. GitHub Remote Commands

### Connect a remote repository

```bash
git remote add origin https://github.com/USERNAME/REPOSITORY.git
```

`origin` remote ka common naam hai.

### Check remote URL

```bash
git remote -v
```

Configured remote URLs dikhata hai.

### Push commits to GitHub

```bash
git push -u origin main
```

Local `main` branch ke commits ko remote `origin` ki `main` branch par push karta hai. `-u` future mein upstream tracking set karta hai.

**Important:** Agar branch ka naam `master` hai, toh command mein `main` ki jagah `master` use karna hoga.

## 7. Branches

Branch ka use alag feature par kaam karne ke liye hota hai.

```bash
git branch
```

Local branches list karta hai.

```bash
git switch -c feature-login
```

Nayi branch banata hai aur us par switch karta hai.

```bash
git switch main
```

`main` branch par switch karta hai.

```bash
git merge feature-login
```

Current branch mein `feature-login` ke changes merge karta hai.

## 8. Clone, Pull and Fetch

### Clone a repository

```bash
git clone https://github.com/USERNAME/REPOSITORY.git
```

Remote repository ko local computer par copy karta hai.

### Pull remote changes

```bash
git pull
```

Remote changes fetch karke current branch mein integrate karta hai.

### Fetch remote changes

```bash
git fetch
```

Remote updates download karta hai, lekin current branch mein automatically merge nahi karta.

## 9. .gitignore

`.gitignore` file Git ko batati hai ki kaunse untracked files ko ignore karna hai.

Example:

```gitignore
*.class
target/
.env
```

- `*.class` — Java compiled class files ignore karta hai.
- `target/` — Maven build output folder ignore karta hai.
- `.env` — environment configuration file ignore karta hai.

Sensitive credentials ko GitHub par kabhi commit mat karo. `.gitignore` pehle se tracked file ko automatically untrack nahi karta.

## 10. Daily Practical Workflow

Java ya Maven project mein code change kar