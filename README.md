# Mancala

This repository contains the files for three modules:
- Object orientated programming: make your own implementation of the mancala game.
- Model view controller: build a website for your own mancala game (or use the sloppy default implementation).
- CI/CD: run your tests automatically when pushing code to Gitlab.


## Repository structure

- Main folder (this folder): contains the files relevant for the whole project. For example the Gradle-wrapper files, the .gitignore, and this readme.
- api/: contains the files for the API or service layer of your application.
- api/src/main/java/mancala/api: contains the web endpoints.
- api/src/main/java/mancala/api/models: contains the web endpoints.
- domain/: contains the files that model the business domain (game rules). This is the folder you develop your OO mancala case in.

## Java project structure

A Java project is generally structured as follows:

```
build.gradle
src/
   main/
       (package)/
            (Java files)
   test/
       (package)/
            (Java test files)
```

In the project root folder (for example, the domain/ folder), a project definition is found. As we use Gradle, we have a build.gradle file. For Maven (another commonly used build tool), we would have a pom.xml. These files contain roughly the same: the project metadata and its dependencies. The build tool can then resolve those dependencies by downloading them from an online registry or compile related projects and link the resulting jar files.

A build tool also makes sure multiple Java files inside the same project are compiled in one go. Basically it acts as a wrapper around the compiler. You can invoke the compiler manually by typing `javac mancala/domain/Foo.java mancala/domain/Bar.java` over and over, or let your build tool generate and execute the command for you.

To tell the build tool which files to compile, the above structure is used. In src/main/ you place your application code, the actual implementation of the game rules. You should also adhere to the Java file structure, meaning that your folder structure should match your package definition (mancala/domain/) and your filename should match your class name (Foo.java). In src/test/ you place the files that test your main code. By convention, the test file structure mimics the main file structure (mancala/domain/FooTest.java).

## Using Gradle

You can either install Gradle on your machine and use the installation or use the Gradle wrapper files found next to this README. Replace the `./gradlew` command with `gradle` if using the globally installed Gradle or `.\gradlew.bat` if you're running the Windows batch script.

```bash
# Building
./gradlew build
# Testing (will fail with the initial code)
./gradlew test
# Running (only relevant for the MVC case)
./gradlew run
```

If you run the program, you will notice the build "progress" is stuck on 87% or so. That means your application is running and Gradle is waiting for it to succeed. You can ignore the progress bar when running the application; it should print some lines when it's ready.

## Assignment

For the lecture, see [the drive](https://drive.google.com/drive/u/0/folders/1PvC-HS8ty3mdtSaNdR5rt5-GwL-5_LaY).

The global goal is to make a web front-end to your mancala back-end. A stub has been made. In api/src/test you can find examples of how you can test the api endpoints.

- Familiarise yourself with the repository. Get the servers running and make sure you can connect to both servers. Enter two names in the boxes. You should see a "TODO" screen.
- Show the mancala game when it is started.
- If you want to use your own implementation, reference your implemenation in the `MancalaImpl` class.
- Build the API endpoint to make a move.
- Show the winner as soon as the game is over.
- Optionally, allow for a "revenge" option in which two players can play again.
- Optionally, allow an ongoing game to continue after a page refresh.