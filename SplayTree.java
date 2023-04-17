public class SplayTree<K extends Comparable<K>, V> {
    
    private Node<K, V> root;
    private int size;

    // Constructor
    public SplayTree() {
        this.root = null;
        this.size = 0;
    }

    // Métodos para insertar, eliminar y buscar nodos en el árbol
    public void insert(K key, V value) {
        // Implementación de la inserción
    }

    public void remove(K key) {
        // Implementación de la eliminación
    }

    public V search(K key) {
        // Implementación de la búsqueda
    }

    // Otros métodos auxiliares para la rotación, el splay y la impresión del árbol
    private void rotateLeft(Node<K, V> node) {
        // Implementación de la rotación izquierda
    }

    private void rotateRight(Node<K, V> node) {
        // Implementación de la rotación derecha
    }

    private void splay(Node<K, V> node) {
        // Implementación del splay
    }

    public void printTree() {
        // Implementación de la impresión del árbol
    }

    // Clase privada para los nodos del árbol
    private class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        // Getters y setters
        // ...
    }
}
