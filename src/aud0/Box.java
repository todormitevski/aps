package aud0;

public class Box<T> {
    private T object;

    public Box() {
    }

    Box(T object){
        this.object=object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "The box contains object: "+ object;
    }
}
