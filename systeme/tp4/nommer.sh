#!/bin/bash
regex="^[0-9]{9}$"
if [[ $1 =~ $regex ]]
then
	find $HOME/tags/ -inum $1 | head -n 1
else
	echo "Ce n'est pas un inode"
	exit 1
fi
