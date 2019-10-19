#!/usr/bin/env bash

id=$1
host=localhost:8081

while true; do
    echo Calling home

    token="empty"
    result=""

    while read -r cmd timeout args; do
      if [[ $token == "empty" ]]; then
        token=$cmd

        continue
      fi

      if ! output=$(timeout "$timeout" "$cmd" "$args"); then
        output="ERROR"
      fi

      result="$result$output"$'\n'
    done <<< "$(curl -s "$host/tasks?id=$id")"

    curl -s -X POST -H "Content-Type: text/plain" -d "$result" "$host/report?token=$token"

    sleep 3
done
