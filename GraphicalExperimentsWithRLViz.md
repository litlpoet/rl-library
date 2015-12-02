**Table of Contents**


---


# Introduction #

This tutorial explains how you can use the RLVizApp to dynamically load an agent and environment, pick their parameters, and watch them interact with a graphical visualizer.

This tutorial is best done as a follow-up to the [basic getting started guide](GettingStarted.md).  At the completion of that other tutorial you will have a `rl-library` directory with the RandomAgentJava and MountainCarJava agent and environment setup already.

If you install the [Tile Coding Sarsa Lambda](EpsilonGreedyTileCodingSarsaLambdaJava.md) agent, you will also be able to visualize the value function as it is learned by the agent.

This experiment runs in _external_ mode, which means that the agent, environment, and experiment all communicate via sockets through the `rl_glue` executable socket server. Note: this means you need to have the [RL-Glue core project](http://glue.rl-community.org/Home/rl-glue) installed.  There will be an upcoming tutorial about how to run in internal mode, so that everything stays inside a single Java virtual machine, and you don't even need RL-Glue Core.

**IMPORTANT NOTE**
The instructions below have copy + paste-able instructions that have been brought in from the appropriate download pages.  Be warned: the instructions in THIS tutorial do not get updated as the version numbers of the actual download do.  What I mean is that if you follow these instructions to the letter, you are downloading OLD versions of everything.  You should actually follow the links to the download pages and follow the instructions there.  I just have them here also to give you a full picture of the steps involved.

# How RLVizApp Works #
RLVizApp is a very fancy experiment program.  It uses the Agent/Environment messaging system and a higher-level protocol to send information back and forth between the agents and environments.

In fact, to do dynamic-loading of agents and environments, RLVizApp uses a **fake** agent and environment called _AgentShell_ and _EnvironmentShell_.  AgentShell, for example, is a valid RL-Glue agent, but it is not a learning agent.   It actually looks to a directory on the hard disk for other agents, and then creates a list of available agents that can be queried by RLVizApp.  When RLVizApp selects an agent, it sends a message to the AgentShell, which uses Java reflection to load the agent.  From now on, when RLVizApp calls RL-Glue commands like agent\_init, AgentShell will receive the command and pass it on to the actual agent that was loaded.  The EnvironmentShell works analogously.



# Getting the RLVizApp Experiment #
Assuming you have installed an agent and environment JAR in your `products` folder, we can now get the RLVizApp experiment and try it out.

For this guide, we'll download the [RLVizApp sample experiment](SampleExperimentRLVizAppJava.md).

```
#Move into the rl-library folder
cd rl-library

#If you are on Linux, you can use wget which will download SampleExperimentRLVizApp-Java-R1207.tar.gz for you
wget http://rl-library.googlecode.com/files/SampleExperimentRLVizApp-Java-R1207.tar.gz

#This will add any project-specific things necessary to system and products folders
#It will also create a folder for this particular project
tar -zxf SampleExperimentRLVizApp-Java-R1207.tar.gz

#Clean up
rm SampleExperimentRLVizApp-Java-R1207.tar.gz
```

## Running RLVizApp ##
To run it, simple execute the `run.bash` script that was bundled with the project.

```
>$ cd SampleExperimentRLVizApp-Java-R1207
>$ bash run.bash

```

This will start up the agent, environment, and experiment program needed to run this example, and will also start the rl\_glue executable socket server.

You should see a list of agents and environment in a panel on the right side of your screen.  Depending on which agent and environment you choose, you may also be able adjust the parameters.  For example, the [Tile Coding Sarsa Lambda](EpsilonGreedyTileCodingSarsaLambdaJava.md) agent will allow you to adjust learning rate and tile coding parameters.

When you are ready, click on the button that says "Load Experiment". If things go well, the agent and environment will be loaded.  Now you can press "Start" or "Step", depending on whether you want to watch an experiment unfold automatically or if you want to go step by step.

If you want to change parameters, or a different agent or environment, you can press "Stop", and then "Unload Experiment".

# Going Further #
This tutorial provides a very brief introduction to running an experiment with RLVizApp.

RLVizApp has many parameters, and can be configured to do things like:
**Show any combination of the environment and agent visualizer windows** Do **not** dynamically load the agent, environment, or both
  * This means you could start a standard Python/C/Lisp/Matlab RL-Glue agent, but still pick, parameterize, and visualize the environment with RLVizApp
**Look for the JAR files for agents, environments, and visualizers in different locations on your computer**

These options are all set when the RLVizApp JAR is loaded.  In this case, you can see in the `run.bash` script a line like:
```
java -ea -Xmx128M -jar  $systemPath/common/libs/rl-viz/RLVizApp.jar list-agents=true list-environments=true env-viz=true agent-viz=true agent-environment-jar-path=$productsPath
```

If you wanted to load the/configure the environment dynamically, but start a fixed agent (maybe written in a different language), you could set it to:
```
java -ea -Xmx128M -jar  $systemPath/common/libs/rl-viz/RLVizApp.jar list-agents=false list-environments=true env-viz=true agent-viz=false agent-environment-jar-path=$productsPath
```

**Note:** To make the above example work, you'll also have to comment out the line in `run.bash` that starts the _AgentShell_.


We will soon make a different tutorial that explains how to run RLVizApp in _internal_ mode, so that you do not need the RL-Glue core project.