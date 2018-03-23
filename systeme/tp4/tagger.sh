#!/bin/bash

tag=""

while [ ! -f $1 ]
do
	mkdir $HOME/tags/$1 2> /dev/null
	tag=$(echo "${tag}$1 ") 
	shift
done

for i in $*
do
	if [ -f $i ]
	then
		for j in $tag
		do
			ln $i $HOME/tags/$j/$i
		done
	fi
done
