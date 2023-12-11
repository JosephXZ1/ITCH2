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
			this.raiz = new Nodo();
			this.raiz.dato = valor;
			this.raiz.izquierdo = null;
			this.raiz.derecho = null;
		}
		else insertarNodo(valor, this.raiz);
	}

	public void insertarNodo(int valor, Nodo nodoRef)
	{
			if (valor <= nodoRef.dato)
			{
				if (nodoRef.izquierdo == null)
				{
					System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
					nodoRef.izquierdo =  new Nodo();
					nodoRef.izquierdo.dato = valor;
					nodoRef.izquierdo.izquierdo = null;
					nodoRef.izquierdo.derecho = null;
				}
				else
				{
					insertarNodo(valor, nodoRef.izquierdo);
				}
			}
			else
			{
				if (valor > nodoRef.dato)
				{
					if (nodoRef.derecho == null)
					{
						System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
						nodoRef.derecho =  new Nodo();
						nodoRef.derecho.dato = valor;
						nodoRef.derecho.izquierdo = null;
						nodoRef.derecho.derecho = null;
					}
					else
					{
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

			for (int i=0; i < nivel; i++)
			{
				System.out.print("   ");
			}

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
            return buscarNodoRecursivo(valor, nodoRef.izquierdo);
        }
		else 
		{
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
            recorridoPreOrden(nodo.izquierdo);
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










