#!/usr/bin/perl
use strict;
use warnings;

my $arg = 1;

if( $ARGV[0] =~ m/^\d+$/ ){
	
	if($ARGV[0] <= 0){
		print "argument invalide", "\n";
		exit;
	}

	for( my $i=1 ; $i <= $ARGV[0] ; $i++){
		$arg = $arg * $i;
	}
	
	print $arg, "\n";
}
