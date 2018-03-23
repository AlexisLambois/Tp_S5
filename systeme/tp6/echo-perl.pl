#!/usr/bin/perl
use strict;
use warnings;

my $passe_pas_ligne=0;
my $interprete=0;

sub interpretation{
    (my $text) = @_;
    
	if ($text =~ m/\\c/) {
    	$text =~ s/\\c//g;
		return $text;
	}

	if ($text =~ m/\\n/) {
    	$text =~ s/\\n//g;
		return $text."\n"."\n";
	}

	if ($text =~ m/\\f/) {
		$text =~ s/\\f//g;
		return $text."\n"."\n";
	}
	$text =~ s/\\t/\t/g;
	$text =~ s/\\r//g;
	$text =~ s/\\v//g;
    return $text."\n";
}

my $size = @ARGV;
foreach my $elem (@ARGV){
    if($elem=~"-n"){
		$passe_pas_ligne=1;
    }
    if($elem=~"-e"){
		$interprete=1;
    }
    if($elem=~"-ne" || $elem=~"-en"){
		$passe_pas_ligne=1;
		$interprete=1;
    }
}

my $text=$ARGV[$size-1];

if($interprete){
    $text=interpretation($text);
}

print $text,"";
