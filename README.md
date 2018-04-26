# TP_04
MARVEL 

  Goals:
    
    -MVN Clean: Limpia las clases compiladas del proyecto.
    
    -MVN Compile : Compila el proyecto.
    
    -MVN Package: Empaqueta el proyecto.
    
    -MVN Install: Lo instala en el repositorio.
    
    
Scopes:
    -Compile: Viene por defecto y nos indica que dependencia es necesaria para compilar.
    
    -Provided: Similar a la anterior pero se espera que las dependencias ya esten dentro del contenedor.
    
    -Runtime: Es una dependencia que no es necesaria para compilar pero si es necesara en tiempos de ejecucion.
    
    -Test: Es una dependencia que se utiliza solo para testing.
    
    -System: Similar al provided pero tenes que especificar la ruta en la que esta ya que MVN no la buscara localmente.
    
    -Import: 
    
-) El ArqueType o ArcheType es un generador de proyectos Maven (usualmente crea la estructura del proyecto mediante plantillas ya establecidas).

-) La estructura basica de Maven se compone por un archivo POM y la carpeta SRC. Esta ultima se subdivide en MAIN y TEST con sus respectivas carpetas dentro (nombre del grupo de trabajo + los .java).

-) La diferencia entre ArcheType y Artifact es que el primero es un comando por el cual creamos el proyecto de Maven, mientras que el segundo es como nosotros nombraremos al proyecto.

Estereotipos de Spring:

    -Component: Es el mas general y nos permite generar un bean para que sea considerada la clase un objeto.
  
    -Controller: Se encarga de realizaar la comunicacion entre el usuario y la aplicacion.
  
    -Repository: Se encarga de dar de alta un bean para que se implemente el patron repositorio y se puedan almacenar datos en una BD.
  
    -Service: Se encarga de gestionar las operaciones de negocio importantes dentro de la aplicacion.
