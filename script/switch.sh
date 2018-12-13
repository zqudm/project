#!/bin/bash

echo $1

echo $2

java_8_dir="/usr/lib/jvm/java-8-oracle/"

java_7_dir="/usr/lib/jvm/java-7-openjdk-amd64/"

function stringinstring()
{ case "$2" in 
*"$1"*)
 return 0
   ;;      
  esac   
 return 1
 }

pathrm () {                                                                      
local IFS=':'                                                                  
local newpath                                                                  
local dir                                                                      
local pathvar=${2:-PATH}                                                       
 for dir in ${!pathvar} ; do                                                    
      stringinstring "$1" "$dir"
      if [ $? -eq  1 ];  then
         if [ "$newpath" == "" ]; then
		 newpath="$dir"
         fi
	newpath=`printf "%s:%s" "$newpath" "$dir"`                                          
      fi	
  done                                                                           
export $pathvar="$newpath"                                                        
   }

pathprepend () {                                                                 
pathrm $1 $2                                                                   
local pathvar=${2:-PATH}                                                       
export $pathvar="$1${!pathvar:+:${!pathvar}}"                                  
 }

 pathappend () {                                                                    
# pathrm $1 $2                                                                   
local pathvar=${2:-PATH}                                                       
export $pathvar="${!pathvar:+${!pathvar}:}$1"                                  
	}


if [ $1 -eq 7 ]; then

pathrm "$java_8_dir"

pathappend "$java_7_dir/bin"
export JRE_HOME="/usr/lib/jvm/java-7-openjdk-amd64/jre"
export JAVA_HOME="/usr/lib/jvm/java-7-openjdk-amd64/"
else

pathrm "$java_7_dir"
#
pathappend "$java_8_dir/bin"
#
fi
