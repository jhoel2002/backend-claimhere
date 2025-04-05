#!/bin/bash

# Asegúrate de que exista el directorio .env
mkdir -p ../.env

# Ruta del archivo que vamos a crear
ENV_FILE="../.env/.env"

# Crear el archivo con las claves sin valores
cat <<EOL > $ENV_FILE
DB_URL=
DB_USER=
DB_PASSWORD=
PORT=

DB_URL_PROD=
DB_USER_PROD=
DB_PASSWORD_PROD=
PORT_PROD=
EOL

echo "$ENV_FILE creado con variables vacías."