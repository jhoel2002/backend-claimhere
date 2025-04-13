# ClaimHereWeb

ClaimHereWeb es un proyecto diseñado para gestionar y procesar reclamaciones de manera eficiente. Este repositorio contiene el código fuente de la aplicación web.

## Características

- Gestión de usuarios y autenticación.
- Creación, edición y seguimiento de reclamaciones.
- Panel de administración para supervisar el estado de las reclamaciones.
- Interfaz intuitiva y fácil de usar.

---

## Puertos

Abre tu navegador en `http://localhost:8080`.

---

## Instalación y instrucciones

### Pasos para trabajar con DevContainer

    1. **Instalar WSL Ubuntu** o tener un entorno Linux.
    2. **Instalar Docker.**
    3. **Instalar Visual Studio Code.**
    4. **Instalar extensiones de Visual Studio Code** (Dev Container y Docker).
    5. Realizar `git clone https://github.com/jhoel2002/backend-claimhere.git` (rama develop) en tu archivo designado.
    6. Presionar `CTRL + SHIFT + P` y escribir en el buscador: `Dev containers: Reopen in container` y aceptar.
    7. Luego de la instalación de la imagen y la creación del contenedor, verificar estar en la rama `develop`.
    8. Ejecutar el siguiente comando: `cd scripts`, luego de estar en la carpeta `scripts`, ejecutar el siguiente comando: `./run-all-scripts.sh` y esperar a que se creen los archivos necesarios.
    9. Luego colocar las variables de entorno en la carpeta `.env/.env`.
    10. Para ejecutar el proyecto ir hacia la extensión ya instalada en el contenedor: `Run and Debug` y darle `Start Spring Boot App`.

---

## Comandos git necesario para la metodología git flow

    - Crear nueva rama y pasar a esa rama:
    
        git checkout -b feature/<function-a-realizar>

    - Cambiar de rama:

        git checkout <rama-a-entrar>

    - Ver las ramas: 

        git branch

    - Jalar últimos cambios:

        git pull origin <rama>

    - Realizar pull request de rama feature -> develop, cuando se culmine la implementación del código de la función que se ha desarrollado.

---

## Opcionales:

    Usar "git stash" cuando ya hayas modificado en la rama incorrecto, esto hara que se guarde los cambios en una memoria para luego con "git stash pop" pasarlo a la rama correcta.

---

## Puntos a considerar:

    - Las ramas feature son solo para implementar las funcionalidades (código), siempre se tendrá que crear una nueva rama feature/<funcionalidad> para implementar código (solo se hara push desde esa rama).

    - Realizar Pull request de feature/<xxxxx> a develop cuando la funcionalidad este terminada. PSDT: Se elimina la rama feature después del pull request.

    - No modificar en la rama main y develop, solo se pasara el código a esas ramas por pull request.

    - Configurar credenciales de git afuera del contenedor (token, nombre y correo).

    - Los merge hacia develop son automáticos, así que no se tendrá que realizar.

    - Al cambiar de rama se cambia de perfil de entorno automáticamente con las variables de entorno, esto se ve reflejado en application.properties.

    - Solo trabajar dentro de los contenedores, y estos se actualizaran afuera del proyecto, además que por temas de dependencias y permisos no se podrá trabajar afuera del contenedor (importante!).

    - Si modificas dependencias en el pom.xml  o cualquier otro archivo de configuración asegúrate de estar en la rama develop y luego ejecutar desde la terminal: "mvn clean install -Pdev" y luego guardar esos cambios con "git stash" hacia la nueva rama "feature/<agregar-dependencia-nombre>" con "git pop". Por ultimo hacer un rebuild del contenedor siguiendo el punto 6 de los "Pasos para trabajar con DevContainer", sino se puede, avisar.

----

## No olvidar:
	
	Hacer "git pull origin develop" luego de que se haya completado el pull request a develop.

	Hacer "git pull origin develop" cada que abras el contenedor para jalar los ultimo cambios.
	
	Realizar "git checkout -b feature/<function-a-realizar>" para crear la nueva rama y pasarse, recuerda estar antes de esto en la rama develop.

## Interacción con Docker

### Comandos a usar

    Mostrar images:
        docker images

    Mostrar contenedores no running:
        docker ps -a

    Mostrar contenedores running:
        docker ps

    Eliminar imágenes:
        docker rmi <id_imagen>

    Eliminar contenedores:
        docker rm <id_container>
	
----

## Recuerda:

	- No se puede eliminar imágenes si el contenedor esta en running.

	- Limpiar o eliminar contenedores o imagenes que no se use.

## Importante:

    Si hay problemas relacionado con el contenedor, elimina todos los contenedores y imágenes y haz rebuild del contenedor siguiendo el punto 6 de los "Pasos para trabajar con DevContainer", esto volverá a crear nueva imagen y el contenedor.
