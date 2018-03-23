#!/bin/bash

fichier=$(echo $1 | cut -d "/" -f 2)
if [ $2 = 0 ]
then
	echo "<!DOCTYPE html>"
	echo "<html><head></head><body>"
else
	cat $2
fi
echo "<h1>Dossier de $fichier </h1>"
echo "<ul>"



cd $1

for i in *
do
	echo "<li><a href=\""
	if [[ $i == *".csv"* ]]; then
		echo "/html/"
	elif [[ $i == *".txt"* ]]; then
		echo "/html/"
	else
		echo  "/contenu/"
	fi
	echo "$fichier/$i\">$i</a></li>"


done


echo "</ul>"
echo "</body></html>"
