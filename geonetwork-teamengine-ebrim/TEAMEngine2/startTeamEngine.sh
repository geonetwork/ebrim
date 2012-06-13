#!/bin/sh
# -----------------------------------------------------------------------------
# Start Script for TEAM ENGINE
#
# -----------------------------------------------------------------------------

export TEAMENGINE_HOME=`pwd`
if ["$TEAMENGINE_HOME/setenv.sh"]; then
	exec $TEAMENGINE_HOME/setenv.sh
fi
export CLASSPATH="$TEAMENGINE_HOME/resources/:$TEAMENGINE_HOME/dist/TEAMEngine2.jar:$TEAMENGINE_HOME/lib/ixmlunit.jar:$TEAMENGINE_HOME/lib/saxon-6.5.5.jar:$TEAMENGINE_HOME/lib/saxon9-9.0.0.6j.jar:$TEAMENGINE_HOME/lib/saxon9-dom-9.0.0.6j.jar:$TEAMENGINE_HOME/lib/saxon9-s9api-9.0.0.6j.jar"

#echo $CLASSPATH

# Make sure prerequisite environment variables are set
if [ -z "$JAVA_HOME" ]; then
	echo "The JAVA_HOME environment variable is not defined"
	echo "This environment variable is needed to run this program"
	export JAVA_HOME=/Library/Java/Home
	if [ ! -r "$JAVA_HOME"/bin/java ]; then
	  echo "The JAVA_HOME environment variable is not defined correctly"
	  echo "This environment variable is needed to run this program"
	  exit 1
	fi
fi

# Set standard commands for invoking Java.
_RUNJAVA="$JAVA_HOME"/bin/java

exec "$_RUNJAVA" -classpath "$CLASSPATH" com.occamlab.te.Test -mode=test -source=../testdata/GetRecordByIdTestData.xml -workdir=work  -logdir=log
