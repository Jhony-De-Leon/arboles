# Tarea: Árbol Binario de Búsqueda (BST) en Java

**Curso:** Programación III
**Estudiante:** Jhony De Leon
**Carné:** 0905-24-22282
**Tema:** Estructuras de datos no lineales — Árboles

---

## 1. Cómo compilar y ejecutar

Desde la carpeta `arboles/`:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal"
```

Para el Extra 4 (BST desde argumentos de consola):

```bash
mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal" -Dexec.args="15 8 23 4 11 19 30"
```

O abriéndolo como proyecto Maven en Eclipse y ejecutando la clase `Principal`.

---

## 2. Estructura del proyecto

```
arboles/
├── pom.xml
└── src/main/java/umg/edu/progra/arboles/
    ├── Nodo.java
    ├── ArbolBinarioBusqueda.java
    ├── OperacionesBST.java
    └── Principal.java
```

**Nota sobre principios SOLID aplicados:**
- **SRP** (Responsabilidad Única): `ArbolBinarioBusqueda` solo maneja la estructura base del árbol. `OperacionesBST` solo contiene los algoritmos nuevos.
- **OCP** (Abierto/Cerrado): `ArbolBinarioBusqueda` no fue modificada para agregar los métodos nuevos. El sistema se extendió creando `OperacionesBST`.

---

## 3. Métodos nuevos implementados

### Problema 1 — `contarNodos()`

Cuenta el total de nodos del árbol usando recursividad pura, sin usar el campo `tamanio` que ya tiene la clase.

**Funcionamiento:** si el nodo es `null` retorna 0, de lo contrario retorna 1 + la cuenta del subárbol izquierdo + la cuenta del subárbol derecho.

**Entrada:**
```
Árbol con valores: 50, 30, 70, 20, 40, 60, 80, 10
```

**Salida:**
```
tamanio()     = 8
contarNodos() = 8
Despues de insertar 90:
tamanio()     = 9
contarNodos() = 9
Despues de eliminar 90:
tamanio()     = 8
contarNodos() = 8
```

---

### Problema 2 — `esBalanceado()`

Verifica si el árbol está balanceado. Un árbol está balanceado si en cada nodo la diferencia de altura entre el subárbol izquierdo y el derecho es menor o igual a 1.

**Funcionamiento:** para cada nodo calcula la altura de ambos subárboles, obtiene la diferencia y si es mayor a 1 retorna `false`. También verifica recursivamente los subárboles.

**Entrada:**
```
Árbol balanceado:    50, 30, 70, 20, 40, 60, 80, 10
Árbol desbalanceado: 1, 2, 3, 4, 5
```

**Salida:**
```
esBalanceado() = true
esBalanceado() = false
```

---

### Problema 3 — `esBSTValido()`

Verifica que el árbol cumple la propiedad de BST: todo el subárbol izquierdo debe ser menor que la raíz y todo el subárbol derecho debe ser mayor.

**Funcionamiento:** pasa un rango `(minPermitido, maxPermitido)` en cada llamada recursiva. Si el valor del nodo sale del rango retorna `false`.

**Entrada:**
```
Árbol válido generado por Principal: 50, 30, 70, 20, 40, 60, 80, 10
Árbol roto: se agrega nodo 3 como hijo del nodo 60 (viola BST porque 3 < 50)
```

**Salida:**
```
esBSTValido() = true
esBSTValido() = false
```

---

### Problema 4 — `ancestroComunMasBajo(int a, int b)`

Devuelve el dato del nodo que es el Ancestro Común Más Bajo (LCA) de dos valores dados.

**Funcionamiento:** aprovecha la propiedad del BST:
- Si `a` y `b` son menores que el nodo actual → baja a la izquierda.
- Si `a` y `b` son mayores que el nodo actual → baja a la derecha.
- Si uno es menor y el otro mayor (o uno coincide) → ese nodo es el LCA.

Lanza `IllegalArgumentException` si alguno de los valores no existe en el árbol.

**Entrada:**
```
Árbol: 50, 30, 70, 20, 40, 60, 80, 10
lca(10, 40)
lca(10, 80)
lca(60, 80)
lca(10, 99)
```

**Salida:**
```
lca(10, 40) = 30
lca(10, 80) = 50
lca(60, 80) = 70
lca(10, 99) -> excepcion: El valor 99 no existe en el arbol
```

---

### Problema 5 — `invertir()`

Invierte el árbol convirtiéndolo en su espejo: intercambia el hijo izquierdo y el hijo derecho en cada nodo recursivamente.

**Funcionamiento:** guarda el hijo izquierdo en una variable temporal, asigna el derecho al izquierdo y el temporal al derecho. Repite el proceso para ambos subárboles.

**Entrada:**
```
Árbol: 50, 30, 70, 20, 40, 60, 80, 10
```

**Salida:**
```
Antes de invertir:
InOrden antes (ascendente): 10 20 30 40 50 60 70 80

