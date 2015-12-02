<a href='Hidden comment: 
This README.txt is also the Wiki page that is hosted online at:
Other

So, it is in Wiki Syntax.  It"s still pretty easy to read.
'></a>




# RL-Library Java Version of Generic Visualizer #

For full details, please visit:
http://library.rl-community.org/

Download Link: [GenericVisualizer-Java-R1255.tar.gz](http://rl-library.googlecode.com/files/GenericVisualizer-Java-R1255.tar.gz) [(Details)](http://code.google.com/p/rl-library/downloads/detail?name=GenericVisualizer-Java-R1255.tar.gz)

This project is licensed under the Apache 2.0 License.
See LICENSE.txt for details.


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

#If you are on Linux, you can use wget which will download GenericVisualizer-Java-R1255.tar.gz for you
wget http://rl-library.googlecode.com/files/GenericVisualizer-Java-R1255.tar.gz

#Copy the download to your local rl-library folder (whatever it is called)
cp GenericVisualizer-Java-R1255.tar.gz rl-library/
cd rl-library

#This will add any project-specific things necessary to system and products folders
#It will also create a folder for this particular project
tar -zxf GenericVisualizer-Java-R1255.tar.gz

#Clean up
rm GenericVisualizer-Java-R1255.tar.gz
```

## Compiling This Project ##
You must have ANT installed to build this project using these instructions.

You don't have to compile this, because the JAR file has been compiled
and placed into the products directory already. However, if you want to
make changes and recompile, you can simply type:
```
>$ cd GenericVisualizer-Java-R1255
>$ ant clean

#this will update ../products/GenericVisualizer.jar
>$ ant build
```

## Running This Project ##
You can run this project by typing:
```
>$ java -jar products/GenericVisualizer.jar
```
You can also use it in conjunction with RL-Library by putting the JAR file
products/GenericVisualizer.jar in the appropriate directory, as long as the
RL-Viz library jar file is in the appropriate relative location from
where you put GenericVisualizer.jar.  The location is:
../system/common/libs/rl-viz/RLVizLib.jar

## Getting Help ##
Please send all questions to either the current maintainer (below) or to the
[RL-Library mailing list](http://groups.google.com/group/rl-library).


## Authors ##
Various, over the years, including:
  * [Richard S. Sutton](http://richsutton.com)
  * [Adam White](http://adamwhite.ca)
  * [Brian Tanner](http://research.tannerpages.com)

### Current Maintainer ###
  * [Brian Tanner](http://research.tannerpages.com)
  * btanner@rl-community.org
  * http://research.tannerpages.com


