package main.array;

public class MyArray {

    int [] array;
    int size;

    public MyArray(int capacity){
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insert(int data, int index){
        if (index < 0 || index > size){
            throw new RuntimeException("超出数组界限!");
        }
        if (size >= array.length){
            resize();
        }
        //从右向左，将元素逐个移动一位
        for (int i = size - 1; i >= index; i--){
            array[i + 1] = array[i];
        }

        array[index] = data;
        size++;
    }

    public void remove(int index){
        if (index < 0 || index >= size){
            throw new RuntimeException("超出数组界限");
        }
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
    }

    public void resize(){
        int [] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray,0, array.length);
        array = newArray;
    }


    public void outPut(){
        for (int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        MyArray myArray = new MyArray(3);
        myArray.insert(10, 0);
        myArray.insert(20, 1);
        myArray.insert(30,1);
        myArray.insert(40,3);
        myArray.remove(4);
        myArray.outPut();
    }



}
