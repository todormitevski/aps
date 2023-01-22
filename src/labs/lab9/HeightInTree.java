//package labs.lab9;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Random;
//
//class BinarySearchTree<E extends Comparable<E>> {
//    public BNode<E> root;
//
//    public BinarySearchTree() {
//        root = null;
//    }
//
//    public void insert(E x) {
//        root = insert(x, root);
//    }
//
//    public void remove(E x) {
//        root = remove(x, root);
//    }
//
//    public E findMin() {
//        return elementAt(findMin(root));
//    }
//
//    public E findMax() {
//        return elementAt(findMax(root));
//    }
//
//    public BNode<E> find(E x) {
//        return find(x, root);
//    }
//
//    public void makeEmpty() {
//        root = null;
//    }
//
//    public boolean isEmpty() {
//        return root == null;
//    }
//
//    public void printTree() {
//        if (isEmpty()) {
//            System.out.println("Empty tree");
//        } else {
//            printTree(root);
//        }
//    }
//
//    private E elementAt(BNode<E> t) {
//        if (t == null)
//            return null;
//        return t.info;
//    }
//
//    private BNode<E> insert(E x, BNode<E> t) {
//        if (t == null) {
//            t = new BNode<E>(x, null, null);
//        } else if (x.compareTo(t.info) < 0) {
//            t.left = insert(x, t.left);
//        } else if (x.compareTo(t.info) > 0) {
//            t.right = insert(x, t.right);
//        } else ;  // Duplicate; do nothing
//        return t;
//    }
//
//    private BNode<E> remove(Comparable x, BNode<E> t) {
//        if (t == null)
//            return t;   // Item not found; do nothing
//
//        if (x.compareTo(t.info) < 0) {
//            t.left = remove(x, t.left);
//        } else if (x.compareTo(t.info) > 0) {
//            t.right = remove(x, t.right);
//        } else if (t.left != null && t.right != null) { // Two children
//            t.info = findMin(t.right).info;
//            t.right = remove(t.info, t.right);
//        } else {
//            if (t.left != null)
//                return t.left;
//            else
//                return t.right;
//        }
//        return t;
//    }
//
//    private BNode<E> findMin(BNode<E> t) {
//        if (t == null) {
//            return null;
//        } else if (t.left == null) {
//            return t;
//        }
//        return findMin(t.left);
//    }
//
//    private BNode<E> findMax(BNode<E> t) {
//        if (t == null) {
//            return null;
//        } else if (t.right == null) {
//            return t;
//        }
//        return findMax(t.right);
//    }
//
//    private BNode<E> find(E x, BNode<E> t) {
//        if (t == null)
//            return null;
//
//        if (x.compareTo(t.info) < 0) {
//            return find(x, t.left);
//        } else if (x.compareTo(t.info) > 0) {
//            return find(x, t.right);
//        } else {
//            return t;    // Match
//        }
//    }
//
//    private void printTree(BNode<E> t) {
//        if (t != null) {
//            printTree(t.left);
//            System.out.println(t.info);
//            printTree(t.right);
//        }
//    }
//}
//
//class BNode<E extends Comparable<E>> {
//    public E info;
//    public BNode<E> left;
//    public BNode<E> right;
//
//    public BNode(E info) {
//        this.info = info;
//        left = null;
//        right = null;
//    }
//
//    public BNode(E info, BNode<E> left, BNode<E> right) {
//        this.info = info;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//public class HeightInTree {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BinarySearchTree<Integer> st = new BinarySearchTree<Integer>();
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            st.insert(Integer.parseInt(br.readLine()));
//        }
//
//        BNode<Integer> node = st.find(Integer.parseInt(br.readLine()));
//        int depth = getHeight(node);
//        System.out.println(depth);
//        System.out.println(getElementsAtDepth(st.root, depth, 0));
//    }
//
//    private static int getElementsAtDepth(BNode<Integer> root, int depth, int current) {
//        if (root == null) return 0;
//        if (current == depth) return 1;
//        return getElementsAtDepth(root.left, depth, current + 1) + getElementsAtDepth(root.right, depth, current + 1);
//    }
//
//    private static int getHeight(BNode<Integer> node) {
//        if (node == null) return 0;
//        return Math.max(1 + getHeight(node.left), 1 + getHeight(node.right));
//    }
//}
