package ADT;

import be.ac.ua.ansymo.adbc.annotations.requires;
import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;



@invariant  ({
		"$this.heap.getSize() >= 0",
		"$this.capacity > 0",
		"$this.heap.getSize() <= $this.capacity"
	    })
public class PriorityQueue{

    private BinaryHeap heap;
    private int capacity;

    @requires ({
                "capacity > 0"
              })
    @ensures ({
                "$this.capacity == capacity",
                "$this.capacity > 0",
                "$this.heap.getSize() <= $this.capacity",
                "$this.heap.getList() != null"
             })
    public PriorityQueue(int capacity){
        this.capacity = capacity;
        heap = new BinaryHeap(capacity);
    }

    @requires ({
                "key >= 0",
                "value != null",
                "$this.heap.isFull() == false"
              })
    @ensures ({
                "$this.heap.getList.contains(new Node(key,value))",
                "$this.heap.getSize() == $old($this.heap.getSize()) + 1"
             })
    public void insert(Integer key, String value){
        heap.insert(key, value);
    }

    @requires({
                "$this.heap.isEmpty() == false"
             })
    @ensures ({
                "$result != null",
                "$result == $old($this.heap.getList.get(0))",
                "$this.heap.getSize() == $old($this.heap.getSize()) + -1"
             })
    public String remove(){
        return (String)heap.remove();
    }

    @requires({
                "$this.heap.isEmpty() == false"
             })
    @ensures ({
                "$result != null",
                "$result == $old($this.heap.getList.get(0))"
             })
    public String min(){
        return (String)heap.getMin();
    }
    
}
