package Solver;

import Structures.Queue;

public class Restaurant {
    private Queue q;
    private int n, m;

    public Restaurant(int max_student){
        q = new Queue(max_student);
        n = 0;
        m = 0;
    }

    public void newStudent(int stu_id){
        q.push(stu_id);
        if(q.length() > m) m = q.length();
    }

    public void serve(){
        n = q.pop();
    }

    public String answer(){
        return n + " " + m;
    }
}
