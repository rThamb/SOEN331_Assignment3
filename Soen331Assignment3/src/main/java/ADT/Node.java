package ADT;


/**
 * For this implementation, the Node class will not have right and left child nodes, as an array will be
 * used to hold all nodes, and parent and children will be determined using indices.
 *
 * @param <T>
 */


public class Node{

    private Integer key;
    private String value;

    public Node(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

