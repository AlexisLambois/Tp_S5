#!/bin/bash

port=8080
dossier=publicHtml
model=0

while getopts "p:d:t:" opt 
do
	case $opt in 

		p)
			port=$OPTARG
		;;
		d)
			dossier=$OPTARG
			if [ ! -e $dossier ]
			then
				echo "Le dossier $dossier n'existe pas"
				exit 1;
			elif [ ! -d $dossier ]; then
				echo "$dossier n'est pas un dossier"
				exit 1; 
			fi
		;;
		t)
			model=$OPTARG
			if [ ! -e $model ]
			then
				echo "$model n'existe pas"
				exit 1;
			fi	
		;;
		\?)
			exit 1
		;;
		:)
			exit 1
		;;
	esac
done

if [ $dossier = "publicHtml" ]
then
	if [ ! -e $racine ]
	then
		mkdir $racine
	fi
fi

./get-request.sh $dossier $port $model
