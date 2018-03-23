#!/bin/bash

if [ $2 = 0 ]
then
	echo "<!DOCTYPE html>"
	echo "<html><head></head><body>"
else
	cat $2
fi

cat $1

echo "</pre></body></html>"
