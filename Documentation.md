Thank you for downloading/using RL-Library.


# THIS DOCUMENT IS OUT OF DATE #
I'm writing this note on March 1st, 2009.  We'll be creating some basic docs to get you started very shortly.  For now, some of the details in here will be useful, but not all. Sorry.


---

# What's an RL-Library? #
RL-Library is a collection of open-source agents, environments, and experiments that are compatible with the [RL-Glue](http://code.google.com/p/rl-glue/) reinforcement learning interface implementation.

The idea is that by providing these agent, environments, and experiments to the community, we can largely eliminate the pain in the neck of re-implementing each other's hard work all the time, and facilitate more accurate and effective comparisons between methods by using a shared code library.


---

# Getting the Code #

The easiest way is just to download the code from the [downloads page](http://code.google.com/p/rl-library/downloads/list).

A **better way** would be to check it out of subversion, so you can do `svn update` to get the latest fixes + features (since we're still early in the lifetime of this project).

You can check out the latest stable version from subversion:
```
svn checkout http://rl-library.googlecode.com/svn/tags/versions/stable/ rl-library
```

If you would like to contribute to this project, you can become a member and commit to the repository, or submit files via e-mail to the organizers.




---


# Hyper Quick Start #

If you just want to see something happen without learning anything about what's in this package, do:
```
$> cd projects/experiments/guiExperiment
$> bash runNetDynamicEnvAgent.bash
```

**Note:** This is a graphical demo and will only work if you can display a graphical Java window!

This will run the graphical experiment program with all of the Java agents and environments currently in rl-library.

There are also sample experiments that you can run in `projects/experiments`

More information at [SampleExperiments](SampleExperiments.md).

Please read the rest of this document to learn what that means and what other things you can do!

---


# Installation #
In theory, RL-Library is an effort that has been created by a variety of authors on a variety of platforms.  We're trying as much as possible to enforce standards and set things up in as flexible a way as possible, but it won't always work.

We use two build systems (so far) on this project, [Apache Ant](http://ant.apache.org/) and [Make](http://www.gnu.org/software/make/).  The core C/C++ stuff uses Make and the Java stuff all uses Ant.  We consider Ant our primary build system because we have it setup so that Ant can call Make, but not vice versa.

Anyway, to rebuild the Java stuff you need Ant, but you shouldn't need to rebuild the Java stuff if you don't want to.



## RL-Glue ##
Can be built from Ant or Make:

```
$> make rl-glue
```
or
```
$> ant rl-glue
```

## Java Environments and Agents ##

All of the Java agents and environments should already be compiled into jar files that live in `rl-library/system/dist`.  Java class files and .jar package files really are cross-platform compatible, so when you download rl-library you get them out of the box for free.

To rebuild all of the Java projects, test them, generate their [JavaDocs](http://en.wikipedia.org/wiki/Javadoc), and build rl-glue:

```
$> ant all
```

## C++ Agent and Environment Loaders for RL-Viz ##
Not quite implemented yet.  Soon.  For now, you can't use C++ agents or environments in RL-Viz experiments, only with RL-Glue experiments.  Read the RL-Viz vs. RL-Glue section below if you don't know what we're talking about.

## Specific Projects ##
For projects that are not automatically built by the main build system, please refer to the project specific documentation here on the Wiki, or in the INSTALL instructions in that directory, or wherever those docs are.  Hopefully it won't be much harder than typing `make`.

# What the Heck are RL-Glue and RL-Viz #
[RL-Glue](http://code.google.com/p/rl-glue/) is both an idea and an implementation.  The idea is a standard interface, a set of function calls, that reinforcement learning agents, environments, and experiments should use so that they can be easily understood and reused by the reinforcement learning community.

The implementation is a cross-language, cross-platform software library for creating reinforcement-learning _components_ (agents, environments, and experiments).  It runs on Linux/Unix/Mac OS X/Cygwin and currently supports Python, C, C++, and Java. Lisp and Matlab support are in the works.  Basically, you write your component following the spec and link it to RL-Glue.  Then, you can use that component with any complimentary components that support the same actions and observations.  So I could write an RL-Glue environment that has discrete actions and observations, compile it with RL-Glue, and then it could be easily used with any RL-Glue agent that works with discrete action, discrete observations.  The programs could be compiled together into a single executable, or run in difference languages on a single computer, or run on different everything running across the Internet.  It's pretty cool.

Every agent, environment, and experiment in here should **hopefully** be compatible with RL-Glue on it's own.

### RL-Viz ###

[RL-Viz](http://rl-viz.googlecode.com/) is a protocol + implementation that builds on _top_ of RL-Glue.  RL-Viz adds a specification on top of some of the more open-ended parts of RL-Glue in order to add some really neat functionality.

Some main features:

  * Supports visualization of agents and environments
  * Allows run-time selection of agents and environments
  * Allows run-time configuration (setting parameters) of agents and environments

RL-Viz is currently used for the [Reinforcement Learning Competition 2008](http://rl-competition.org).

### How they Fit Together ###
Many of the components in the RL-Library have been created offer additional features if used through RL-Viz.  To the end user, RL-Viz can be easier to use than RL-Glue because it tries to automate some aspects of running RL-Glue experiments.  In any case, RL-Viz is a strict addition to RL-Glue, so anything built for RL-Viz can be used without it.


---


# Licensing #
Each project in here is licensed independently.  I know the Google Code project says Apache License 2.0.  That's not project wide.

This is a complex topic.  We (Brian Tanner, Adam White, Rich Sutton, etc. at the University of Alberta) have created this Google Code project called 'rl-library'.  We are putting all of the infrastructure code out under Apache License 2.0.  I'm not going to explain Apache License 2.0 in detail, because I don't always get it myself, but the point is that it means that you can redistribute that code or any derivative of it without must restriction.  I think you have to give us credit.

Google Code technically says that all parts of a project should be under the same license.  That's not really going to work for us, and I hope they're not upset about it.

Instead, it goes like this: each sub-project (agent/environment/experiment) within the rl-library can be released under whatever open-source license the authors would like.  If someone wants to make their code completely free (no terms, just use and enjoy), while someone else would like to use the GPL, I'm saying that's fine.  It just means that if you want to use some code, you should look at the license and notices that are explained at the top level of that project.

If you would like to use some of the work here under a different license than is offered, you can work that out with the original author, provided that you can get in contact with them.

Sorry that this has to be complicated.


---


# Credits #
  * [Brian Tanner](http://brian.tannerpages.com)
  * [Adam White](http://http://www.adamwhite.ca/)
  * Mark Lee
  * Andrew Butcher
  * Matthew Radkie
  * Leah Hackman