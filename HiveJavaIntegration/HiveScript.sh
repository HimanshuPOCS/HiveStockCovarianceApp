
HADOOP_HOME=/usr/lib/hadoop-0.20
HIVE_HOME=/usr/lib/hive
 
HADOOP_CORE=$(ls $HADOOP_HOME/hadoop-core*.jar)
CLASSPATH=.:$HIVE_HOME/conf:$(hadoop classpath)
 
for i in ${HIVE_HOME}/lib/*.jar ; do
    CLASSPATH=$CLASSPATH:$i
donel
 
java -cp $CLASSPATH HiveJdbcClient
