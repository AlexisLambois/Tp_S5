#!/bin/bash

rep=null
delimiter=";"
faire=true
nb=1

while getopts ":d:s:S:h" opt 
do
	case $opt in 

		s) [[ $OPTARG =~ ^[0-9]*$ ]] && champ=$OPTARG
	   		echo $champ
	    ;;
		S) [[ $OPTARG =~ ^[a-zA-Z]*$ ]] && titre=$OPTARG
	   		nb=$(head -n1 | tr ';' '\n' | grep -i -n $titre | head -1 | cut -d':' -f1)
			echo $nb
	   	;;
		d)
			delimiter=$OPTARG
		;;
		h)
			echo $0 " : Lit en fichier au format csv pour sortir un format html"
	   		echo " "
		    echo "-d  Spécifier le délimiteur"
		    echo "-s  Excute le tri sur la colonne spécifié"
		    echo "-S  Donne le titre de la colonne"
		    echo "-h  Affiche l'aide"
			faire=false
	    ;;
		\?)
			exit 1
		;;
	esac
done

if [ faire ]
then
	
	echo "<table>"
	
    sort -t';' -k"$nb" | sed -e "s/$delim/<\/td><td>/g" -e 's/$/<\/td><\/tr>/' -e 's/^/<tr><td>/' -e '$s/<\/tr>/<\/tr><\/table>/' -e '1s/<tr>/<table><tr>/' -e '1s/td/th/g' | less

	echo "</table>"
fi
