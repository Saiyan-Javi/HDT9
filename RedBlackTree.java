public class RedBlackTree extends Tree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private String key;
        private String value;
        private Node left, right;
        private boolean color;

        public Node(String key, String value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public void insert(String key, String value) {
        root = insert(root, key, value);
        root.color = BLACK;
    }

    private Node insert(Node h, String key, String value) {
        if (h == null) {
            return new Node(key, value, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = insert(h.left, key, value);
        } else if (cmp > 0) {
            h.right = insert(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
}
