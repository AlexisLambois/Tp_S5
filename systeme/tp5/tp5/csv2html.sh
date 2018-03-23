#!/bin/bash

if [ $1 = 0 ]
then
	echo "<!DOCTYPE html>"
	echo "<html><head></head><body>"
else
	cat $1
fi

echo "<table border=1>"



while read rep
do	

	echo -e "<tr><th>"$(echo $rep | sed "s/;/<\/th><th>/g"  ) "</th></tr> \n"
done


echo "</table>"
echo "</body></html>"
