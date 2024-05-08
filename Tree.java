package tree;
class Node {
    int data;
    Node left;
    Node right;

    //constructor
    public Node(int data){
        this.data = data;
    }
}
public class Tree {
    Node root; // poiting to null address

    public void insert(int data) {
        root = insertRec(root, data);

    }

    //node method
    public Node insertRec (Node root, int data) {
        //create root node
        if (root == null)
            root = new Node(data);

        //change root to the left
        else if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
    public void inorder_traverse(){
        inorder_traverse_rec(root);
    }

    //left - root - right
    public void inorder_traverse_rec(Node root){
        if(root != null){
            inorder_traverse_rec(root.left);
            System.out.print(root.data + " ");
            inorder_traverse_rec(root.right);
        }
    }
}

