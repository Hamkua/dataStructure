class StackNode{
    int data;
    StackNode link;

    static StackNode top;

    public int isStackEmpty(){
        if(top != null){
            return 0;
        } else{
            return 1;
        }
    }

    public void push(int item){
        StackNode temp = new StackNode();
        temp.data = item;
        temp.link = top;
        top = temp;
    }

    public int pop(){
        int item;
        StackNode temp = top;

        if(isStackEmpty()==1){
            System.out.println("Stack is empty!");
            return 0;
        } else{
            item = temp.data;
            top = temp.link;
            return item;
        }
    }

    public int peek(){
        if(isStackEmpty() == 1){
            System.out.println("Stack is Empty!");
            return 0;

        } else{
            return top.data;
        }
    }

    public void printStack(){
        StackNode p = top;
        System.out.print("\n STACK [");
        while(p != null){
            System.out.print(p.data + " ");
            p = p.link;
        }
        System.out.print("] ");
    }
}

public class Assignment5_2 {
    public static void main(String[] args){
        StackNode stack = new StackNode();
        int item;
        System.out.print("\n ** 연결 스택 연산 **\n");
        stack.printStack();

        stack.push(1); stack.printStack();
        stack.push(2); stack.printStack();
        stack.push(3); stack.printStack();

        item = stack.peek();
        stack.printStack();
        System.out.print("peek -> " + item);

        item = stack.pop();
        stack.printStack();
        System.out.print("\t pop -> " + item);

        item = stack.pop();
        stack.printStack();
        System.out.print("\t pop -> " + item);

        item = stack.pop();
        stack.printStack();
        System.out.println("\t pop -> " + item);
    }
}