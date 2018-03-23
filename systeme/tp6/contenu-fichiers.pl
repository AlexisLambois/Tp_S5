#!/usr/bin/perl
use strict;
use warnings;
foreach my $elem (@ARGV){
    print $elem," : \n";
    open(FICHIER, "$elem");
    while (<FICHIER>) {
		print;
    }
    print "\n";
    close(FICHIER);
}
