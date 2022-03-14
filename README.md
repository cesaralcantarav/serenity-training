# Getting web testing with Serenity and Cucumber 4 

This tutorial show you how to get started with web testing using Serenity and Cucumber 4.

## Get the code

Git:

    git clone https://github.com/cesaralcantarav/serenity-training.git
    cd serenity-training

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                                Test runners and supporting code
      + abilities
      + hooks
      + interactions                             
      + questions
      + stepdefinitions
      + tasks
      + userinterfaces
      + utils
    + resources
      + features                          Feature files              

```

### On macOS
### Install brew
Execute on terminal:

    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"

### Install java
Execute on terminal:

    brew install adoptopenjdk8

If you can't install from terminal, you can download adoptopenjdk8 on

https://adoptopenjdk.net/

Add on environments variables:

    export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home

### Install maven
Execute on terminal:

    brew install maven

### Run project
Execute on terminal:

    mvn clean install

Reimport project on maven

Run project from CucumberTestSuite class, before set the tag to runner the tests. This tags should be into features.

For example:

tags = {"@tests"}

### Run tests on differents environments
Execute on terminal:

    mvn clean verify -Denvironment=dev

### Run tests on mobile

#### Install Appium

Step 1:

Install node:

For Windows:

Download and install the executable https://nodejs.org/es/download/package-manager/#windows

For macOS:

Open the terminal and execute

    brew install node

Step 2:

Open the terminal and execute:

    npm install -g appium

#### Appium setup for Android

Step 1:

Download Android Studio and install Android SDK.

* Don't forget to establish ANDROID_HOME as an environment variable

Step 2:

Create a Android emulator, the recommendation is to use Genymotion

https://www.genymotion.com/download/


#### Appium setup for iOS

Step 1:

Download xcode

Step  2:

Auhorize the use of iOS simulator

    npm install -g authorize-ios

Step 3:

Install carthage

    brew install carthage     

#### Install appium-doctor

Step 1:

Open the terminal and execute:

    npm install appium-doctor -g

Step 2:

Run `appium-doctor --android` or `appium-doctor --ios`

If you have errors, fix everyone.

#### Run appium

Open the terminal and execute the following, indicate the path of our driver. For example:

    appium --chromedriver-executable /Users/cesar.alcantara/Downloads/chromedriver81.exe

Set the appium capabilities on serenity.properties

### Generete the Serenity report

To generate the Serenity report, you should be run on terminal

    mvn clean 

and run the test from CucumberTestSuite, then execute

    mvn serenity:aggregate 

Another way to generate the report is executing

    mvn clean verify 
    