#!/usr/bin/env python
from sys import argv, exit
from os import getcwd, system, path
import getopt
import subprocess
import logging
logging.basicConfig(filename="sample.log", level=logging.INFO)


dir = getcwd()
opts, args = getopt.getopt(argv[1:], "", ["github-user=", "github-passwd=", "rewrite"]);
gumtree_cmd = 'mvn exec:java -q  -Dexec.mainClass="ravens.diff.Differ"'+' -Dexec.args="' + args[0] +" "+ args[1]+'"'
p = subprocess.Popen([gumtree_cmd],stdout=subprocess.PIPE,cwd="/root/myproject",shell=True)
(out, err) = p.communicate()
if out.strip()=="0":
    logging.info("o")
else:
    logging.info("p")
print out.strip();
exit(0);
