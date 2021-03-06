#/bin/bash

set -e

prog="shoppingmall-0.0.1-SNAPSHOT.jar"
prog_dir="/opt/springboot"
prog_backup_dir="${prog_dir}/backup"
source_base_dir="${prog_dir}/shoppingmall"
target_dir="$source_base_dir/target"
logs_dir="$prog_dir/logs/shoppingmall"

# 下载最新代码
cd $source_base_dir && git pull origin master 
# 打包
echo ">>> Package code."
cd $source_base_dir && mvn clean package -Dmaven.test.skip=true

# 停止应用
echo ">>> Killing $prog process..."
while true
	do
		processId=`ps -ef | grep $prog | grep -v grep | awk '{print $2}'`
		if [ -n "${processId}" ]
			then
				kill -9 ${processId}
				echo "sleep 5 seconds"
				sleep 5
				continue
			else
				echo "process not exists"
				break;
		fi
	done
# 备份代码
echo ">>> Backup old package."
cd $prog_dir
mv $prog $prog_backup_dir/$prog.`date '+%Y-%m-%d_%H:%M:%S'`

# 拷贝target目录下的包到启动目录
echo ">>> Copy latest package."
cp $target_dir/$prog $prog_dir

# 拷贝target目录下的包到启动目录
echo ">>> Copy latest package."
cp $target_dir/$prog $prog_dir

# 启动应用
nohup java -jar -Dspring.profiles.active=test $prog_dir/$prog >/dev/null 2>&1 &

sleep 10

tail -100  $logs_dir/`date '+%Y-%m-%d'`/info.0.log

echo ">>> Publish done."
