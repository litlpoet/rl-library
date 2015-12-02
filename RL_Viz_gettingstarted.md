# Out of Date #
March 1, 2009.  This page is old and out of date.

# Introduction #

RL-Viz needs more docs.


# Environment Variables #

RL-Viz uses several environment variables.

### AgentShell Variables ###

  * CPPAgent=true|false

This variable specifies if the dynamic agent loader will look for agents in the form of C/C++ shared libraries.

  * RLVIZ\_LIB\_PATH=/path/to/libraries/

This variable tells the loader where to look for the agentJars/ folder


### EnvironmentShell Variables ###

  * CPPEnv=true|false

This variable specifies if the dynamic environment loader will look for environments in the form of C/C++ shared libraries.

  * RLVIZ\_LIB\_PATH=/path/to/libraries/ : this variable tells the loader where to look for the envJars/ folder


To set any of these variables when calling java, use java -Dvarname=varvalue

For example: java -DRLVIZ\_LIB\_PATH=/users/yourname/rl-library/libraries -DCPPAgent=true