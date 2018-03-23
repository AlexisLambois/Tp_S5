#!/bin/bash

rep=null;
delimiter=";";

while getopts "s:S:d:" opt 
do
	case $opt in 

		s)
			delimiter=$OPTARG
		;;
		S)
			echo $OPTARG
		;;
		d)
			delimiter=$OPTARG
		;;
		\?)
			exit 1
		;;
	esac
done

echo "<table>"



while read rep
do	
	echo -e "<tr><th>"$(echo $rep | sed "s/${delimiter}/<\/th><th>/g"  ) "</th></tr> \n"
done


echo "</table>"
