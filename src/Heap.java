public class Heap {
    private Subscription[] heap;
    //current size of occupied places in the heap
    private int currSize;

    // Constructor. building a heap with given length. currSize initialized to 0.
    public Heap(int heapSize){
        heap= new Subscription[heapSize];
    }
    public Subscription[] getHeap() {
        return heap;
    }
    // Input: i: an array index
    // Output: The index in the heap of the parent of i
    // Running Time: O(1)
    public int parent(int i){
        return (i-1)/2 ;
    }

    // Input: i: an array index
    // Output: The index in the heap of the left child of i
    // Running Time: O(1)
    public int left(int i){
        return i*2 +1;
    }

    // Input: i: an array index
    // Output: The index in the heap of the right child of i
    // Running Time: O(1)
    public int right(int i){
        return 2*i + 2;
    }
    public Subscription getMax(){
        return heap[0];
    }

    // Input: list: a list to add to the heap
    // Output: adds subscription to the heap and corrects the order to keep it max heap by calling heapIncreaseKey()
    // Running Time: O(1) for adding the subscription to array + O(log n) for heapIncreaseKey = O(log n)
    public void add(Subscription p){
        heap[currSize] = p;
        if(currSize < heap.length){
            currSize += 1;
            heapIncreaseKey(currSize -1);
        }
        else{
            System.out.println("no more readers");
        }
    }

    public int getIndex(int id) {
        for (int i = 0 ; i<currSize;i++) {
            if (heap[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // Input: none
    // Output: heap modified so the last value added isn't violating the heap property
    // Running Time: O(log n) where n = heap-size[A]
    public void heapIncreaseKey(int i){
        while (i > 0 && heap[parent(i)].getNumOfBooks() < heap[i].getNumOfBooks()){
            Subscription temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    // Input: none
    // Output: data of index removed
    // Running Time: O(1) for removing + O(log n) for heapify = O(log n)
    public void Delete(int index){
        heap[index]= heap[currSize];
        heap[currSize]= null;
        currSize = currSize - 1;
        heapify(index);
    }

    // Input: i: an array index
    // Output: heap modified so i isn't violating the heap property
    // Running Time: O(log n) where n = heap-size[A] − i
    public void heapify(int i){
        int l = left(i);
        int r = right(i);
        int max;
        if (l < currSize && heap[l].getNumOfBooks() < heap[i].getNumOfBooks()){
            max = l;
        } else {
            max = i;
        }
        if(r < currSize && heap[r].getNumOfBooks() < heap[max].getNumOfBooks()){
            max = r;
        }
        if (max != i){
            Subscription temp = heap[i];
            heap[i] = heap[max];
            heap[max] = temp;
            heapify(max);
        }
    }
    public void printHeap(){
        for (int i = 0; i < currSize; i++) {
            System.out.println("int index" + i + " " + heap[i].getName() + "has " + heap[i].getNumOfBooks() + " books");
            heap[i].printBooks();
        }
    }
}
