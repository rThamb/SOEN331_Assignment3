package ADT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryHeap{

    private ArrayList<Node> allNodes;

    public BinaryHeap(int size){
        allNodes = new ArrayList<Node>(size);
    }


    public void insert(Integer key, String value){

        Node newNode = new Node(key, value);
        int lastLeafIndex = allNodes.size();
        int lastLeafParent = getParent(lastLeafIndex);
        allNodes.add(newNode);

        heapify(lastLeafParent);

    }

    public String getMin(){
        Node min = allNodes.get(0);
        return (String)min.getValue();
    }

    public String remove(){

        swap(0, allNodes.size() - 1);
        String minValue = allNodes.remove(allNodes.size() - 1).getValue();

        heapify(0);

        return minValue;
    }

    private void heapify(int parentIndex)
    {
        if(parentIndex == -1)
            return;

        int length = allNodes.size();

        //Construct a min heap
        int leftChild = leftChild(parentIndex);
        int rightChild = rightChild(parentIndex);
        int nextParent = parentIndex;

        //check whether
        if((leftChild < length) && (allNodes.get(leftChild).getKey()  < allNodes.get(nextParent).getKey()))
            nextParent = leftChild;

        if((rightChild < length) && (allNodes.get(rightChild).getKey()  < allNodes.get(nextParent).getKey()))
            nextParent = rightChild;

        if(length != 0 && allNodes.get(parentIndex).getKey() > allNodes.get(nextParent).getKey()) {
            swap(parentIndex, nextParent);
            heapify(nextParent);
        }
    }




    /*
        Helper Method used
     */

    private void swap(int value1, int value2) {
        Collections.swap(allNodes, value1, value2);
    }

    private int getParent(int index){
        return ((int)index / 2) - 1;
     }

    private int leftChild(int index)
    {
        return index*2+1;
    }

    private int rightChild(int index)
    {
        return index*2+2;
    }

}
