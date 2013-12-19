#!/bin/sh
dir=${0%/*}
if [ -d "$dir" ]; then
  cd "$dir"
fi

java -cp Client/target/uber-Client-0.0.1-SNAPSHOT.jar com.study.gg.transaction.Client.ClientProx 192.168.0.29;

