
#!/bin/sh
dir=${0%/*}
if [ -d "$dir" ]; then
  cd "$dir"
fi

mvn install;

cd Client;
cp target/Client-0.0.1-SNAPSHOT.jar ../Client-0.0.1-SNAPSHOT.jar;
cd ..;

cd Services-common;
cp target/Services-common-0.0.1-SNAPSHOT.jar ../Services-common-0.0.1-SNAPSHOT.jar;

cd SeatAvailableService;
cp target/SeatAvailableService-0.0.1-SNAPSHOT.jar ../SeatAvailableService-0.0.1-SNAPSHOT.jar;
cd ..;

cd SideBySideService;
cp target/SideBySideService-0.0.1-SNAPSHOT.jar ../SideBySideService-0.0.1-SNAPSHOT.jar;
cd ..;

cd LockSeatService;
cp target/LockSeatService-0.0.1-SNAPSHOT.jar ../LockSeatService-0.0.1-SNAPSHOT.jar

