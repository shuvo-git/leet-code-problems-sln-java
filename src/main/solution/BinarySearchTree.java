package main.solution;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/27/2023
 * @time: 10:55 AM
 */

public class BinarySearchTree {
    private final int size;
    Integer[] values;

    public BinarySearchTree() {
        this.size = 16;
        values = new Integer[this.size];
    }

    public BinarySearchTree(int size) {
        this.size = size;
        values = new Integer[this.size];
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);
        bst.insert(8);
        bst.insert(10);
        bst.insert(6);
        bst.insert(3);


        bst.printTree(0);
    }

    public void insert(int val) {
        int i = 0;

        while (i < this.size && values[i] != null) {
            Integer tmp = values[i];
            if (val <= tmp) {
                i = 2 * i + 1;
            } else {
                i = 2 * i + 2;
            }
        }
        if (i >= this.size)
            System.out.println("BST FULL");
        else
            values[i] = val;
    }

    public void printTree(int i) {
        if (i >= this.size || values[i] == null)
            return;

        printTree(2 * i + 1);
        System.out.printf("%d ", this.values[i]);
        printTree(2 * i + 2);
    }
}
