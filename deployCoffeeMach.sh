#!/bin/bash

# Lee cada línea del archivo host.txt
exec 3<"hosts.txt"
count=1
#Itera por cada linea del archivo
while read -u 3 line; do
# obtiene la ip del archio
  ip=$(echo "$line" | awk '{print $1}')
  name=$(echo "$line" | awk '{print $2}')
  echo "configurando host $ip"
  

  # Modificar el archivo
  sed -i "s/CoffeMach.Endpoints = tcp -h localhost -p 12346/CoffeMach.Endpoints = tcp -h $ip -p 12346/g" coffeeMach/src/main/resources/coffeMach.cfg

  # Ejecutar el comando Gradle
  gradle -p coffeeMach build

  # Copiar el archivo generado a la dirección IP actual
  echo "Mandando al equipo $name"
  #ingresa al directorio
  cd coffeeMach/build/libs/ || exit 
  echo $count > codMaquina.cafe
  sshpass -p "swarch" ssh -o StrictHostKeyChecking=no swarch@"$ip" "rm -rf coffeemachine-diaz-bonilla-campaz-ricardo"
  sshpass -p "swarch" ssh -o StrictHostKeyChecking=no swarch@"$ip" "mkdir -p coffeemachine-diaz-bonilla-campaz-ricardo/deploy-coffee-machine"
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r codMaquina.cafe swarch@"$ip":/home/swarch/coffeemachine-diaz-bonilla-campaz-ricardo/deploy-coffee-machine 
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r coffeeMach.jar swarch@"$ip":/home/swarch/coffeemachine-diaz-bonilla-campaz-ricardo/deploy-coffee-machine 
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r ice-3.7.6.jar swarch@"$ip":/home/swarch/coffeemachine-diaz-bonilla-campaz-ricardo/deploy-coffee-machine
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r gson-2.7.jar swarch@"$ip":/home/swarch/coffeemachine-diaz-bonilla-campaz-ricardo/deploy-coffee-machine
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r postgresql-42.3.1.jar swarch@"$ip":/home/swarch/coffeemachine-diaz-bonilla-campaz-ricardo/deploy-coffee-machine
  
  #sale del directorio
   cd ../../.. || exit


  #Reset file
  sed -i "s/CoffeMach.Endpoints = tcp -h $ip -p 12346/CoffeMach.Endpoints = tcp -h localhost -p 12346/g" coffeeMach/src/main/resources/coffeMach.cfg
  count=$((count + 1))
done 

