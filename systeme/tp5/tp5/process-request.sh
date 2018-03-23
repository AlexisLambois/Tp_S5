#!/bin/bash


racine=$1
modele=$2

function badrequest {

	printf "HTTP/1.1 400 bad request\r\n"
	printf "Content-Length: 15\r\n"
	printf "Content-Type: text/text\r\n"
	printf "Connection: Closed\r\n"
	printf "\r\n"
	
}

function badversion {

	printf "HTTP/1.1 505 HHTP version not supported\r\n"
	printf "Content-Length: 27\r\n"
	printf "Content-Type: text/text\r\n"
	printf "Connection: Closed\r\n"
	printf "\r\n"
	
}

function notallow {

	printf "HTTP/1.1 405 method not allowed\r\n"
	printf "Content-Length: 22\r\n"
	printf "Content-Type: text/text\r\n"
	printf "Connection: Closed\r\n"
	printf "\r\n"

}


function success {
	
	printf "HTTP/1.1 200 ok\r\n"
	printf "Content-Length: $1\r\n"
	printf "Content-Type: text/html\r\n"
	printf "Connection: Closed\r\n"
	printf "\r\n"
}

function forbidden {
	
	printf "HTTP/1.1 403 forbidden\r\n"
	printf "Content-Length: $1\r\n"
	printf "Content-Type: text/html\r\n"
	printf "Connection: Closed\r\n"
	printf "\r\n"
	printf "<h1><strong>Forbidden</strong></h1>\r\n"
}

function notfound {
	
	printf "HTTP/1.1 404 Not Found\r\n"
	printf "Content-Length: $1\r\n"
	printf "Content-Type: text/html\r\n"
	printf "Connection: Closed\r\n"
	printf "\r\n"
	printf "<h1><strong>Not Found</strong></h1>\r\n"
}

function notaccept {
	
	printf "HTTP/1.1 406 Not Acceptable\r\n"
	printf "Content-Length: 44\r\n"
	printf "Content-Type: text/html\r\n"
	printf "Connection: Closed\r\n"
	printf "\r\n"
	printf "<h1><strong>Not Acceptable</strong></h1>\r\n"
}

function verif {
	if [ $(echo "$1 $2 $3" | wc -w) = 3 ]
	then
		if [ $1 = "GET" ]
		then
			echo "methode ok" > rep.txt
			echo "process-request.sh: info: $fichier: 200: ok" 1>&2
		else
			notallow
			echo "process-request.sh: erreur: $1: 405: Methode non autorisée" 1>&2
			exit 1
		fi
	else
		badrequest 
		echo "process-request.sh: erreur: $1 $2 $3: 400: Mauvaise requete" 1>&2
		exit 1
	fi
}

function ressourceHtml {
	fichier=$(echo $1 | sed 's/\//\\/' | sed 's/\//\\/' | cut -d '\' -f 3 | sed 's/\/triepar\//\\/' | cut -d '\' -f 1)
	fichier=$(echo ${racine}/${fichier})
	if [ -e $fichier ]
	then
		file=$(mktemp)
		if [[ $fichier = *"/triepar/"* ]] && [[ $fichier == *".csv"* ]]; then
			notaccept
		elif [[ $fichier == *".csv"* ]]; then
			./csv2html.sh $modele < $fichier > $file
			echo "csv2html.sh: info: $fichier: 200: ok"  1>&2
		elif [[ $fichier == *".txt"* ]]; then
			./txt2html.sh $fichier $modele > $file
			echo "txt2html.sh: info: $fichier: 200: ok"  1>&2
		elif [[ $fichier == "/" ]]; then
			notaccept
		elif [ -d $fichier ]; then
			./dir2html.sh $fichier $modele > $file
			echo "dir2html.sh: info: $fichier: 200: ok" 1>&2
		else
			notaccept
			echo "process-request.sh: erreur: $fichier: 406: Fichier non supporté" 1>&2
		fi		
		success $(stat "$file" --print %s)
		cat "$file"
		echo "process-request.sh: info: $fichier: 200: ok"
		rm -f "$file"
	else
		notfound 38
		echo "process-request.sh: erreur: $fichier: 404: Fichier introuvable" 1>&2
	fi
}

function ressourceContenu {
	fichier=$(echo $1 | sed 's/\//\\/' | sed 's/\//\\/' | cut -d '\' -f 3)
	fichier=$(echo ${racine}/${fichier})
	if [ -e $fichier ]
	then
		if [ -d $fichier ]; then
			notaccept
			echo "process-request.sh: erreur: $fichier: 406: Fichier non supporté" 1>&2
		else
			success $(stat "$fichier" --print %s)
			cat "$fichier"
			echo "process-request.sh: info: $fichier: 200: ok" 1>&2
		fi	
	else
		notfound 38
		echo "process-request.sh: erreur: $fichier: 404: Fichier introuvable" 1>&2
	fi
	

}

function ressource {
		if [[ $1 == *"/html/"* ]]; then
			ressourceHtml $1
		elif [[ $1 == *"/contenu/"* ]]; then
			ressourceContenu $1
		else
			notaccept
			echo "process-request.sh: erreur: $1: 406: Fichier non supporté" 1>&2
		fi	
}


read methode fich version

if verif $methode $fich $version
then
	ressource $fich
fi

