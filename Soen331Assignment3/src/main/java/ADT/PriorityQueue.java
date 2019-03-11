package ADT;

public class PriorityQueue{

    private BinaryHeap heap;
    private int size;

    public PriorityQueue(int size){
        this.size = size;
        heap = new BinaryHeap(size);
    }

    public void insert(Integer key, String value){
        heap.insert(key, value);
    }

    public String remove(){
        return (String)heap.remove();
    }

    public String min(){
        return (String)heap.getMin();
    }
}
