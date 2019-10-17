#!/usr/bin/env bash

id=$1
host=HOST

while true; do
    echo Calling home

    curl "$host/tasks?id=$id"

    sleep 5
done
