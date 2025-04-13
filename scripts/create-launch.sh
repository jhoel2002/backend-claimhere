#!/bin/bash

# Crea el directorio .vscode si no existe
mkdir -p ../.vscode

# Crea el archivo launch.json con el contenido especificado
cat << 'EOF' > ../.vscode/launch.json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "request": "launch",
            "name": "Spring Boot App",
            "mainClass": "com.application.claimhereweb.ClaimherewebApplication",
            "projectName": "claimhereweb",
            "envFile": "${workspaceFolder}/.env/.env"
        }
    ]
}
EOF

echo "✅ launch.json creado exitosamente en .vscode/"