package umg.edu.progra.arboles;

/**
 * Clase principal que demuestra el uso del Arbol Binario de Busqueda (BST)
 * implementado manualmente, sin usar librerias como java.util.
 *
 * Ejecucion sugerida:
 *   1. mvn compile
 *   2. mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal"
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        /*
         * Insertamos estos valores para formar el siguiente BST:
         *
         *               50
         *              /  \
         *            30    70
         *           /  \   / \
         *          20  40 60  80
         *         /
         *        10
         */
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());

        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();

        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();

        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();

        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final: " + arbol.tamanio());
        System.out.println("Altura final:  " + arbol.altura());

        // Problema 1: contarNodos() recursivo
        System.out.println("\n===== Problema 1: contarNodos =====");

        ArbolBinarioBusqueda arbol1 = new ArbolBinarioBusqueda();
        arbol1.insertar(50);
        arbol1.insertar(30);
        arbol1.insertar(70);
        arbol1.insertar(20);
        arbol1.insertar(40);
        arbol1.insertar(60);
        arbol1.insertar(80);
        arbol1.insertar(10);

        OperacionesBST ops1 = new OperacionesBST(arbol1);
        System.out.println("tamanio()     = " + arbol1.tamanio());
        System.out.println("contarNodos() = " + ops1.contarNodos());

        arbol1.insertar(90);
        System.out.println("Despues de insertar 90:");
        System.out.println("tamanio()     = " + arbol1.tamanio());
        System.out.println("contarNodos() = " + ops1.contarNodos());

        arbol1.eliminar(90);
        System.out.println("Despues de eliminar 90:");
        System.out.println("tamanio()     = " + arbol1.tamanio());
        System.out.println("contarNodos() = " + ops1.contarNodos());

        // Problema 2: esBalanceado()
        System.out.println("\n===== Problema 2: esBalanceado =====");
        
        ArbolBinarioBusqueda arbolBalanceado = new ArbolBinarioBusqueda();
        arbolBalanceado.insertar(50);
        arbolBalanceado.insertar(30);
        arbolBalanceado.insertar(70);
        arbolBalanceado.insertar(20);
        arbolBalanceado.insertar(40);
        arbolBalanceado.insertar(60);
        arbolBalanceado.insertar(80);
        arbolBalanceado.insertar(10);
        OperacionesBST opsBalanceado = new OperacionesBST(arbolBalanceado);
        System.out.println("Arbol balanceado (50,30,70,20,40,60,80,10):");
        arbolBalanceado.imprimirArbol();
        System.out.println("esBalanceado() = " + opsBalanceado.esBalanceado());
        
        ArbolBinarioBusqueda arbolDesbalanceado = new ArbolBinarioBusqueda();
        arbolDesbalanceado.insertar(1);
        arbolDesbalanceado.insertar(2);
        arbolDesbalanceado.insertar(3);
        arbolDesbalanceado.insertar(4);
        arbolDesbalanceado.insertar(5);
        OperacionesBST opsDesbalanceado = new OperacionesBST(arbolDesbalanceado);
        System.out.println("Arbol desbalanceado (1,2,3,4,5):");
        arbolDesbalanceado.imprimirArbol();
        System.out.println("esBalanceado() = " + opsDesbalanceado.esBalanceado());
    }
}
