#!/usr/bin/perl
use strict;
use warnings;

my @tab = (' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');

foreach my $i (@ARGV) {
	if($i > 0 && $i < 27){
		print $tab[$i];
	}elsif( $i > 26 && $i < 255){
		print ".";
	}else{
		print " ";
	}
}
print "\n";
