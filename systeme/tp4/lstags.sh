#!/bin/bash
text=""

for i in $*
do
	if ls $HOME/tags/$i >/dev/null 2>/dev/null
	then
		for j in $(ls -i $HOME/tags/$i)
		do
			text=$(echo "${text}\n"$(echo $j | grep "^[[:digit:]]\{9\}$" ))
		done
	else
		echo "Pas de fichier"
	fi
done

chemin=""

for i in $(seq $(echo -e $text | sed '/^$/d' | wc -l))
do
	chemin=$(echo "${chemin}\n"$(./nommer.sh $(echo -e $text | sed '/^$/d' | head -n $i | tail -n 1)))
done

echo -e $chemin | sort -u | sed '/^$/d'
