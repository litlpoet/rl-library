The C/C++ Agent and Environment loaders are now working, so I'm going to use this space to explain some things to know.

# How To #

  * C/C++ Agent and Environment loading can be turned on and off through environment variables CPPAgent=true or CPPEnv=true

  * You can set these variables from the command line like: `java -DCPPEnv="true"`


# Introduction #

Here are some thoughts about how to make the visualizers and trainers available to agents and environments created with C+/C++.

# Details #

An important question is: how much of the messaging code needs to be duplicated in a C/C++ library in order for us to bring the C/C++ agents and environments to equal footing.

Well, as a first approximation, it is true that we can implement a minimal approximation.  We can start with agents or environments : environments is more work, agents is less useful.

The main way that the Java and C++ implementations are different is that the Java ones are in some sense "native" RL-Glue, and the C++ stuff is "wrapped" RL-Glue.

There are hard decisions to make on the C++ side.  First, we want it to be as useable as possible, which means that we should  use good high level constructs. The DataHolder is good for this, because it is flexible and supports some cool memory management things (like clone() and release()).  Its also likely that we are going to face a boundary (at the JNI line) where we have to hop from Java to C++.  This is a place where we're free (in some sense) to change the protocol to whatever data types we like.

On the other hand, its also a perfect place (in some sense) to STICK to the RL-Glue constructs and then put our stuff one layer later using the custom types.  We should work hard to focus on absolutely minimal effort to adhere to RL-Library.  This could mean as little as returning NULL for the parameter holder and then being constructed with NULL. We can basically make 2 optional functions, to create and to receive a parameter holder.  If they are there, use them, and if not, don't.  This will allow RL environments to be used with minimal changes, but will also expose the full power of the higher level options.

It's unlikely that we'll ever be calling Java from C, so we'll never really be able to get "compile together" speed using the local sockets.  Perhaps we should think seriously of writing a NO-NET version of the glue in Java so that we can get compile together benefits with Java and C mixed.