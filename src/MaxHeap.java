import java.util.Arrays;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapNLogN(Integer[] data) {
        // homework
        MaxHeap heap = new MaxHeap(data.length);
        for (int i = 0; i < data.length; i++){
            heap.add(data[i]);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
        this.data = Arrays.copyOf(data, data.length);
        this.size = data.length;
        int last = (size - 2) / 2;
        for (int i = last; i >= 0; i--){
            heapDown(i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if (size >= data.length){
            return false;
        }
        data[size] = item;
        size++;
        heapUp(size - 1);
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        if (size <= 0){
            return null;
        }
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        // homework
        if (size <= 0){
            return null;
        }
        int num = data[0];
        data[0] = data[size - 1];
        heapDown(0);
        size--;
        return num;
    }

    private void swap(int index, int index_2){
        int temp = data[index];
        data[index] = data[index_2];
        data[index_2] = temp;
    }
    private int getParent(int index) {
        return (index - 1) / 2;
    }
    private int getRight(int index) {
        return 2 * index + 2;
    }
    private int getLeft(int index) {
        return 2 * index + 1;
    }
    private boolean hasLeft(int index) {
        return getLeft(index) < size;
    }
    private boolean hasRight(int index) {
        return getRight(index) < size;
    }
    private boolean hasParent(int index) {
        return getParent(index) >= 0;
    }
    private int left(int index) {
        return data[getLeft(index)];
    }
    private int right(int index) {
        return data[getRight(index)];
    }
    private int parent(int index){
        return data[getParent(index)];
    }
    private void heapDown(){
        int index = 0;
        while(hasLeft(index)){
            int smallest = getLeft(index);
            if (hasLeft(index) && right(index) < left(index)){
                smallest = getRight(index);
            } if (data[index] < data[smallest]){
                swap(index, smallest);
            } else {
                break;
            }
            index = smallest;
        }
    }
    private void heapUp(int num){
        if (num == 0){
            return;
        }
        Integer parent = (num - 1) / 2;
        if (data[num] > data[parent]){
            swap(num, parent);
            heapUp(parent);
        }
    }
    private void heapDown(int a) {
        if (a == size) {
            return;
        }
        Integer left = 2 * a + 1;
        Integer right = 2 * a + 2;
        if (right <= size - 1) {
            if (data[a] < data[left]) {                // compare parent with left child
                if (data[left] >= data[right]) {       // Compare left and right child.
                    swap(a, left);
                    heapDown(left);

                } else {                                // right larger than left
                    swap(a, right);
                    heapDown(right);

                }
            } else if (data[a] < data[right]) {         // if node is only less than right
                swap(a, right);
                heapDown(right);
            }
        }
    }

    private void heap(Integer array[], int a, int b){
        int largest = b;
        int left = 2 * b + 1;
        int right = 2 * b + 2;
        if (left < a && array[left] > array[largest]){
            largest = left;
        } if (right < a && array[right] > array[largest]){
            largest = right;
        } if (largest != b){
            int temp = array[b];
            array[b] = array[largest];
            array[largest] = temp;
        } heap(array, a, largest);
    }

    public boolean equals(Integer[] nums) {
        for (int i = 0; i < this.size; i++){
            if (this.data[i] != data[i]){
                return false;
            }
        }
        return true;
    }
}