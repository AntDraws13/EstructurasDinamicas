# EstructurasDinamicas
Ejercicios para estructura de datos incluyendo listas, pilas, colas y arboles[aún en desarrollo]
Dentro de src/app/ se encunetran los métodos main para los ejercicios. 
Se utilizo una interfaz en aras de agilizar el proceso y valla que resultó fructoso. 

Los ejercicios extra se pueden realizar sin problema independiente de la implementación de la lista debido a que estas ya no son objetos
espcíficos, pero son objetos de una interfaz, lo cual permite a los ejercicios extra ser polimórficos o "genéricos" hasta cierta extensión.

Para declarar un objeto de la interfaz basta con: 
  
  Interfaz<T> object = new SpecificObject<>(int size);
  
  por ejemplo:
  
  Queue<T> queue = new QueueDoubleList<>(int size);
  
//Hinojos Nájera y Flores de la Trinidad

Se hace uso de las clases, atributos y métodos utilizados durante la clase de Estructura de Datos. 
