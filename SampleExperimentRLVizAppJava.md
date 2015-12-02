<a href='Hidden comment: 
This README.txt is also the Wiki page that is hosted online at:
Experiment

So, it is in Wiki Syntax.  It"s still pretty easy to read.
'></a>




# RL-Library Java Version of RLViz Application Sample Experiment #

For full details, please visit:
http://code.google.com/p/rl-library/wiki/SampleExperimentRLVizAppJava

Download Link: [SampleExperimentRLVizApp-Java-R1207.tar.gz](http://rl-library.googlecode.com/files/SampleExperimentRLVizApp-Java-R1207.tar.gz) [(Details)](http://code.google.com/p/rl-library/downloads/detail?name=SampleExperimentRLVizApp-Java-R1207.tar.gz)

This project is licensed under the Apache 2.0 License.
See LICENSE.txt for details.


## Important Notes ##
This experiment dynamically loads agents and/or environments from JAR files in your `rl-library/products` directory.
For things to work right, it would be best if you had one of each in there.  We suggest (if you are starting out)
the [MountainCarJava](MountainCarJava.md) environment and [Tile Coding Sarsa Lambda Java](EpsilonGreedyTileCodingSarsaLambdaJava.md) agent.

This experiment is actually part of the [graphical experiment getting started guide](GraphicalExperimentsWithRLViz.md), so please consult that document for full
details and explanation.

## Using This Download ##
Before diving into this, you may want to check out [the getting started guide](GettingStarted.md).

This download can be used to augment your existing local RL-Library (if you have one), or as the basis to start a new one.

### This Is Your First Project ###
```
#Create a directory for your rl-library. Call it whatever you like.
mkdir rl-library
```
That's all you have to do special for the **first time** you download a rl-library component.  Continue on now
to the next section.

### Adding To An Existing RL-Library Download ###

```
#First, download the file.  Depending on your platform, you might have to do this manually with a web browser. 

#If you are on Linux, you can use wget which will download SampleExperimentRLVizApp-Java-R1207.tar.gz for you
wget http://rl-library.googlecode.com/files/SampleExperimentRLVizApp-Java-R1207.tar.gz

#Copy the download to your local rl-library folder (whatever it is called)
cp SampleExperimentRLVizApp-Java-R1207.tar.gz rl-library/
cd rl-library

#This will add any project-specific things necessary to system and products folders
#It will also create a folder for this particular project
tar -zxf SampleExperimentRLVizApp-Java-R1207.tar.gz

#Clean up
rm SampleExperimentRLVizApp-Java-R1207.tar.gz
```

## Running This Experiment ##
This experiment will automatically recompile itself each time you run it.

To run it, simple execute the `run.bash` script that was bunded with the project.

```
>$ cd SampleExperimentRLVizApp-Java-R1207
>$ bash run.bash

```

This will start up the agent, environment, and experiment program needed to run this example, and will also start the rl\_glue executable socket server if necessary.


## Getting Help ##
Please send all questions to either the current maintainer (below) or to the
[RL-Library mailing list](http://groups.google.com/group/rl-library).


## Authors ##
  * [Brian Tanner](http://research.tannerpages.com)

### Current Maintainer ###
  * [Brian Tanner](http://research.tannerpages.com)
  * btanner@rl-community.org
  * http://research.tannerpages.com



