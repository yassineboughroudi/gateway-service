#!/usr/bin/env bash
set -e

# Wait for Config Server to respond
echo "Waiting for Config Server at $CONFIG_SERVER_HOST:$CONFIG_SERVER_PORT"
until curl -s http://$CONFIG_SERVER_HOST:$CONFIG_SERVER_PORT/actuator/health; do
  echo "Config Server not ready, retrying in 2s..."
  sleep 2
done

echo "Config Server is up!"
# Now start the Spring Boot application
java -jar /app/app.jar
