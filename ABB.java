public class ABB
{
	//Java Beans
	private Nodo raiz; //null

	ABB()
	{
		this.raiz = null;
	} 

	public boolean esVacio()
	{
		return (this.raiz == null); 
	}

	public Nodo regresaRaiz()
	{
		//getRaiz  -- getter de atributo raiz
		return this.raiz;
	}

	public void insertarValor(int valor)
	{
		if (this.raiz == null)
		{
			System.out.println("Insertando raiz: " + valor);
			//Aquí es igual insertar un valor como en listas
			//Se crea la capsula
			this.raiz = new Nodo();
			//Y se encapsula el valor
			this.raiz.dato = valor;

			this.raiz.izquierdo = null;
			this.raiz.derecho = null;
		}
		else insertarNodo(valor, this.raiz);
	}

	public void insertarNodo(int valor, Nodo nodoRef)
	{
		//¿El valor a insertar es menor a la capsula referenciada (la de arriba)?
		//SI (Izquierda)
		if (valor <= nodoRef.dato)
		{
			//¿El nodo izquierdo esta vacio?
			//SI, no hay nada
			if (nodoRef.izquierdo == null)
			{
				// Inserta el valor como nodo hijo izquierdo si está vacío
				System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
				//Creación de capsula
				nodoRef.izquierdo = new Nodo();
				//Encapsulación de valor
				nodoRef.izquierdo.dato = valor;

				nodoRef.izquierdo.izquierdo = null;
				nodoRef.izquierdo.derecho = null;
			}
			//NO, ya hay uno
			else
			{
				// Si ya hay un nodo hijo izquierdo, realiza una llamada recursiva (relee el arbol otra vez pues hasta encontrar un nodo vacío)
				insertarNodo(valor, nodoRef.izquierdo);
			}
		}
		//NO, es mayor (derecha)
		else
		{
			if (valor > nodoRef.dato)
			{
				if (nodoRef.derecho == null)
				{
					// Inserta el valor como nodo hijo derecho si está vacío
					System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
					//Creación de capsula
					nodoRef.derecho =  new Nodo();
					//Encapsulación de valor
					nodoRef.derecho.dato = valor;

					nodoRef.derecho.izquierdo = null;
					nodoRef.derecho.derecho = null;
				}
				else
				{
					// Si ya hay un nodo hijo derecho, realiza una llamada recursiva (relee el arbol otra vez pues hasta encontrar un nodo vacío)
					insertarNodo(valor, nodoRef.derecho);
				}
			}
		}
	}


	public void muestraAcostado(int nivel, Nodo nodoRef)
	{
		if (nodoRef == null)
		{
			return;
		}
		else
		{
			muestraAcostado(nivel + 1, nodoRef.derecho);

			//Este bucle for imprime espacios en blanco antes de mostrar el valor del nodo actual

			//int i = 0: Inicialización de la variable de control i a 0
			//i < nivel: Condición que verifica si la variable i es menor que el nivel actual
			//i++: Incremento de la variable i en cada iteración del bucle
			//System.out.print(" "): Imprime tres espacios en blanco en cada iteración
			for (int i=0; i < nivel; i++)
			{
				System.out.print("   ");
			}

			//Este system.out imprime el valor del nodo actual en la consola
			//nodoRef.dato es el valor almacenado en el nodo actual del arbol binario
			System.out.println(nodoRef.dato);
			muestraAcostado(nivel + 1, nodoRef.izquierdo);
		}
	}




	// Método para imprimir el árbol de forma horizontal
    public void muestraAcostado() 
	{
        muestraAcostado(0, this.raiz);
    }



    // Método para buscar un nodo en el árbol
    public Nodo buscarNodo(int valor) 
	{
        return buscarNodoRecursivo(valor, this.raiz);
    }

    // Método auxiliar para buscar un nodo recursivamente
    private Nodo buscarNodoRecursivo(int valor, Nodo nodoRef)
	{
        if (nodoRef == null || nodoRef.dato == valor)
		{
            return nodoRef;
        }

        if (valor < nodoRef.dato)
		{
			//Si el valor es menor que el valor del nodo actual, se realiza una llamada recursiva con el hijo izquierdo del nodo actual
            return buscarNodoRecursivo(valor, nodoRef.izquierdo); 
        }
		else 
		{
			//Si el valor es mayor que el valor del nodo actual, se realiza una llamada recursiva con el hijo derecho del nodo actual
            return buscarNodoRecursivo(valor, nodoRef.derecho);
        }
    }



    // Métodos para recorrer el árbol en distintos órdenes

    // Preorden: Raíz, izquierdo, derecho
    public void recorridoPreOrden(Nodo nodo)
	{
        if (nodo != null)
		{
            System.out.print(nodo.dato + " ");
			//Realiza una llamada recursiva a recorridoPreOrden() con el nodo hijo izquierdo
            recorridoPreOrden(nodo.izquierdo);
			//Lo mismo con el derecho
            recorridoPreOrden(nodo.derecho);
        }
    }

    // Inorden: Izquierdo, raíz, derecho
    public void recorridoInOrden(Nodo nodo)
	{
        if (nodo != null)
		{
            recorridoInOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            recorridoInOrden(nodo.derecho);
        }
    }

    // Postorden: Izquierdo, derecho, raíz
    public void recorridoPostOrden(Nodo nodo)
	{
        if (nodo != null)
		{
            recorridoPostOrden(nodo.izquierdo);
            recorridoPostOrden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    // Método para eliminar un nodo del árbol
    public void eliminarNodo(int valor)
	{
        this.raiz = eliminarNodoRecursivo(this.raiz, valor);
    }

    // Método auxiliar para eliminar un nodo recursivamente
    private Nodo eliminarNodoRecursivo(Nodo nodo, int valor)
	{
        if (nodo == null)
		{
            return nodo;
        }

        if (valor < nodo.dato)
		{
            nodo.izquierdo = eliminarNodoRecursivo(nodo.izquierdo, valor);
        } 
		else if (valor > nodo.dato)
		{
            nodo.derecho = eliminarNodoRecursivo(nodo.derecho, valor);
        }
		else
		{
            // Nodo con un solo hijo o sin hijos
            if (nodo.izquierdo == null)
			{
                return nodo.derecho;
            } 
			else if (nodo.derecho == null)
			{
                return nodo.izquierdo;
            }

            // Nodo con dos hijos: obtener el sucesor inorden (nodo más pequeño en el subárbol derecho) 
			// Busca el sucesor inorden del nodo a eliminar, lo reemplaza por ese sucesor y luego elimina el sucesor.
            nodo.dato = valorMinimo(nodo.derecho);

            // Eliminar el sucesor inorden
            nodo.derecho = eliminarNodoRecursivo(nodo.derecho, nodo.dato);
        }

        return nodo;
    }

    // Método auxiliar para encontrar el valor mínimo en un subárbol
    private int valorMinimo(Nodo nodo)
	{
        int min = nodo.dato;
        while (nodo.izquierdo != null)
		{
            min = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return min;
    }
}