Despues de invertir:
InOrden despues (descendente): 80 70 60 50 40 30 20 10
```

---

## 4. Ejercicios extra implementados

### Extra 1 — `kEsimoMenor(int k)`

Devuelve el k-ésimo valor más pequeño del árbol usando el recorrido inOrden. Como inOrden en un BST da los valores de menor a mayor, el k-ésimo menor está en la posición `k-1` del recorrido.

**Entrada:**
```
Árbol: 50, 30, 70, 20, 40, 60, 80, 10
kEsimoMenor(1), kEsimoMenor(3), kEsimoMenor(5), kEsimoMenor(8)
```

**Salida:**
```
InOrden del arbol: 10 20 30 40 50 60 70 80
kEsimoMenor(1) = 10
kEsimoMenor(3) = 30
kEsimoMenor(5) = 50
kEsimoMenor(8) = 80
kEsimoMenor(9) -> excepcion: k = 9 es mayor que el total de nodos (8)
```

---

### Extra 2 — `imprimirRangoOrdenado(int min, int max)`

Imprime en orden todos los valores dentro del rango `[min, max]`, aprovechando la propiedad del BST para no visitar ramas que no contienen valores en el rango.

**Entrada:**
```
Árbol: 50, 30, 70, 20, 40, 60, 80, 10
imprimirRangoOrdenado(20, 60)
imprimirRangoOrdenado(35, 65)
```

**Salida:**
```
Valores en rango [20, 60]: 20 30 40 50 60
Valores en rango [35, 65]: 40 50 60
```

---

### Extra 3 — `diametro()`

Devuelve el camino más largo en aristas entre dos nodos cualesquiera del árbol. El diámetro no necesariamente pasa por la raíz.

**Funcionamiento:** para cada nodo calcula `altura izquierda + altura derecha + 2` y lo compara con el diámetro de los subárboles izquierdo y derecho. Devuelve el mayor.

**Entrada:**
```
Árbol: 50, 30, 70, 20, 40, 60, 80, 10
Árbol en cadena: 1, 2, 3, 4, 5
```

**Salida:**
```
diametro() = 5
diametro() = 4
```

---

### Extra 4 — BST desde `args`

Construye un BST a partir de valores enteros recibidos como argumentos por consola.

**Ejecución con argumentos:**
```bash
mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal" -Dexec.args="15 8 23 4 11 19 30"
```

**Salida:**
```
BST construido con los valores recibidos: 7 elementos
InOrden: 4 8 11 15 19 23 30
Tamanio: 7
Altura:  2
```

---

## 5. Commits del proyecto

| Commit | Descripción |
|--------|-------------|
| `feat: problema 1 contarNodos recursivo` | Implementación de contarNodos() |
| `feat: problema 2 esBalanceado` | Implementación de esBalanceado() |
| `feat: problema 3 esBSTValido` | Implementación de esBSTValido() |
| `feat: problema 4 ancestroComunMasBajo LCA` | Implementación del LCA |
| `feat: problema 5 invertir espejo del arbol` | Implementación de invertir() |
| `feat: extra 1 kEsimoMenor usando inOrden` | Implementación de kEsimoMenor() |
| `feat: extra 2 imprimirRangoOrdenado` | Implementación de imprimirRangoOrdenado() |
| `feat: extra 3 diametro del arbol` | Implementación de diametro() |
| `feat: extra 4 construir BST desde args de consola` | Implementación del Extra 4 |
| `docs: capturas de ejecucion como evidencia de los problemas resueltos` | Capturas de pantalla |
