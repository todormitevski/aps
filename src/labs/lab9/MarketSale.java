package labs.lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Heap<E extends Comparable<E>> {
    private E[] elements;
    private int size;

    public int getParent(int i) {
        return (i + 1) / 2 - 1;
    }

    public int getLeft(int i) {
        return ((i + 1) * 2) - 1;
    }

    public int getRight(int i) {
        return (i + 1) * 2;
    }

    public E getAt(int i) {
        return elements[i];
    }

    public void setElement(int index, E insert) {
        elements[index] = insert;
    }

    public void swap(int i, int j) {
        E tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    public void buildMaxHeap() {
        for (int i = elements.length / 2 - 1; i >= 0; i--)
            adjustMax(i, size);
    }

    private void adjustMax(int i, int n) {
        if (i >= n) return;
        int left = getLeft(i);
        int right = getRight(i);
        int max = i;

        if ((left < n) && elements[left].compareTo(elements[max]) > 0)
            max = left;
        if ((right < n) && elements[right].compareTo(elements[max]) > 0)
            max = right;
        if (max == i)
            return;

        swap(i, max);
        adjustMax(max, n);
    }

    public void buildMinHeap() {
        for (int i = elements.length / 2 - 1; i >= 0; i--)
            adjustMin(i, size);
    }

    private void adjustMin(int i, int n) {
        if (i >= n) return;
        int left = getLeft(i);
        int right = getRight(i);
        int min = i;

        if ((left < n) && elements[left].compareTo(elements[min]) < 0)
            min = left;
        if ((right < n) && elements[right].compareTo(elements[min]) < 0)
            min = right;
        if (min == i)
            return;

        swap(i, min);
        adjustMin(min, n);
    }

    public Heap(E[] arr) {
        this.elements = arr;
        this.size = arr.length;
    }

    public void heapSort() {
        buildMaxHeap();
        for (int i = size; i > 1; i--) {
            swap(0, i - 1);
            adjustMax(0, i - 1);
        }

    }

    @SuppressWarnings("unchecked")
    public Heap(int size) {
        this.size = 0;
        this.elements = (E[]) new Comparable[size];
    }

    public boolean insert(E elem) {
        if (size == elements.length) return false;
        elements[size] = elem;
        size++;
        adjustUp(size - 1);
        return true;
    }

    private void adjustUp(int i) {
        if (i <= 0) return;
        int parent = getParent(i);
        if (elements[i].compareTo(elements[parent]) <= 0)
            return;
        else {
            swap(i, parent);
            adjustUp(parent);
        }
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public E getMax() {
        return isEmpty() ? null : elements[0];
    }

    public int getSize() {
        return size;
    }

    public E removeMax() {
        if (isEmpty()) return null;
        E tmp = elements[0];
        elements[0] = elements[size - 1];
        size--;
        adjustMax(0, size);
        return tmp;
    }
}

class Buyer implements Comparable<Buyer> {
    private int timeEntry; //in mins
    private int time; //inside

    public static int MAX_ENTRY_TIME = 1439;

    public Buyer(String timeOfEntry, int timeInside) {
        String[] parts = timeOfEntry.split(":");
        this.timeEntry = Integer.parseInt(parts[1]) + (Integer.parseInt(parts[0]) * 60);
        this.time = timeInside;
        if (timeEntry + timeInside > MAX_ENTRY_TIME) {
            this.time -= (timeEntry + timeInside) - MAX_ENTRY_TIME;
        }
    }

    @Override
    public int compareTo(Buyer arg0) {
        return -((timeEntry + time) - (arg0.timeEntry + arg0.time));
    }

    public boolean inTheSameTime(Buyer other) {
        if ((timeEntry + time) >= (other.timeEntry))
            return true;
        return false;
    }
}

public class MarketSale {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Heap<Buyer> prioQ = new Heap<>(n);

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            prioQ.insert(new Buyer(parts[0], Integer.parseInt(parts[1])));
        }

        int count = 1;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            Buyer b = prioQ.removeMax();
            for (int j = 0; j < prioQ.getSize(); j++) {
                if (b.inTheSameTime(prioQ.getAt(j)))
                    count++;
            }
            max = Math.max(max, count);
            count = 1;
        }
        System.out.println(max);
    }
}
