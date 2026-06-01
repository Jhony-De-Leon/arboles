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
}
