#!/bin/sh

PROJECT=`dirname $0`/..

if [ -z "$JAVA_HOME" ]; then 
    echo Missing JAVA_HOME environment variable, exiting...
    exit 1
fi

export PATH=$PATH:$PROJECT/cmd
export CLASSPATH=$PROJECT/target/classes
export JAVA_OPTS="-client -Xmx100m"
# Nothing really required in JAVA_OPTS, just to test

export JPROXYSH_COMPILATION_OPTIONS="-source 1.6 -target 1.6"

jproxysh   

