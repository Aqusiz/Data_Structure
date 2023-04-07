package Structures;

public class Stack{
    private int[] arr;
    private int max_size;
    private int idx;

    public Stack(int max_len){
        max_size = max_len;
        arr = new int[max_size];
        idx = 0;
    }

    public void clear(){
        idx = 0;
    }

    public boolean isempty(){
        return (idx == 0);
    }

    public int length(){
        return idx;
    }

    public void push(int val){
        arr[idx++] = val;
    }

    public int pop(){
        return arr[idx--];
    }
}
