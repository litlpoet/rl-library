# This page is a bit out of date #
Posting this March 1 2009.  Check out the [getting started guide](GettingStarted.md) for up to date information.

# Introduction #

There are currently two sample experiment projects, that can be found in:

  * `rl-library/projects/experiments/sampleExperimentRLGlue`
  * `rl-library/projects/experiments/sampleExperimentRLViz`

Each of these experiments can be run by going into the appropriate directory and running one of run bash script in there:

```
$> cd projects/experiments/sampleExperimentRLGlue
$> bash run.bash
```

or:
```
$> cd projects/experiments/sampleExperimentRLViz
$> bash runDynamicEnvAgent.bash
```

Be sure that you have first built rl-glue in the main rl-library directory either by
```
$> make rl-glue
```

or
```
$> ant rl-glue
```


# Experiment Details #
Details about the experiments are in the README files in each experiment.  Basically, they each run a small number of episodes on an environment.

The RL-Glue experiment script runs an agent and environment outside of the experiment java program.  Alternatively, any rl-glue agent and environment could be started manually.  The experiment java program has no control over what agents and environments are being used and how they are configured.

The RL-Viz experiment can choose the environment and agent at runtime, by sending appropriate message the the environmentShell and the agentShell.  If you run the program it will tell you what environments and agents are available.  There is also a version in there that lets you run any RL-Glue agent externally.  Check the README.txt file in that directory.

There is optional code in that experiment to set the flag of `randomStartStates` in Mountain Car, as a quick example of runtime configuration.

# Running An Experiment #

Go into the appropriate directory run the bash script.