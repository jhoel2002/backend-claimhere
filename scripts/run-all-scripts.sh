#!/bin/bash

# Ejecuta el script para crear el archivo .env
chmod +x create-env.sh
./create-env.sh

# Ejecuta el script para crear el hook post-checkout
chmod +x create-post-checkout.sh
./create-post-checkout.sh

# Ejecuta el script para crear el archivo launch.json
chmod +x create-launch.sh
./create-launch.sh

echo "Todos los scripts se han ejecutado exitosamente."