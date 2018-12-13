#!/bin/bash


function stringinstring()
{ case "$2" in 
*"$1"*)
	return 0
	;;	
  esac   
 return 1
}


s1="srf"
s="rf"

s11="/usr/lib/jvm/java-8-oracle/jre/bin"
s12="/usr/lib/jvm/java-8-oracle/"



stringinstring $s11 $s12 
echo $?
stringinstring $s12 $s11
echo $?

v="r:r"
echo $v:$v
