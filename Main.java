package BinarySearchTree;

import DSA.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.populate(new int[]{6,2,3,88,5,1,0,778,9});
        binarySearchTree.displayPostOrder();
    }
}
