#!/bin/sh

echo "------------------------------------------------------"
echo "------------- Starting the initialization ------------"
echo "------------------------------------------------------"

echo "Checking if Selenium Hub is ready..."

count=0
while [ "$(curl -s http://selenium-hub:4444/status | jq -r .value.ready)" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"

  if [ "$count" -ge 60 ]
  then
    echo "***** Selenium Grid is not up within 60 seconds *****"
    exit 1
  fi

  sleep 1
done

echo "------------------------------------------------------"
echo "Selenium Grid is UP ✅"
echo "Browser selected: ${browser}"
echo "------------------------------------------------------"

mvn -f /home/seleniumbddtestframework/pom.xml test -DcliBrowser=${browser}
