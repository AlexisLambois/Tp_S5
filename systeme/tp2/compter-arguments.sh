#!/bin/bash
nb=1
for param in $*
do
	echo "L'argument $nb est : $param"
	nb=$(($nb + 1))
done
