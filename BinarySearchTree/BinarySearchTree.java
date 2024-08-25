package DSA.BinarySearchTree;

public class BinarySearchTree {
    private Node root;
    private class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
    }
    public void insert(int value){
      root= insert(value,root);
    }
    public Node insert(int value,Node node){
        if (node == null) {
            node=new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert(value, node.left);
        }
        if(value>node.value){
            node.right=insert(value, node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public void display(){
        if(root==null){
            System.out.println(root);
            return;
        }
        display(root,"Root of:");
    }
    public void display(Node node,String str){
        if(node==null){
            return;
        }
        System.out.println(str+""+node.value+" "+ node.height);
        display(node.left,"left node of"+":"+ node.value);
        display(node.right,"Right node of"+":"+node.value);
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }


    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 &&  balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] arr){
        for(int i:arr){
            insert(i);
        }
//        insert();
//        insertSet(arr,0,arr.length-1);
    }
    private void insertSet(int[] arr, int start,int end){
        if(start>end){
            return;
        }
        int mid=start+(end-start)/2;
        insert(arr[mid]);
        insertSet(arr,start,mid-1);
        insertSet(arr,mid+1,end);
    }

    /** in Order Traversel**/

    public void displaySorted(){
        displaySorted(root);
    }
    private void displaySorted(Node node){
        if(node==null){
            return;
        }
        displaySorted(node.left);
        System.out.println(node.value);
        displaySorted(node.right);
    }

    /** PostOrder Traversel**/
    public void displayPostOrder(){
        displayPostOrder(root);
    }
    private void displayPostOrder(Node node){
        if(node==null){
            return;
        }
        displayPostOrder(node.left);
        displayPostOrder(node.right);
        System.out.println(node.value);
    }
}
