#!/bin/sh
dir=${0%/*}
if [ -d "$dir" ]; then
  cd "$dir"
fi

java -cp SideBySideService-0.0.1-SNAPSHOT.jar com.study.gg.transaction.service.SideBySideService.server;

java -cp SeatAvailableService-0.0.1-SNAPSHOT.jar com.study.gg.transaction.service.SeatAvailableService.server;

java -cp LockSeatService-0.0.1-SNAPSHOT.jar com.study.gg.transaction.service.LockSeatService.server;
