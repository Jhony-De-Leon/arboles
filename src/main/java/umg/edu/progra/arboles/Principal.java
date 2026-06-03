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

        // Problema 3: esBSTValido()
        System.out.println("\n===== Problema 3: esBSTValido =====");

        ArbolBinarioBusqueda arbolPrincipal = new ArbolBinarioBusqueda();
        arbolPrincipal.insertar(50);
        arbolPrincipal.insertar(30);
        arbolPrincipal.insertar(70);
        arbolPrincipal.insertar(20);
        arbolPrincipal.insertar(40);
        arbolPrincipal.insertar(60);
        arbolPrincipal.insertar(80);
        arbolPrincipal.insertar(10);

        OperacionesBST ops3 = new OperacionesBST(arbolPrincipal);
        System.out.println("Arbol generado por Principal:");
        arbolPrincipal.imprimirArbol();
        System.out.println("esBSTValido() = " + ops3.esBSTValido()); 

        // caso false: 
        Nodo nodoRoto = arbolPrincipal.getRaiz().derecho.izquierdo;
        nodoRoto.izquierdo = new Nodo(3);
        System.out.println("Arbol roto (se agrego nodo 3 bajo nodo 60, viola BST):");
        System.out.println("esBSTValido() = " + ops3.esBSTValido());

        // Problema 4:
        System.out.println("\n===== Problema 4: ancestroComunMasBajo =====");

        ArbolBinarioBusqueda arbol4 = new ArbolBinarioBusqueda();
        arbol4.insertar(50);
        arbol4.insertar(30);
        arbol4.insertar(70);
        arbol4.insertar(20);
        arbol4.insertar(40);
        arbol4.insertar(60);
        arbol4.insertar(80);
        arbol4.insertar(10);
        arbol4.imprimirArbol();

        OperacionesBST ops4 = new OperacionesBST(arbol4);

        System.out.println("lca(10, 40) = " + ops4.ancestroComunMasBajo(10, 40)); 
        System.out.println("lca(10, 80) = " + ops4.ancestroComunMasBajo(10, 80)); 
        System.out.println("lca(60, 80) = " + ops4.ancestroComunMasBajo(60, 80)); 

        try {
            ops4.ancestroComunMasBajo(10, 99);
        } catch (IllegalArgumentException e) {
            System.out.println("lca(10, 99) -> excepcion: " + e.getMessage());
        }

        // Problema 5:
        System.out.println("\n===== Problema 5: invertir =====");

        ArbolBinarioBusqueda arbol5 = new ArbolBinarioBusqueda();
        arbol5.insertar(50);
        arbol5.insertar(30);
        arbol5.insertar(70);
        arbol5.insertar(20);
        arbol5.insertar(40);
        arbol5.insertar(60);
        arbol5.insertar(80);
        arbol5.insertar(10);

        OperacionesBST ops5 = new OperacionesBST(arbol5);
        
        System.out.println("Antes de invertir:");
        arbol5.imprimirArbol();
        System.out.print("InOrden antes (ascendente): ");
        arbol5.inOrden();
        
        ops5.invertir();
        
        System.out.println("Despues de invertir:");
        arbol5.imprimirArbol();
        System.out.print("InOrden despues (descendente): ");
        arbol5.inOrden();

        // Extra 1:
        System.out.println("\n===== Extra 1: kEsimoMenor =====");
        
        ArbolBinarioBusqueda arbolE1 = new ArbolBinarioBusqueda();
        arbolE1.insertar(50);
        arbolE1.insertar(30);
        arbolE1.insertar(70);
        arbolE1.insertar(20);
        arbolE1.insertar(40);
        arbolE1.insertar(60);
        arbolE1.insertar(80);
        arbolE1.insertar(10);

        OperacionesBST opsE1 = new OperacionesBST(arbolE1);
        System.out.print("InOrden del arbol: ");
        arbolE1.inOrden();
        
        System.out.println("kEsimoMenor(1) = " + opsE1.kEsimoMenor(1)); 
        System.out.println("kEsimoMenor(3) = " + opsE1.kEsimoMenor(3)); 
        System.out.println("kEsimoMenor(5) = " + opsE1.kEsimoMenor(5)); 
        System.out.println("kEsimoMenor(8) = " + opsE1.kEsimoMenor(8)); 
        
        try {
            opsE1.kEsimoMenor(9);
        } catch (IllegalArgumentException e) {
            System.out.println("kEsimoMenor(9) -> excepcion: " + e.getMessage());
        }

        // Extra 2:
        System.out.println("\n===== Extra 2: imprimirRangoOrdenado =====");

        ArbolBinarioBusqueda arbolE2 = new ArbolBinarioBusqueda();
        arbolE2.insertar(50);
        arbolE2.insertar(30);
        arbolE2.insertar(70);
        arbolE2.insertar(20);
        arbolE2.insertar(40);
        arbolE2.insertar(60);
        arbolE2.insertar(80);
        arbolE2.insertar(10);

        OperacionesBST opsE2 = new OperacionesBST(arbolE2);
        System.out.print("InOrden completo: ");
        arbolE2.inOrden();

        opsE2.imprimirRangoOrdenado(20, 60);
        opsE2.imprimirRangoOrdenado(10, 80);
        opsE2.imprimirRangoOrdenado(35, 65);
        opsE2.imprimirRangoOrdenado(50, 50);

        // Extra 3:
        System.out.println("\n===== Extra 3: diametro =====");
        ArbolBinarioBusqueda arbolE3 = new ArbolBinarioBusqueda();
        arbolE3.insertar(50);
        arbolE3.insertar(30);
        arbolE3.insertar(70);
        arbolE3.insertar(20);
        arbolE3.insertar(40);
        arbolE3.insertar(60);
        arbolE3.insertar(80);
        arbolE3.insertar(10);

        OperacionesBST opsE3 = new OperacionesBST(arbolE3);
        arbolE3.imprimirArbol();
        System.out.println("diametro() = " + opsE3.diametro());
        ArbolBinarioBusqueda arbolCadena = new ArbolBinarioBusqueda();
        arbolCadena.insertar(1);
        arbolCadena.insertar(2);
        arbolCadena.insertar(3);
        arbolCadena.insertar(4);
        arbolCadena.insertar(5);
        
        OperacionesBST opsCadena = new OperacionesBST(arbolCadena);
        arbolCadena.imprimirArbol();
        System.out.println("diametro() = " + opsCadena.diametro());

        // Extra 4:
        System.out.println("\n===== Extra 4: BST desde args =====");

        if (args.length == 0) {
            int[] ejemplo = { 15, 8, 23, 4, 11, 19, 30 };
            ArbolBinarioBusqueda arbolEjemplo = new ArbolBinarioBusqueda();
            OperacionesBST opsEjemplo = new OperacionesBST(arbolEjemplo);
            opsEjemplo.construirDesdeArreglo(ejemplo);
            arbolEjemplo.imprimirArbol();
            System.out.print("InOrden: ");
            arbolEjemplo.inOrden();
            System.out.println("Tamanio: " + arbolEjemplo.tamanio());
            System.out.println("Altura:  " + arbolEjemplo.altura());

        } else {
            int[] valoresArgs = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                valoresArgs[i] = Integer.parseInt(args[i]);
            }
            
            ArbolBinarioBusqueda arbolArgs = new ArbolBinarioBusqueda();
            OperacionesBST opsArgs = new OperacionesBST(arbolArgs);
            opsArgs.construirDesdeArreglo(valoresArgs);
            
            System.out.println("BST construido con los valores recibidos: " + args.length + " elementos");
            arbolArgs.imprimirArbol();
            System.out.print("InOrden: ");
            arbolArgs.inOrden();
            System.out.println("Tamanio: " + arbolArgs.tamanio());
            System.out.println("Altura:  " + arbolArgs.altura());
        }
    }
}
