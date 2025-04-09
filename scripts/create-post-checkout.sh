#!/bin/bash

# Ruta del archivo hook
HOOK_PATH="../.git/hooks/post-checkout"

# Crear archivo post-checkout con contenido
cat << 'EOF' > $HOOK_PATH                                      
#!/bin/bash

# Obtiene el nombre de la rama actual
branch=$(git symbolic-ref --short HEAD)

# Si la rama es 'develop', activa el perfil 'dev' y omite las pruebas
if [ "$branch" == "develop" ]; then
    echo "Cambiando a perfil de desarrollo (develop) "
    mvn clean install -Pdev -DskipTests

# Si la rama es 'main', activa el perfil 'prod' y omite las pruebas
elif [ "$branch" == "main" ]; then
    echo "Cambiando a perfil de producción (main)"
    mvn clean install -Pprod -DskipTests

# Si es otra rama, no hace nada o puedes agregar más condiciones
else
    echo "Rama desconocida: $branch"
fi
EOF

# Dar permisos de ejecución al hook
chmod +x $HOOK_PATH

echo "✅ Archivo post-checkout creado exitosamente en $HOOK_PATH"
