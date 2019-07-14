package main.linked;

/**
 * 链表操作练习
 */
public class MyLinkedList {

    private Node head;

    private Node last;

    private int size;



    public void insert(int data, int index){
        if (index < 0 || index > size){
            throw new RuntimeException("超出链表范围!");
        }
        Node insertNode = new Node(data);
        if (size == 0){
            head = insertNode;
            last = insertNode;
        }else if(size == index){//尾部插入
            last.next = insertNode;
            last = insertNode;
        }else{//中间插入
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next;
            prevNode.next = insertNode;
            insertNode.next = nextNode;
        }
        size++;
    }


    public Node get(int index){
        if (index < 0 || index >= size){
            throw new RuntimeException("超出链表范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        size--;
        return temp;

    }

    public Node remove(int index){
        if (index < 0 || index >= size){
            throw new RuntimeException("超出链表范围");
        }
        Node removeNode = null;
        if (index == 0){//移除头部
            removeNode = head;
            head = head.next;
            removeNode.next = null;
        }else if (index == size - 1){//移除尾部
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {//移除中间
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            Node nextNode = prevNode.next.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;

    }

    public void outPut(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }



    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0 ; i < 20; i++){
            myLinkedList.insert(i + 1, i);
        }
        myLinkedList.remove(0);
        myLinkedList.remove(1);
        myLinkedList.outPut();
    }



}
