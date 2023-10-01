# OpenNote
## About
Text editors are something that we use everyday to perform everyday tasks. It's pretty unremarkable. But, what if we can make text editors do special things? What if we can customize a text editor to fit our needs? This is where OpenNote comes in. OpenNote is an open-sourced, crowd-sourced text editor where the sky is the limit.

## Purpose
The idea behind this project is sort of like a sleeper PC build; where the computer itself is an old-fashioned 90s PC, but inside it packs the latest graphics cards and CPUs. In this way, this app uses the Metal Java Swing theme and the design is purposely understated. However, under the hood, one can build in Alexa integration, smart suggestions, text-to-speech, you name it. 

## Compiling and Building Application
This is a Java application. Follow the steps below to compile and build the application. 
    Ensure that you have atleast JDK 11 installed. It can be installed here: https://www.oracle.com/java/technologies/downloads/#java8

    In the root of your repo run the javac command , this will compile the application
    To build the application you can run the java OpenNote

This will allow you to run your application. 

## Screenshots
![Alt text](https://raw.githubusercontent.com/nich227/OpenNote/master/screenshot.PNG)

## TroubleShooting
Some common questions and troubleshooting:
    Issues building and compiling:
        - Check the PATH variable of your JDK, ensure that your path is set to the bin folder
        - Ensure you have atleast JDK 11 or higher
        - Compile and build within your IDE (Vscode or JetBrains is recommended)
        - mvn compile: to run the maven compilation 

## Technical info
Built in NetBeans 9.0 with JDK 11