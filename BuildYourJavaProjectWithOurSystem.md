**Table of Contents**


---


# Introduction #
This page will explain how you can either check-out or `svn:externals` the RL-Library system/common folder into your own projects (on your local computer or your own open-source project), to leverage some of the goodies that we use in the RL-Library build system.

Basically, it gives you a very quick way to build RL-{Glue/Viz} compatible agents and environments that can easily be shared with others.  It is also an important step towards getting your own agents and environments listed in RL-Library, even if the source code is generally hosted elsewhere.

# Background #
In general, building Java projects so that they are portable and convenient to use is not complicated, but it does require some background knowledge, and there are some sticky issues that can cause frustration.

We have invested considerable time streamlining our own build processes for the RL-Library and related projects, and we'd like to share them with you.


# Starting Simple: The Random Agent #

The first example of using the RL-Library build system will be to re-create the RandomAgent from the RL-Library, but with a different name and a different package structure.

Because this is the simple version, we will not use `svn:externals`, we'll just take a snapshot of the current build system. In general, using `svn:externals` might be preferable because you instantly can get fixes and improvements to the build system in your own code.  On the other hand, if we break something, you might break also.



## Creating the Directory Structure ##
**Note:** This tutorial was created on a Ubuntu machine.  All of the directions should work for Mac OS X also. Windows under Cygwin might work.

You'll need subversion installed for this tutorial.  If you ask me, I could create a `.tar.gz` file starter-kit with the necessary files.

You'll also need [Apache Ant](http://ant.apache.org) (makefiles for Java) installed.

```
#Create the folder for our project
mkdir myRandomAgent
cd myRandomAgent

#Create a system folder
mkdir system

#Create a source folder
mkdir src

#Create a folder for the products we build
mkdir products
```

Now you have the basic structure for the project.

## Downloading the Common Files from RL-Library ##
We'll grab the `common` directory from the RL-Library project, it has most of the magic scripts and libraries that we will need for our own project.

```
#Download a copy of the common folder to our system folder
svn export http://rl-library.googlecode.com/svn/trunk/system/common system/common
```

This will download a few different files. Your directory structure afterwards will look like the following (new things in bold);

  * src
  * products
  * system
    * **common**
      * **ant** (more below)
        * **build-common.xml**
        * **build-targets.xml**
        * **predefined-target-aliases.xml**
        * **sample-build.xml**


  * **libs** (more below)
    * **rl-glue-java** (more below)
    * **rl-viz** (more below)
  * **scripts** (more below)


## Getting the Source Code ##
We are going to "borrow" the source code from the RandomAgentJava project in RL-Library.  However, we don't want all of the project, only the main source file.  We also want to use a different directory structure from that project, so that it's clear how the build scripts work.

We'll call our Java package `com.examples`, and our class will be called `TutorialGuy`.

First, make the directories:
```
mkdir src/com
mkdir src/com/examples
```

Now, get the source file from RL-Library, but rename it to TutorialGuy.java.

```
svn export http://rl-library.googlecode.com/svn/trunk/projects/agents/randomAgentJava/src/org/rlcommunity/agents/random/RandomAgent.java src/com/examples/TutorialGuy.java
```

Now, unfortunately, the Random agent is actually a mildly complicated RL-Viz environment, so there is a bit of surgery to do:
  * Change the package from org.rlcommunity.agents.random to com.examples
  * In the class definition, change the class name from RandomAgent to TutorialGuy
  * In the class definition, change it to NOT implement HasImageInterface
  * Change both RandomAgent constructors to be TutorialGuy constructors
  * Find the `public static void main(String[] args)` method, and make it so that inside the AgentLoader constructor you are making new TutorialGuy() and NOT new RandomAgent()
  * Remove the `public URL getImageURL()` around line 150.
  * Save :)


## Getting build.xml ##
Now we want a copy of the [ant](http://ant.apache.org/) `build.xml` file.  If you've worked with `Makefiles` before, `build.xml` is like a `Makefile` for Java.

```
cp system/common/ant/sample-build.xml build.xml
```

Now, lets edit `build.xml`.

You should read through the comments carefully, they are hopefully useful.  The specific changes you should make:
**Set project name to "TutorialGuy"** Set "baseLibraryDir" to "."
**Set "main.package.name" to "com.examples/"** Set "java.main.class" to "com.examples.TutorialGuy"
**Save!**

## Building Your Project ##
Now, you should be able to type:
```
ant build
```

And, with a little luck, you now have a new `TutorialGuy.jar` file in the `products` folder.  Run run it!

```
java -jar products/TutorialGuy.jar
```

Output:
```
RL-Glue Java Agent Codec Version: 2.05 (Build:793M)
	Connecting to 127.0.0.1 on port 4096...
```

Success!  Now you can give your Jar file to all of your friends to put in their RL-Library `products` folders to use your agent!  If you don't know what I'm talking about, please check out the [getting started guide](GettingStarted.md).

The process for building an environment is identical.

# Going Further #
There are many more advanced things you can do with the RL-Library build system. Stay tuned for more!

Also, we take requests!