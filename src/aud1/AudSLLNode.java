package aud1;

public class AudSLLNode<E> {
    protected Object element; //data
    protected AudSLLNode succ; //reference for next elem (node)

    public AudSLLNode(Object element, AudSLLNode succ) {
        this.element = element;
        this.succ = succ;
    }
}