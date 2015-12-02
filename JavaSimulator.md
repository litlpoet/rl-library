# Introduction #

Basically, we have the simulator in Java that is a direct as possible port of the soccer code from Mat Buckland's book, Progamming Game AI by Example.

That has come along quite well, and we have working code as a RL-Glue domain with an RL-Viz visualizer.

# Challenges and TODOS #

Here are some facts about Austin Robocup Keep-away.  For each, we should either implement it, or change it and document it.

  * Bounds: Need to have a square that is the field, and if the ball goes out, episode over
  * Keeper-control: We can easily make it so that either one keeper is learning or they all are learning using the same agent.  What do we prefer?  I think having them all learn.
  * Game ends when takers have control of ball for a set period of time.  How much?
  * Takers all start in bottom left
  * Keepers are randomly assigned to the top 3 corners, rest of keepers go to middle
  * Top-left keeper starts with the ball

## Reward Function ##
The reward function seems to be "number of primitive steps since last decision point for this agent".  It's not discounted, so this doesn't lead to weird things like trying to get the ball out of your possession and the taking a nap.

If we are using the same learner for all keepers, we would just use a single counter and give the reward as the number of steps since last decision point, instead of tracking it on a per-keeper basis.


## Macro-Actions ##

### HoldBall() ###
Remain stationary while keeping possession of the ball in a position that is as far away from the opponents as possible.

### PassBall(k) ###
Kick the ball directly towards keeper k.

### GetOpen() ###
Move to a position that is free from opponents and open for a pass from the ball’s  current position (using SPAR (Veloso, Stone, & Bowling, 1999)).

Veloso, M., Stone, P., & Bowling, M. (1999). Anticipation as a key for collaboration in a team of agents: A case study in robotic soccer. In Proceedings of SPIE Sensor Fusion and Decentralized Control in Robotic Systems II, Vol. 3839 Boston.


### GoToBall() ###
Intercept a moving ball or move directly towards a stationary ball.

### BlockPass(k) ###
Move to a position between the keeper with the ball and keeper k.

Details of all of these here:
Stone, P. (2000). Layered Learning in Multiagent Systems: A Winning Approach to Robotic Soccer.  MIT Press.


## Higher Level Player Behavior ##
Discussed on pages 9-13 of this:
http://www.cs.utexas.edu/users/pstone/Papers/bib2html/b2hd-AB05.html

Should we do the same thing?

## This list is incomplete, add to it ##

# Done #

## Keep-away is a semi-mdp ##

Keep-away is a semi-mdp, but RL-Viz only draws on RL\_step
We solved this problem by making the Keep-away domain store a history of recent states and then send the whole list over to RL-Viz when it wants new information.  RL-Viz can then play back the intermediate simulator steps between agent actions.  This gives us the illusion of a continuously running RL-Viz simulation, but we're only really getting information at keeper decision points.