#!/bin/bash

tag=""

while [ ! -f $1 ]
do
        tag=$(echo "${tag}$1 ") 
        shift
done


for i in $*
do
	for j in $tag
	do
		rm $HOME/tags/$j/$i
	done
done
