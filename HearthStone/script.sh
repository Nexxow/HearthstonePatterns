#!/bin/bash
dir="target/class";

if [ ! -f $dir ]; then
        mkdir -p $dir
fi
javac -sourcepath src/ -classpath $dir src/*/*.java -d $dir

java -classpath $dir partie.main