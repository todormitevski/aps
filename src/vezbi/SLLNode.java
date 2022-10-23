package vezbi;

public class SLLNode {
    protected Object element; //data
    protected SLLNode succ; //reference for next elem (node)

    public SLLNode(Object element, SLLNode succ) {
        this.element = element;
        this.succ = succ;
    }
}
