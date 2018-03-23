#!/bin/bash
rep=" "
while [ "$rep" != "FINI" ]
do
	echo 'Entrer variable :'
	read rep
	eval $(echo "echo $"$rep)
done
