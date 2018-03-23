#!/bin/bash

espace=$2

if [ $# != 0 ]; then
	cd $1
	echo $espace$1
else
	echo "."
fi

for i in *
do
	if [ -d $i ]; then
		$HOME/S5/systeme/tp2/arbre.sh $i $(echo ${espace}\|__) 
	else
		echo ${espace}\__$i
	fi
done
