# TP_04
MAVEN: 

  Goals:

    -MVN Clean: Limpia las clases compiladas del proyecto.
    -MVN Compile: Compila el proyecto.
    -MVN Package: Empaqueta el proyecto.
    -MVN Install: Lo instala en el repositorio.        
  
  Scopes:

    -Compile: Viene por defecto y nos indica que dependencia es necesaria para compilar.
    -Provided: Similar a la anterior pero se espera que las dependencias ya esten dentro del contenedor.
    -Runtime: Es una dependencia que no es necesaria para compilar pero si es necesara en tiempos de ejecucion.
    -Test: Es una dependencia que se utiliza solo para testing.
    -System: Similar al provided pero tenes que especificar la ruta en la que esta ya que MVN no la buscara localmente.
    -Import: Es solamente utilizado en el apartado de Dependency Management, donde indica la dependencia a ser reemplazada por una lista de dependencias.
    
  -) El ArqueType o ArcheType es un generador de proyectos Maven (usualmente crea la estructura del proyecto mediante plantillas ya establecidas).

  -) La estructura basica de Maven se compone de la siguiente manera:

    |--src -> Es la carpeta que contiene nuestro proyecto
    |   |- main
    |       |- java
    |           |- package --> Con el nombre de nuestro proyecto.
    |               |- files
    |
    |--test
    |   |- java
    |       |-package --> Con el nombre de nuestro proyecto.
    |           |- test files
    |
    |--pom.xml -> Archivo de configuracion del proyecto.

-) La diferencia entre ArcheType y Artifact es que el primero es un comando por el cual creamos el proyecto de Maven, mientras que el segundo es como nosotros nombraremos al proyecto.

Spring

  Stereotypes:

    -Component: Es el mas general y nos permite generar un bean para que sea considerada la clase un objeto.
![ADSA](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypes.png)

    -Controller: Se encarga de realizar la comunicacion entre el usuario y la aplicacion.
![Controladora](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesController.png)    

    -Repository: Se encarga de dar de alta un bean para que se implemente el patron repositorio y se puedan almacenar datos en una BD.
![Repositorio](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesRepository.png)

    -Service: Se encarga de gestionar las operaciones de negocio importantes dentro de la aplicacion.
![Service](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesService.png)

REST
  
  Verbos:

    -Get: Es una peticion de datos desde el cliente hacia el servidor. Es una peticion de solo lectura.
    -Post: Se utiliza cuando se debe procesar informacion por parte del servidor.
    -Put: Se utiliza para crear o actualizar el recurso identificado por la URL.
    -Delete: Se utiliza para eliminar el recurso solicitado por la URL.
    Head: Igual a la de GET, pero sin el cuerpo de la respuesta.
    -Options: Es utilizado para describir las opciones de comunicacion para el destinatario.
    -Connect: Establece un tunel hacia el servidor identificado por el recurso.
    -Patch: Es utilizado para aplicar modificaciones parciales de un recurso.
    -Trace: Es utilizado para retornar mensajes a lo largo de la ruta al recurso de destino.


