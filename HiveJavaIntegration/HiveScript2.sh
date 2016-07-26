root@cloudera-vm:/home/cloudera/HadoopTraining/HiveJavaIntegration# javac -classpath $CLASSPATH HiveJdbcClient.java
root@cloudera-vm:/home/cloudera/HadoopTraining/HiveJavaIntegration# java -classpath $CLASSPATH HiveJdbcClient

$JAVA_HOME


---------------
Running TestJava
export CLASSPATH=.:/usr/lib/jvm/java-6-sun-1.6.0.24:/home/cloudera/HadoopTraining/HiveJavaIntegration
javac -cp $CLASSPATH TestJava.java
java -cp $CLASSPATH TestJava

-----------
Running HiveJdbcClient:

export HIVE_HOME=/usr/lib/hive
export CLASSPATH=$(hadoop classpath)
export CLASSPATH=$CLASSPATH:/usr/lib/jvm/java-6-sun-1.6.0.24
export CLASSPATH=$CLASSPATH:$HIVE_HOME/lib/hive-exec-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-jdbc-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-metastore-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-service-0.7.0-cdh3u0.jar:/home/cloudera/HadoopTraining/HiveJavaIntegration
javac -cp $CLASSPATH HiveJdbcClient.java
java -cp $CLASSPATH HiveJdbcClient


Command to Start the thrift server : 
HIVE_PORT=10000 sudo /usr/lib/hive/bin/hive --service hiveserver

--------------------

export CLASSPATH=$(hadoop classpath)

export CLASSPATH=$CLASSPATH:$HIVE_HOME/lib/hive-exec-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-jdbc-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-metastore-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-service-0.7.0-cdh3u0.jar

$java $CLASSPATH HiveJdbcClient

---------
export HIVE_HOME=/usr/lib/hive
export CLASSPATH=$(hadoop classpath)
export CLASSPATH=$CLASSPATH:/usr/lib/jvm/java-6-sun-1.6.0.24
export CLASSPATH=$CLASSPATH:$HIVE_HOME/lib/hive-exec-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-jdbc-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-metastore-0.7.0-cdh3u0.jar:$HIVE_HOME/lib/hive-service-0.7.0-cdh3u0.jar
---------

Command to Start the thrift server : 

HIVE_PORT=10000 sudo /usr/lib/hive/bin/hive --service hiveserver



After starting the Thrift server you can run the client program from the new Terminal 

Open the New terminal and run the Java program.

Compile the Java program :

javac -cp $CLASSPATH <path to your java program>

Run the program 

java -cp $CLASSPATH <path to your class file>







