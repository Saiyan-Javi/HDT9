public class BinarySearchTree extends Tree {
    private Node root;

    private class Node {
        private String key;
        private String value;
        private Node left, right;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void insert(String key, String value) {
        root = insert(root, key, value);
    }

    private Node insert(Node x, String key, String value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = insert(x.left, key, value);
        } else if (cmp > 0) {
            x.right = insert(x.right, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    public String search(String key) {
        Node x = search(root, key);
        if (x == null) {
            return null;
        } else {
            return x.value;
        }
    }

    private Node search(Node x, String key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        } else if (cmp > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }
}
