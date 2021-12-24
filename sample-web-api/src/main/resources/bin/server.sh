#!/bin/bash

# 注意！linux下将文件格式转化为unix格式命令：sed -i 's/\r$//' server.sh

# project name
PROJECT_NAME="sample-web-api"

# project name path
PROJECT_DIR=$(cd `dirname $0`; cd ..; pwd)

JAVA_HOME=${JAVA_HOME}

JAVA_VERSION="jdk1.8.0_301"

JAVA="${JAVA_HOME}""bin/java"

# check jdk path
if [[ $JAVA_HOME =~ $JAVA_VERSION ]] && [[ -e $JAVA ]];then
    echo "$JAVA"
else
        echo -e "\033[31m java is not exist, you must be install java \033[0m"
    exit 0
fi

# the following codes are fix. Do not modify it.
isViewLog=$2

cd $PROJECT_DIR

init_env_path() {
    echo "check config env"
    ENV=`grep "ENV=" $PROJECT_DIR/bin/env.sh | awk -F "ENV=" '{print $2}'`
    ENV_CONFIG=`grep "ENV_CONFIG=" $PROJECT_DIR/bin/env.sh | awk -F "ENV_CONFIG=" '{print $2}'`

    echo "java===>$JAVA"
    echo "env=>$ENV"
    echo "env_config=>$ENV_CONFIG"

    PROPERTYBOOTMAIN="org.springframework.boot.loader.JarLauncher"
    BOOTJAR=`ls -l $PROJECT_DIR | grep jar | awk '{print $9}'`
    
    # check jar num
	JARNUM=`ls -l $PROJECT_DIR | grep jar | awk '{print $9}' | wc -l`
    if [[ $JARNUM -gt 1 ]]; then
        echo " Error!!! ===>  more than one jar exist in the current directory , please check!"
        exit 1
    fi

    # jvm config
    JVM_ARGS="-Xms1024M -Xmx1024M -Xmn341M -XX:MaxNewSize=256m"
	
}

start() {
    pid=`ps -ef|grep $PROJECT_NAME | grep -v grep | grep jar | awk '{print $2}'`
    echo "pid==>ps -ef|grep $PROJECT_NAME | grep jar | awk '{print $2}'"
        if [ ! -z "$pid" ];then
            echo "############ Application of '"$PROJECT_NAME"'  was running already, pid is $pid !############"
        else
            echo "############'"$MAIN_CLASS"' starting....############"
            echo $CLASSPATH
            nohup $JAVA $JVM_ARGS $ENV $ENV_CONFIG -cp $PROJECT_DIR/$BOOTJAR  $PROPERTYBOOTMAIN > /dev/null 2>&1 &
            CURPID=`ps -ef|grep $PROJECT_NAME | grep -v grep | grep jar | awk '{print $2}'`
            echo "============PID: $CURPID  running============="
            echo -e "\033[33m ########### Application of '"$PROJECT_NAME"' started successful at:"`date +%Y-%m-%d`"############ \033[0m"
            if [ "$isViewLog" = "-v" ]; then
                tail -f /dp/logs/${PROJECT_NAME}/info/info.log
            fi    			
        fi
}

stop() {
  pid=`ps -ef|grep $PROJECT_NAME | grep -v grep | grep jar | awk '{print $2}'`
  if [ ! -z "$pid" ];then
        echo "############ Application of '"$PROJECT_NAME"' stoping....############"
        kill -9 $pid
        sleep 2
        echo "########### Application of '"$PROJECT_NAME"' was stoped[pid:$pid] at:"`date +%Y-%m-%d`"############"
  else
        echo "########### Application of '"$PROJECT_NAME"' is not running. ############"
  fi
}

status() {
        pid=`ps -ef|grep $PROJECT_NAME | grep -v grep | grep jar | awk '{print $2}'`
        if [ ! -z "$pid" ];then
        echo -e "\033[33m ########### Application of '"$PROJECT_NAME"' is running ....############ \033[0m"
    else
        echo -e "\033[33m ########### Application of '"$PROJECT_NAME"' is not running...############ \033[0m"
    fi
}
case $1 in
    "start" | "-s")
        init_env_path
        init_log_path
        start
        ;;
      "stop" | "-h")
        stop
        ;;
      "restart" | "-r")
        echo "############ Application of '"$appMain"' restarting....############"
        stop
        sleep 3
        init_env_path
        init_log_path
        start
        ;;
      "status")
        status
        ;;
      *)
        echo "Usage: server.sh {[-s,start]|[-h,stop]|[-r,restart]|[status]}"
        ;;
esac
exit 0

