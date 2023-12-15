public class UsaABB 
{

    public static void main(String[] args)
	{
        ABB arbol = new ABB();

        // Insertar valores en el árbol
        arbol.insertarValor(25);
        arbol.insertarValor(8);
        arbol.insertarValor(29);
        arbol.insertarValor(38);
        arbol.insertarValor(27);

        // Imprimir el árbol de forma horizontal
        System.out.println("Árbol de forma horizontal:");
        arbol.muestraAcostado();

        // Buscar un nodo
        int valorABuscar = 29;
        Nodo nodoBuscado = arbol.buscarNodo(valorABuscar);
        if (nodoBuscado != null)
		{
            System.out.println("\nNodo encontrado: " + nodoBuscado.dato);
        } 
		else
		{
            System.out.println("\nNodo no encontrado.");
        }

        // Recorrer el árbol en diferentes órdenes
        System.out.println("\nRecorrido Preorden:");
        arbol.recorridoPreOrden(arbol.regresaRaiz());

        System.out.println("\nRecorrido Inorden:");
        arbol.recorridoInOrden(arbol.regresaRaiz());

        System.out.println("\nRecorrido Postorden:");
        arbol.recorridoPostOrden(arbol.regresaRaiz());

        // Eliminar un nodo
        int valorAEliminar = 29;
        arbol.eliminarNodo(valorAEliminar);
        System.out.println("\n\nÁrbol después de eliminar el nodo con valor " + valorAEliminar + ":");
        arbol.muestraAcostado();
    }
}
