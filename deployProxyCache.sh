#!/bin/bash
gradle -p Proxy-cache-server build

cd Proxy-cache-server/build/libs/ || exit 
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r Proxy-cache-server.jar swarch@10.147.19.125:/home/swarch/proxy-cache-diaz-bonilla-campaz-ricardo
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r ice-3.7.6.jar swarch@10.147.19.125:/home/swarch/proxy-cache-diaz-bonilla-campaz-ricardo
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r postgresql-42.3.1.jar swarch@10.147.19.125:/home/swarch/proxy-cache-diaz-bonilla-campaz-ricardo

cd ../../.. || exit
echo "Servidor Proxy Cache desplegado con exito"