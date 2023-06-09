#!/bin/bash
count=$(grep -cve '^\s*$' hosts.txt)

sed -i "s/Ice.ThreadPool.Server.Size=n/Ice.ThreadPool.Server.Size=$count/g" ServidorCentral/src/main/resources/server.cfg

gradle -p ServidorCentral build



cd ServidorCentral/build/libs/ || exit 
sshpass -p "swarch" ssh -o StrictHostKeyChecking=no swarch@10.147.19.126 "rm -rf centralserver-diaz-bonilla-campaz-ricardo"
sshpass -p "swarch" ssh -o StrictHostKeyChecking=no swarch@10.147.19.126 "mkdir -p centralserver-diaz-bonilla-campaz-ricardo/deploy-central-server"  
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r ServidorCentral.jar swarch@10.147.19.126:/home/swarch/centralserver-diaz-bonilla-campaz-ricardo/deploy-central-server
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r ice-3.7.6.jar swarch@10.147.19.126:/home/swarch/centralserver-diaz-bonilla-campaz-ricardo/deploy-central-server
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r postgresql-42.3.1.jar swarch@10.147.19.126:/home/swarch/centralserver-diaz-bonilla-campaz-ricardo/deploy-central-server

cd ../../.. || exit
echo "Servidor desplegado con exito"