class MinStack {
    int n;
    int arr[];
    int ptr;
    Stack<Integer> min=new Stack<>();
    public MinStack() {
        n=10000;
        arr=new int[n];
        ptr=-1;
    }

    public void push(int val) {
        if(ptr==n-1){
        System.out.println("stack overflow");
        return;
        }
        else
        {
            ptr++;
            arr[ptr]=val;
        }
        if(min.isEmpty()||min.peek()>=val)
        min.push(val);
    }

    public void pop() {
        if(ptr==-1){
        System.out.println("stack underflow");
        return;
        }
        else
        {
            if(arr[ptr]==min.peek()){
            min.pop();
        }
        ptr--;
        }
    }

    public int top() {
        return arr[ptr];
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */