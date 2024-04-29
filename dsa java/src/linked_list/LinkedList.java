package linked_list;
// insertAt()
// insertAtIndex()
//delete()
//show()
public class LinkedList {
    //node object
    Node head;

    public void insert(int data) {
        // create a new node
        Node new_node = new Node();
        // assign value to the new node
        new_node.data = data;

        // if list is empty
        if (head == null) {
            head = new_node;
        }
        //if node is not empty ->
        else {
            Node n = head;

            while (n.next != null) {
                n = n.next;
            }
            n.next = new_node;
        }
    }

    public void insertAtStart(int data) {
        Node new_node = new Node();
        // assign value to the new node
        new_node.data = data;

        //head: new_node -> node_1
        new_node.next = head;
        head = new_node;
    }
    // index
    public void insertAt(int index, int data) {
        Node new_node = new Node();
        new_node.data = data;
        if (index == 0){
            insertAtStart(data);
        }
        else{
            Node n = head;

            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            // replace
            new_node.next = n.next;
            n.next = new_node;
        }
    }
    public void remove(int index){
        if (index ==0){
            head = head.next;
        }
        else{
            Node n = head;
            Node delete_node = null;
            for (int i =0 ; i < index-1; i++){
                n = n.next;
            }
            delete_node = n.next;
            n.next = delete_node.next;
            //remove from memory
            delete_node = null;
        }
    }
    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

}