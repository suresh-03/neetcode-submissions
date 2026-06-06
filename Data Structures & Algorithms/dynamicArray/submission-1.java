class DynamicArray {

    int[] array;
    int size = 0;
    int capacity = 1;
    public DynamicArray(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity){
        capacity *= 2;
        int[] newArray = new int[capacity];
        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        array = newArray;
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        if(size < 1){
            return -1;
        }
        int lastElement = array[size-1];
        size--;
        return lastElement;
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
