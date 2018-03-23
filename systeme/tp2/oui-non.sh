#!/bin/bash
rep=null

while [ "$rep" != 'oui' ] && [ "$rep" != 'non' ]
do
	echo 'oui ou non ?'
	read rep
done
echo 'fin'
