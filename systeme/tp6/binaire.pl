#!/usr/bin/perl
use strict;
use warnings;

my $arg = $ARGV[0];
my $r=' ';
while( $arg > 1 ){
	$r = ($arg%2).$r;
	if($arg%2 == 0){
		$arg = $arg/2;
	}else{
		$arg = ($arg/2)-0.5;
	}
}

print $arg.$r, "\n";
