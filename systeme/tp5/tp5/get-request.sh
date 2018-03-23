#!/bin/bash

PATH=$(cd $(dirname $0) ; pwd):$PATH

tube=/tmp/requete

if [ ! -e $tube ]
then
	mkfifo $tube
fi
while true
do
	cat $tube | process-request.sh $1 $3 | nc.openbsd -l 127.0.0.1 $2 > $tube
done
