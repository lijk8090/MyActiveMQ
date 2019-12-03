# JDK 1.8
tar xvf jdk-8u181-linux-x64.tar.gz -C /usr/local/

export JAVA_HOME=/usr/local/jdk1.8.0_181
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib:${CLASSPATH}
export PATH=${JAVA_HOME}/bin:${JRE_HOME}/bin:${PATH}

java -version

# ActiveMQ 5.15.10
tar xvf apache-activemq-5.15.10-bin.tar.gz -C /usr/local/

/usr/local/apache-activemq-5.15.10/bin/activemq start       # 监听服务端口: 61616
/usr/local/apache-activemq-5.15.10/bin/activemq status
/usr/local/apache-activemq-5.15.10/bin/activemq stop
/usr/local/apache-activemq-5.15.10/bin/activemq console     # debug

http://localhost:8161/admin/                                # 监听管理端口: 8161
admin/admin

# 日志
netstat -nap | grep java
tail -f /usr/local/apache-activemq-5.15.10/data/activemq.log
