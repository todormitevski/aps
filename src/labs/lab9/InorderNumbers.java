package labs.lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

class BTree<E extends Comparable<E>> {
    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)
                return null;
            node.left = tmp;
        } else {
            if (node.right != null)
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> find(BNode<E> node, E nodeValue) {
        BNode<E> result = null;
        if (node == null)
            return null;
        if (node.info.compareTo(nodeValue) == 0)
            return node;
        if (node.left != null)
            result = find(node.left, nodeValue);
        if (result == null)
            result = find(node.right, nodeValue);
        return result;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)
                return null;
            node.left = tmp;
        } else {
            if (node.right != null)
                return null;
            node.right = tmp;
        }

        return tmp;
    }
}

class BNode<E> {
    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        return (depth == 0);
    }


    public E peek () {
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        elems[depth++] = x;
    }


    public E pop () {
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

interface Stack<E> {
    public boolean isEmpty ();

    public E peek ();

    public void clear ();

    public void push (E x);

    public E pop ();
}

public class InorderNumbers{
    public static void main(String[] args) throws IOException {
        String line, action;
        int i,index;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<Integer>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                tree.makeRootNode(nodes[index]);
            }
        }

        BNode<Integer> curr = tree.root;
        int value = Integer.MAX_VALUE;
        Stack<BNode<Integer>> s = new ArrayStack<BNode<Integer>>(N);
        while (curr != null || !s.isEmpty()) {
            while (curr !=  null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            if(value==Integer.MAX_VALUE) value = curr.info;
            else {
                if(curr.info==value+1) value++;
                else {
                    System.out.println("false");
                    return;
                }
            }
            curr = curr.right;
        }
        System.out.println("true");

    }
}
