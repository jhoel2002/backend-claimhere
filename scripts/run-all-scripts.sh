#!/bin/bash

# Ejecuta el script para crear el archivo .env
./create-env.sh

# Ejecuta el script para crear el hook post-checkout
./create-post-checkout.sh

# Ejecuta el script para crear el archivo launch.json
./create-launch.sh

echo "Todos los scripts se han ejecutado exitosamente."