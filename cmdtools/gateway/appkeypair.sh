#!/bin/sh
#shell call java program
echo $JAVA_HOME
java -Xms50m -Xmx850m -XX:MaxDirectMemorySize=512m -jar  appkeypair-1.0.6.jar $1 $2 $3 $4 $5 $6 $7 $8 $9
exit 0;
