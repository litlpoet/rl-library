**Table of Contents**


---


# Introduction #

RL-Library is basically a large collection of agents, environments, experiments, and packages that have been shared by members of the reinforcement learning community.

The main thread that links all of these projects together is that they are compatible with [RL-Glue](http://glue.rl-community.org).

There are several ways that you could potentially use the RL-Library. We have provided (and will explain below) our vision (the _cohesive view_) of how the different projects in RL-Library can be used together.

However, you can do whatever you like.  You could, for example, just download a particular project so that you can see/improve/change its source code.

# The Cohesive View of RL-Library #
Right now, this only applies to Java projects, because that is mostly what we have in the RL-Library at the moment.

Most Java projects in RL-Library rely on some common scripts, [ant buildfiles](http://ant.apache.org/), and libraries.  Instead of keeping separate copies of all these things in source control (which could be crazy):
```bsh

#Useful ant scripts go here
rl-library/system/common/ant

#Supporting Libraries (like [http://glue.rl-community.org RL-Glue] and [http://rl-viz.googlecode.com RL-Viz] are kept here)
rl-library/system/common/libs

#The JAR files for built java agents/environments go here
rl-library/products
```

When you download a Java project from the RL-Library, and you unpack it, it will give you these directories, plus a new directory specific for this project.

**IMPORTANT NOTE**
All of the examples below have copy + paste-able instructions that have been brought in from the appropriate download pages.  Be warned: the instructions in THIS tutorial do not get updated as the version numbers of the actual download do.  What I mean is that if you follow these instructions to the letter, you are downloading OLD versions of everything.  You should actually follow the links to the download pages and follow the instructions there.  I just have them here also to give you a full picture of the steps involved.

## Example - Downloading Mountain Car ##
Let's say you are new to RL-Library, and you want to download [Mountain Car](MountainCarJava.md), because everyone loves Mountain Car.

You would go to the MountainCarJava download page, and follow the instructions.  At time of writing, you would do the following:
```
#Create a directory for your rl-library.
mkdir rl-library

#First, download the file.  Depending on your platform, you might have to do this manually with a web browser. 

#If you are on Linux, you can use wget which will download MountainCar-Java-R1088.tar.gz for you
wget http://rl-library.googlecode.com/files/MountainCar-Java-R1088.tar.gz

#Copy the download to your local rl-library folder
cp MountainCar-Java-R1088.tar.gz rl-library/
cd rl-library

#Unpack the project
tar -zxf MountainCar-Java-R1088.tar.gz

#Clean up
rm MountainCar-Java-R1088.tar.gz
```

Ok, at this point, if you look at what you have in the rl-library directory, you'll see something like the following:

  * MountainCar-Java-[R1088](https://code.google.com/p/rl-library/source/detail?r=1088)
    * build.xml
    * LICENSE.txt
    * README.txt
    * src (I'll spare you the details of what's in here)

  * products
    * MountainCar.jar
  * system
    * common
      * ant
        * more stuff here...
      * libs
        * more stuff here...

Now, if you wanted to run the Mountain Car environment with RL-Glue, you could type:
```
java -jar products/MountainCar.jar
```

And you would see the familiar Java RL-Glue Codec startup lines:
```
RL-Glue Java Environment Codec Version: 2.05 (Build:793M)
	Connecting to 127.0.0.1 on port 4096...
```

I should not that all of this works even without the RL-Glue codec installed, because that codec is in the `system/common/libs` directory, and the `MountainCar.jar` has information in it's Manifest file that tells the environment where to look for it.

## Adding an Agent ##
Unfortunately, without an agent and experiment, `MountainCar.jar` is not doing us much good.  So, let's get an agent, the [Random Java agent](RandomAgentJava.md).

Again, we'll follow the directions on that project's download page.

```
#We can skip creating the rl-library directory because we have it already
cd rl-library
#If you are on Linux, you can use wget which will download RandomAgent-Java-R1093.tar.gz for you
wget http://rl-library.googlecode.com/files/RandomAgent-Java-R1093.tar.gz

tar -zxf RandomAgent-Java-R1093.tar.gz

#Clean up
rm RandomAgent-Java-R1093.tar.gz
```

At the end of these steps, you will see some new things have been added to your rl-library directory structure (new things are **bold**):
  * MountainCar-Java-[R1088](https://code.google.com/p/rl-library/source/detail?r=1088)
    * build.xml
    * LICENSE.txt
    * README.txt
    * src (and more below)
  * **RandomAgent-Java-[R1093](https://code.google.com/p/rl-library/source/detail?r=1093)**
    * **build.xml**
    * **LICENSE.txt**
    * **README.txt**
    * **src** (and more below)

  * products
    * MountainCar.jar
    * **RandomAgent.jar**
  * system
    * common (more below)

Now, we have both an environment **and** an agent in our products folder.  Using this same technique, we can pick and choose exactly what agents and environments we want from the rl-library.

Like the environment, you should be able to run the agent:
```
java -jar products/RandomAgent.jar
```

And you would see the familiar Java RL-Glue Codec startup lines:
```
RL-Glue Java Agent Codec Version: 2.05 (Build:793M)
	Connecting to 127.0.0.1 on port 4096...
```

## Adding An Experiment ##
Now that we have an agent and an environment, lets download an experiment and actually run something!

For this guide, we'll download the [sample experiment for RL-Glue in Java](SampleExperimentRLGlueJava.md).  This experiment has hard-coded references to the [MountainCarJava](MountainCarJava.md) and [RandomAgentJava](RandomAgentJava.md) projects, so it will keep life easy for us.

```
cd rl-library
#If you are on Linux, you can use wget which will download SampleExperimentRLGlue-Java-R1068.tar.gz for you
wget http://rl-library.googlecode.com/files/SampleExperimentRLGlue-Java-R1068.tar.gz

tar -zxf SampleExperimentRLGlue-Java-R1068.tar.gz

#Clean up
rm SampleExperimentRLGlue-Java-R1068.tar.gz
```

At the end of these steps, you will see some new things have been added to your rl-library directory structure (new things are **bold**):
  * MountainCar-Java-[R1088](https://code.google.com/p/rl-library/source/detail?r=1088)
    * build.xml
    * LICENSE.txt
    * README.txt
    * src (and more below)
  * RandomAgent-Java-[R1093](https://code.google.com/p/rl-library/source/detail?r=1093)
    * build.xml
    * LICENSE.txt
    * README.txt
    * src (and more below)

  * **SampleExperimentRLGlue-Java-[R1068](https://code.google.com/p/rl-library/source/detail?r=1068)**
    * **README.txt**
    * **run.bash**
    * **src**
      * **SampleExperiment.java**

Now, because MountainCarJava and RandomAgentJava are hard-coded into SampleExperimentRLGlueJava, we can run a simple experiment.

```
cd SampleExperimentRLGlue-Java-R1068
bash run.bash
```

You should see something like the following:
```
Starting up RL-glue - PID=11954
RL-Glue Version 3.0, Build 909
RL-Glue is listening for connections on port=4096
RL-Glue Java Agent Codec Version: 2.05 (Build:793M)
	Connecting to 127.0.0.1 on port 4096...
RL-Glue Java Environment Codec Version: 2.05 (Build:793M)
	Connecting to 127.0.0.1 on port 4096...
RL-Glue Java Experiment Codec Version: 2.06 (Build:801M)
	Connecting to 127.0.0.1 on port 4096...
	RL-Glue :: Agent connected.
	Agent Codec Connected
	RL-Glue :: Environment connected.
	Environment Codec Connected
	Experiment Codec Connected
	RL-Glue :: Experiment connected.
Running: 10 with a cutoff each of: 10000 steps.
Episode: 1	 steps: 10000
Episode: 2	 steps: 10000
Episode: 3	 steps: 10000
Episode: 4	 steps: 10000
Episode: 5	 steps: 10000
Episode: 6	 steps: 10000
Episode: 7	 steps: 10000
Episode: 8	 steps: 10000
Episode: 9	 steps: 4257
Episode: 10	 steps: 10000

-----------------------------------------------

Number of episodes: 10
Average number of steps per episode: 9425.7
Average return per episode: -9424.7
-----------------------------------------------
```

As you can see, the RandomAgentJava is not very good at Mountain Car!

# Beyond This Guide #
This is a very simple, quick-start guide to see how you can leverage the existing projects in the RL-Library.  In the near future, we will publish a guide with some more fancy examples, including one that runs in **internal** mode, without network sockets (much faster per step).

We will also be publishing detailed instructions about how you can get your own projects building with the RL-Library build system, and how you can make them available through this project even if the source code is hosted elsewhere.