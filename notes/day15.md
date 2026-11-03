3. Difference Between Git and GitHub

Git

GitHub

Version Control System

Online hosting platform

Installed on a computer

Accessed through the internet

Tracks code changes

Hosts Git repositories

Works offline

Requires internet for online operations

Uses commits to save snapshots

Uses push and pull to exchange changes

4. What is Git Configuration?

git config is used to configure Git settings.

Git needs the developer's identity to associate commits with an author.

Set username

git config --global user.name "Your Name"

Set email

git config --global user.email "your-email@example.com"

Check username

git config --global user.name

Check email

git config --global user.email

View all configurations

git config --list

Configuration Levels

System: Applies to all users on the computer.

Global: Applies to all repositories of the current user.

Local: Applies only to the current repository.

5. What is Git Status?

git status displays the current state of the working directory and staging area.

It tells us:

Which files are modified.

Which files are untracked.

Which files are staged.

Whether there are uncommitted changes.

Command:

git status

Common outputs:

working tree clean: No uncommitted changes.

modified: An existing file has been changed.

untracked: A new file is not yet tracked by Git.

6. What is Git Log?

git log displays the commit history of a repository.

It provides:

Commit ID

Author name

Commit date

Commit message

Command:

git log

Useful variations

Display commits in one line:

git log --oneline

Display commit history as a graph:

git log --oneline --graph

Display the latest two commits:

git log -2

7. Important Git Commands Learned

Command

Purpose

git --version

Check installed Git version

git config

Configure Git settings

git config --list

Display Git configuration

git status

Check repository status

git log

View commit history

git log --oneline

View compact commit history

cls

Clear Windows CMD

clear

Clear Git Bash or Linux terminal

8. Basic Git Workflow

The basic Git workflow:

Working Directory – Make changes to project files.

Staging Area – Select changes for the next commit.

Local Repository – Save changes as commits.

Commands:

git add .
git commit -m "Your commit message"

9. Important Commands for GitHub

Command

Purpose

git remote add origin URL

Connect a remote repository

git push

Upload commits to remote

git pull

Fetch and integrate remote changes

git clone URL

Copy a remote repository locally

10. Key Takeaways

Git and GitHub are different.

Git is a version control tool.

GitHub hosts Git repositories online.

git config sets developer identity and preferences.

git status checks the current repository state.

git log displays previous commits.

A commit is a snapshot of the project's tracked state.