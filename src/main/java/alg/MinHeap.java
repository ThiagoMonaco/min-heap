package alg;

public class MinHeap {
    private int length;
    private final int maxSize;
    private int[] data;

    public int[] getData() {
        return this.data;
    }

    public int getLength() {
        return this.length;
    }

    public MinHeap (int maxSize) {
        this.length = 0;
        this.maxSize = maxSize;
        this.data = new int[maxSize];
    }
    public void insert(int value) {
        if(this.length == this.maxSize) {
            throw new RuntimeException("Heap is full!");
        }
        this.data[length] = value;
        this.heapifyUp(this.length++);
    }
    public int delete() {
        if (this.length == 0) {
           throw new RuntimeException("Heap is empty!");
        }

        int removedValue = this.data[0];
        this.length--;
        if(this.length == 0) {
            this.data = new int[]{};
            return removedValue;
        }

        this.data[0] = this.data[this.length];
        heapifyDown(0);
        return removedValue;
    }

    private void heapifyDown(int index) {

        if(index >= this.length) {
            return;
        }
        int leftChild = this.getLeftChild(index);

        if(leftChild >= this.length) {
            return;
        }
        int leftValue = this.data[leftChild];
        int rightChild = this.getRightChild(index);
        int rightValue = this.data[rightChild];
        int value = this.data[index];

        if(leftValue < rightValue && value > leftValue) {
            this.data[leftChild] = value;
            this.data[index] = leftValue;
            heapifyDown(leftChild);
            return;
        }

        if(rightValue < leftValue && value > rightValue) {
            this.data[rightChild] = value;
            this.data[index] = rightValue;
            heapifyDown(rightChild);
        }
    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }

        int parent = getParent(index);
        int parentValue = this.data[parent];
        int value = this.data[index];

        if (parentValue >= value) {
            this.data[parent] = value;
            this.data[index] = parentValue;
            this.heapifyUp(parent);
        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }
}
