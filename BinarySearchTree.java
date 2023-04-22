public class BinarySearchTree {
    private Node root;
    /**
     * 
     */
    private class Node {
        private String key;
        private Translation value;
        private Node left, right;
        /**
         * 
         * @param key
         * @param value
         */
        public Node(String key, Translation value) {
            this.key = key;
            this.value = value;
        }
    }
    
    /**
     * 
     * @param key
     * @param value
     */
    public void put(String key, Translation value) {
        root = put(root, key, value);
    }
    /**
     * 
     * @param x
     * @param key
     * @param value
     * @return
     */
    private Node put(Node x, String key, Translation value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }
    /**
     * 
     * @param key
     * @return
     */
    public Translation get(String key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }
}