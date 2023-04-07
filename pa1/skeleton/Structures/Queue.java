package Structures;

public class Queue {
    private int[] arr;
    private int max_size;
    int hd, tl;

    public Queue(int max_len){
        max_size = max_len;
        arr = new int[max_size + 1];
        hd = 0;
        tl = 0;
    }

    public void clear(){
        hd = 0;
        tl = 0;
    }

    public boolean isempty(){
        return (tl == hd);
    }

    public int length(){
        return tl - hd;
    }

    public void push(int val){
        arr[tl++] = val;
        if(tl == max_size) tl = 0;
    }

    public int pop(){
        int ret = arr[hd++];
        if(hd == max_size) hd = 0;
        return ret;
    }
}
