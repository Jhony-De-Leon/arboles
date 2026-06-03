package umg.edu.progra.arboles;

public class OperacionesBST {

    private ArbolBinarioBusqueda arbol;

    public OperacionesBST(ArbolBinarioBusqueda arbol) {
        this.arbol = arbol;
    }

    // Problema 1:
    public int contarNodos() {
        return contarNodosAux(arbol.getRaiz());
    }

    private int contarNodosAux(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int izquierda = contarNodosAux(nodo.izquierdo);
        int derecha = contarNodosAux(nodo.derecho);
        return 1 + izquierda + derecha;
    }

    // Problema 2:
    public boolean esBalanceado() {
        return esBalanceadoAux(arbol.getRaiz());
    }

    private boolean esBalanceadoAux(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        
        int alturaIzq = calcularAltura(nodo.izquierdo);
        int alturaDer = calcularAltura(nodo.derecho);
        int diferencia = alturaIzq - alturaDer;
        if (diferencia < 0) {
            diferencia = diferencia * -1;
        }
        if (diferencia > 1) {
            return false;
        }
        return esBalanceadoAux(nodo.izquierdo) && esBalanceadoAux(nodo.derecho);
    }

    private int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int izq = calcularAltura(nodo.izquierdo);
        int der = calcularAltura(nodo.derecho);
        if (izq > der) {
            return 1 + izq;
        } else {
            return 1 + der;
        }
    }

    // Problema 3:
    public boolean esBSTValido() {
        return esBSTValidoAux(arbol.getRaiz(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean esBSTValidoAux(Nodo nodo, int minPermitido, int maxPermitido) {
        if (nodo == null) {
            return true;
        }
        if (nodo.dato <= minPermitido || nodo.dato >= maxPermitido) {
            return false;
        }
        boolean izqValido = esBSTValidoAux(nodo.izquierdo, minPermitido, nodo.dato);
        boolean derValido = esBSTValidoAux(nodo.derecho, nodo.dato, maxPermitido);

        return izqValido && derValido;
    }

    // Problema 4:
    public int ancestroComunMasBajo(int a, int b) {
        if (!arbol.contiene(a)) {
            throw new IllegalArgumentException("El valor " + a + " no existe en el arbol");
        }
        if (!arbol.contiene(b)) {
            throw new IllegalArgumentException("El valor " + b + " no existe en el arbol");
        }
        return lcaAux(arbol.getRaiz(), a, b);
    }

    private int lcaAux(Nodo nodo, int a, int b) {
        if (a < nodo.dato && b < nodo.dato) {
            return lcaAux(nodo.izquierdo, a, b);
        }
        if (a > nodo.dato && b > nodo.dato) {
            return lcaAux(nodo.derecho, a, b);
        }
        
        return nodo.dato;
    }

    // Problema 5:
    public void invertir() {
        invertirAux(arbol.getRaiz());
    }

    private void invertirAux(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        Nodo temp = nodo.izquierdo;
        nodo.izquierdo = nodo.derecho;
        nodo.derecho = temp;
        
        invertirAux(nodo.izquierdo);
        invertirAux(nodo.derecho);
    }

    // Extra 1:
    public int kEsimoMenor(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k debe ser mayor que 0");
        }
        int total = contarNodos();

        if (k > total) {
            throw new IllegalArgumentException("k = " + k + " es mayor que el total de nodos (" + total + ")");
        }
        int[] valores = new int[total];
        int[] indice = { 0 };
        llenarInOrden(arbol.getRaiz(), valores, indice);
        return valores[k - 1];
    }

    private void llenarInOrden(Nodo nodo, int[] valores, int[] indice) {
        if (nodo == null) {
            return;
        }
        llenarInOrden(nodo.izquierdo, valores, indice);
        valores[indice[0]] = nodo.dato;
        indice[0] = indice[0] + 1;
        llenarInOrden(nodo.derecho, valores, indice);
    }

    // Extra 2:
    public void imprimirRangoOrdenado(int min, int max) {
        System.out.print("Valores en rango [" + min + ", " + max + "]: ");
        imprimirRangoAux(arbol.getRaiz(), min, max);
        System.out.println();
    }

    private void imprimirRangoAux(Nodo nodo, int min, int max) {
        if (nodo == null) {
            return;
        }
        if (nodo.dato > min) {
            imprimirRangoAux(nodo.izquierdo, min, max);
        }
        if (nodo.dato >= min && nodo.dato <= max) {
            System.out.print(nodo.dato + " ");
        }
        if (nodo.dato < max) {
            imprimirRangoAux(nodo.derecho, min, max);
        }
    }

    // Extra 3:
    public int diametro() {
        return diametroAux(arbol.getRaiz());
    }

    private int diametroAux(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzq = calcularAltura(nodo.izquierdo);
        int alturaDer = calcularAltura(nodo.derecho);
        int diametroEnEsteNodo = alturaIzq + alturaDer + 2;
        int diametroIzq = diametroAux(nodo.izquierdo);
        int diametroDer = diametroAux(nodo.derecho);
        int mayor = diametroEnEsteNodo;
        if (diametroIzq > mayor) {
            mayor = diametroIzq;
        }
        if (diametroDer > mayor) {
            mayor = diametroDer;
        }
        return mayor;
    }
}
