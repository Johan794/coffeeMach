#!/bin/bash
gradle clean

echo "Deplegando servidor central"
./deployCentralServer.sh

printf "\n"

echo "Desplegando Proxy cache"
./deployProxyCache.sh



echo "Desplegando maquinas de café"
./deployCoffeeMach.sh

