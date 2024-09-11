package DoublyLinkedList;

class Node {

    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
    }
}

public class DoublyLinkedList {

    Node head;
    Node tail;
    int length;

//printList()
//append(int value)
//prepend(int value)
//removeLast()
//removeFirst()
//get(int index)
//set(int index, int value)
//insert(int index, int value)
    // constructor to creat new Linked List
    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;

        if (length == 1) { // Change 1: Handle single element case
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null; // Safely set tail's next to null
            temp.prev = null; // Disconnect the node to be removed
        }

        length--;
        // return the removed element 
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
            head.prev = null;

        }
        length--;
        return temp;
    }

    public Node get(int index) {
        // boundary condition 
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node after = get(index);
        Node before = after.prev;
        before.next = newNode;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;
        length++;
        return true;
    }

    Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        
        length--;
        return temp;
    }

}
