#!/bin/sh
/opt/tomcat/bin/catalina.sh stop

mvn package

rm -rf /opt/tomcat/webapps/*

cp /work/target/*.war /opt/tomcat/webapps

/opt/tomcat/bin/catalina.sh start
