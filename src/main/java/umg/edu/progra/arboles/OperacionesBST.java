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
}
