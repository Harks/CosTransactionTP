#!/bin/sh
dir=${0%/*}
if [ -d "$dir" ]; then
  cd "$dir"
fi

java -cp CosTransaction/target/uber-CosTransaction-0.0.1-SNAPSHOT.jar com.study.gg.transaction.cos.CosTransaction.TransactorRMIServer;