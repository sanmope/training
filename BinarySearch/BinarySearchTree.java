package BinarySearch;

public class BinarySearchTree{
    
    class Node{
        int key;
        Node left,right;

        public Node(int item){
            this.key = item;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    public BinarySearchTree(){
        root = null;
    }

    void insert(int item){
        root = insertRec(root,item);
    }

    public Node insertRec(Node node, int item){
        if (node == null){
            node = new Node(item);
            return node;
        }
        if (node.key > item){
            node.left = insertRec(node.left, item);
        }else{
            node.right = insertRec(node.right, item);
        }
        return node;
        
    }
    

    Node getNode(int key){
        return getNodeRec(root,key);
    }

    private Node getNodeRec(Node root, int key) {
        if (root.key == key){
            return root;
        }
        if (root.key > key){
            if (root.left == null){
                return root;
            }else{
                return getNodeRec(root.left, key);
            }
        }else{
            if (root.right == null){
                return root;
            }else{
                return getNodeRec(root.right, key);
            }
        }
    }

    void inorder() 
    { 
        inorderRec(root); 
    }
 
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public static void main (String[] args){
       BinarySearchTree binarySearchTree = new BinarySearchTree();

       binarySearchTree.insert(8);
       binarySearchTree.insert(9);
       binarySearchTree.insert(11);
       binarySearchTree.insert(10);
       binarySearchTree.insert(12);

       binarySearchTree.inorder();
       Node node =binarySearchTree.getNode(11);
       System.out.println(node.key
                + node.right.toString() 
                + node.left.toString());
    }

}