package Solver;

import Structures.Stack;

public class BuildingSeer{
    private Stack st;

    public BuildingSeer(int max_bd){
        st = new Stack(max_bd);
    }

    public void newBuilding(int height){
        st.push(height);
    }

    public int visibleBuildingNum(){
        int ret = 0, max_h = 0, bd = 0;
        while(!st.isempty()) {
            bd = st.pop();
            if(bd <= max_h) continue;
            ret++;
            max_h = bd;
        }
        return ret;
    }
}
