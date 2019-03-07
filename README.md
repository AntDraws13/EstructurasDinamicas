# EstructurasDinamicas
Ejercicios para estructura de datos incluyendo listas, pilas, colas y arboles.
Dentro de src/app/ se encunetra el metodo main para declarar los objetos a utilizar

Se utilizo una interfaz en aras de agilizar el proceso y valla que resultó fructoso. 

Los ejercicios extra se pueden realizar sin problema independiente de la implementación de la lista debido a que estas ya no son objetos
espcíficos, pero son objetos de una interfaz, lo cual permite a los ejercicios extra ser polimórficos o "genéricos" hasta cierta extensión.

La funcionalidad de listas, pilas, colas y arboles está probada y comprobada. 

//Hinojos Nájera y Flores de la Trinidad

Se hace uso de las clases, atributos y métodos utilizados durante la clase de Estructura de Datos. 



Métodos dentro del proyecto: 
  Listas: 
      Add(value); // Añade valor en la ultima posición 
      AddAtStart(value); // Añade valor en la primera posición 
      AddAt(index, value); // Añade valor en la posición index y recorre las demás posiciones en la lista 
      AddAfter(after, value); // Añade valor después de la primer incidencia de after
      AddBefore(before, value); // Añade valor antes de la primer incidencia de before
      Remove(value); // Retira el primer nodo con el valor especificado
      RemoveAll(value); // Retira todos los nodos con incidencia del valor especificado
      RemoveBefore(value); // Retira el nodo previo a la primer incidencia del valor especificado
      RemoveAfter(value); // Retira el nodo posterior a la primer incidencia del valor especificado
      RemoveAtStart(); // Retira el nodo en la primer posición 
      getElementAt(index); // Obtiene el nodo en la posición index
      isEmpty(); // Indica si la lista está vacia o no 
      getLength(); // Regresa la cantidad de nodos en la lista; 
  Pilas: 
      push(value); // Ingresa a la pila un valor
      pop(); // Regresa el ultimo valor ingresado en la pila, eliminándolo
      peak(); // Regresa el siguiente valor a eliminar de la pila
      isFull(); // Verifica si la cola se encuentra llena
      isEmpty(); // Verifica si la cola se encunetra vacía 
      getTop(); // Regresa el ultimo valor a eliminar de la pila
      getLength(); // Regresa el numero de elementos dentro de la pila
  Colas:
      enqueue(value); // Añade a la cola el valor
      dequeue(); // Retira de la cola el primer valor ingresado
      removeAll(); // Retira todos los valores de la cola
      isFull(); // Verifica si la cola se encuentra llena
      isEmpty(); // Verifica si la cola se encunetra vacía 
      front(); // Regresa el valor próximo a eliminar 
      last(); // Regresa el valor ultimo a eliminar
  Árboles:
      bTree:
          insert(value); // Ingresa un valor a el árbol
          update(node); // Actualiza el factor de balance y el nivel del nodo 
          remove(value); // Elimina del arbol el nodo con el valor incidente 
          depthFirstSearch(); // Recorre el arbol
          search(value); // Regresa el nodo con el valor incidente 
          biggest(); // Regresa el valor más grande del árbol  
          minor(); // Regresa el valor más pequeño del árbol
          preOrder(); inOrder(); postOrder(); preOrder(); // Todos recorren el árbol
          height(); // Regresa la cantidad de niveles del árbol 
          width(); // Regresa la amplitud del árbol
          between(value, value);
          toString(); // Imprime el arbol de forma estructurada 
      avlTree:
          
