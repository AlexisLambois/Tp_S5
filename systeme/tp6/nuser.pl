#!/usr/bin/perl
use strict;
use warnings;

print "Nombre d'utilisateurs connectes : ";
my $nusers=`who -q `; 
my @tab = split("\n",$nusers);
$tab[0] =~ s/ /\n/g;
my @temp = split("\n",$tab[0]);

my %hachage;
foreach my $elem (@temp){
	$hachage{$elem} = "";
}

my $nb =0;
foreach my $elem (keys %hachage){
	$nb = $nb+1;
}

print $nb, "\n";
