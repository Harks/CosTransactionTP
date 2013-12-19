#!/bin/sh
dir=${0%/*}
if [ -d "$dir" ]; then
  cd "$dir"
fi

java -cp SeatAvailableService/target/uber-SeatAvailableService-0.0.1-SNAPSHOT.jar com.study.gg.transaction.service.SeatAvailableService.server;
