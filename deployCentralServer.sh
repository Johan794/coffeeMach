#!/bin/bash

gradle -p ServidorCentral build

cd ServidorCentral/build/libs/ || exit 
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r ServidorCentral.jar swarch@10.147.19.158:/home/swarch/centralserver-diaz-bonilla-campaz-ricardo/deploy-central-server
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r ice-3.7.6.jar swarch@10.147.19.158:/home/swarch/centralserver-diaz-bonilla-campaz-ricardo/deploy-central-server
sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r postgresql-42.3.1.jar swarch@10.147.19.158:/home/swarch/centralserver-diaz-bonilla-campaz-ricardo/deploy-central-server

cd ../../.. || exit
echo "Servidor desplegado con exito"