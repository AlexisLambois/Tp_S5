#!/bin/bash

premier=$(sed = $1 | grep -B 1 DEBUT_REMPLACEMENT | grep -v DEBUT)
premier=$(expr $premier - 1)

truc=""

while read fichier
do
	truc=$(echo "$truc")$(echo "$fichier")"\n"
done

sed "/--DEBUT/,/-FIN/d" $1 | sed "$premier a\ $truc" | sed  -e "s/\(*\)/<strong>/" | sed -e "s/\(*\)/<\/strong>/" | sed -e "s/\(\"\)/<em>"/ | sed -e "s/\(\"\)/<\/em>"/

