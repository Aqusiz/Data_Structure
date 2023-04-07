import Structures.*;
import Solver.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static int MAXLEN = 1000;

    public static void main(String[] args) throws IOException{
        Stack st = new Stack(MAXLEN);
        Queue q = new Queue(MAXLEN);
        BuildingSeer bdsr = new BuildingSeer(MAXLEN);
        Restaurant rstr = new Restaurant(MAXLEN);

        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        PrintWriter output = new PrintWriter(args[1]);
        for(int cnt=0; ; cnt++){
            String line = input.readLine();
            if (line == null) break;

            String[] tokens = line.split(" ");
            String target = tokens[0];
            String command = tokens[1];
            
            int i = 0;
            switch(target){
                case "stack":
                    switch(command){
                        case "push":
                            i = Integer.parseInt(tokens[2]);
                            st.push(i);
                            output.println("stack pushed: " + i);
                            break;
                        case "pop":
                            i = st.pop();
                            output.println("stack pop: " + i);
                            break;
                        case "clear":
                            st.clear();
                            output.println("stack cleared");
                            break;
                        case "isempty":
                            if (st.isempty())
                                output.println("stack is empty");
                            else
                                output.println("stack is not empty");
                            break;
                        case "length":
                            i = st.length();
                            output.println("stack length: " + i);
                            break;
                    }
                    break;
                case "queue":
                    switch(command){
                        case "push":
                            i = Integer.parseInt(tokens[2]);
                            q.push(i);
                            output.println("queue pushed: " + i);
                            break;
                        case "pop":
                            i = q.pop();
                            output.println("queue pop: "+i);
                            break;
                        case "clear":
                            q.clear();
                            output.println("queue cleared");
                            break;
                        case "isempty":
                            if (q.isempty())
                                output.println("queue is empty");
                            else
                                output.println("queue is not empty");
                            break;
                        case "length":
                            i = q.length();
                            output.println("queue length: " + i);
                            break;
                    }
                    break;
                case "building":
                    for (int n = 1; n < tokens.length; n++){
                        i = Integer.parseInt(tokens[n]);
                        bdsr.newBuilding(i);
                    }
                    output.println("visible buildings: " + bdsr.visibleBuildingNum());
                    break;
                case "restaurant":
                    for (int n = 1; n < tokens.length; n++){
                        i = Integer.parseInt(tokens[n]);
                        if (i > 0)
                            rstr.newStudent(i);
                        else
                            rstr.serve();
                    }
                    output.println("length, stu_id: " + rstr.answer());
                    break;
            }
        }
        input.close();
        output.close();
    }
}
