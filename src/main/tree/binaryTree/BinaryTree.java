package main.tree.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树练习
 */
public class BinaryTree {

    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){

        TreeNode node = null;

        if ((inputList == null || inputList.isEmpty())){
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;

    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        preOrderTraveral(node.leftChild);
        System.out.print(node.data);
        preOrderTraveral(node.rightChild);
    }


    /**
     * 后续遍历
     * @param node
     */
    public static void postOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
        System.out.print(node.data);
    }


    /**
     * 二叉树前序遍历(栈实现，非递归)
     * @param root
     */
    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                System.out.print(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 广度优先遍历(队列实现)
     * @param root
     */
    public static void levelOrderTraveral(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data);
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        preOrderTraveral(treeNode);
        System.out.println();
//        inOrderTraveral(treeNode);
//        System.out.println();
//        postOrderTraveral(treeNode);
        preOrderTraveralWithStack(treeNode);
        System.out.println();
        levelOrderTraveral(treeNode);
    }



}
