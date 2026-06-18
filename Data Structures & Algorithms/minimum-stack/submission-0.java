class MinStack {

    Stack<Pair> stk;
    public MinStack() {
        stk = new Stack();
    }
    
    public void push(int val) {
        Pair p;
        if(stk.isEmpty()){
            p = new Pair(val,val);
        }
        else{
            Pair top = stk.peek();
            if(top.min > val){
                p = new Pair(val,val);
            }
            else{
                p = new Pair(val,top.min);
            }
        }
        stk.push(p);
    }
    
    public void pop() {
        if(!stk.isEmpty()){
            stk.pop();
        }
    }
    
    public int top() {
        if(stk.isEmpty()){
            return -1;
        }
        return stk.peek().num;
    }
    
    public int getMin() {
        if(stk.isEmpty()){
            return -1;
        }
        return stk.peek().min;
    }
}

class Pair{
    int num;
    int min;

    public Pair(int num, int min){
        this.num = num;
        this.min = min;
    }
}
