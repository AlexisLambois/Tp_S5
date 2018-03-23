#!/usr/bin/perl
use strict;
use warnings;

my $arg = $ARGV[0];

if($ARGV[0] !~ m/^\d+$/) {
	print "l'argument ne peut pas être une chaine de caractere", "\n";
	exit;
}

if(@ARGV != 1){
	print "trop d'arguments", "\n";
	exit;
}

while($arg != 1){
	if($arg%2==0){
		$arg = $arg / 2;
	}else{
		$arg = 3*$arg+1;
	}	
	print $arg, "\n";
}

