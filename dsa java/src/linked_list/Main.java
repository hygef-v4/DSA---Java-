package linked_list;

public class Main{

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(12);
        list.insert(23);
        list.insertAtStart(5);

        list.insertAt(1,4);
        list.insertAt(0,6);
        list.show();

        System.out.println("After remove: index 2");
        list.remove(2);
        list.show();
    }
}


