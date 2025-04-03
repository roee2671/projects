package Mavo_Le_Hisuve.Ex3;

import Mavo_Le_Hisuve.Ex3.pdfUtils.BinaryTree;
import Mavo_Le_Hisuve.Ex3.pdfUtils.BinaryTreeClass;

public class binaryTree {

    public static boolean checkTree(BinaryTree<Integer> T, int L){
        if(T == null && T.isEmpty()){
            return false;
        }
        return BinaryTreeHelper(T,0,L);
    }
    public static boolean BinaryTreeHelper (BinaryTree<Integer> node,int level ,int L){
        if (node == null) {
            return true;
        }

        if (node.isEmpty()) {
            return false;
        }
        if (level >= L) {
            if (node.getRoot() <= 10 || node.getRoot() % 2 != 0) {
                return false;
            }
        }
        boolean hesLeft = node.getLeft() != null && !node.getLeft().isEmpty();
        boolean hesRight =node.getRight() != null && !node.getRight().isEmpty();

        if(hesLeft != hesRight){
            return false;
        }

        boolean leftCheck = BinaryTreeHelper(node.getLeft(), level + 1, L);
        boolean rightCheck = BinaryTreeHelper(node.getRight(), level + 1, L);


        return leftCheck && rightCheck;
    }
    public static void main(String[] args) {
        BinaryTreeClass<Integer> root = new BinaryTreeClass<>();
        root.setRoot(20);

        BinaryTreeClass<Integer> leftChild = new BinaryTreeClass<>();
        leftChild.setRoot(12);

        BinaryTreeClass<Integer> rightChild = new BinaryTreeClass<>();
        rightChild.setRoot(16);

        root.setLeft(leftChild);
        root.setRight(rightChild);

        BinaryTreeClass<Integer> leftLeft = new BinaryTreeClass<>();
        leftLeft.setRoot(14);

        BinaryTreeClass<Integer> leftRight = new BinaryTreeClass<>();
        leftRight.setRoot(18);

        leftChild.setLeft(leftLeft);
        leftChild.setRight(leftRight);

        BinaryTreeClass<Integer> rightLeft = new BinaryTreeClass<>();
        rightLeft.setRoot(22);

        BinaryTreeClass<Integer> rightRight = new BinaryTreeClass<>();
        rightRight.setRoot(24);

        rightChild.setLeft(rightLeft);
        rightChild.setRight(rightRight);

        int L = 1;

        boolean result = binaryTree.checkTree(root, L);

        System.out.println("Result: " + result);
    }
}
