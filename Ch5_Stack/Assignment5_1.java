class Stack{
    static int top = -1;
    int[] stackarr = new int[100];

    public int isStackEmpty(){
        if(top == -1){
            return 1;
        }
        return 0;
    }

    public int isStackFull(){
        if(top == 99){
            return 1;
        }
        return 0;
    }

    public void push(int item){
        if(isStackFull() == 1){
            System.out.println("\n Stack is FULL!");
        } else{
            stackarr[++top] = item;
        }
    }

    public int pop(){
        if(isStackEmpty() == 1){
            System.out.println("\nStack is Empty!");
            return 0;
        }
        return stackarr[top--];
    }

    public int peek(){
        if(isStackEmpty() == 1){
            System.out.println("\nStack is Empty!");
            return 0;
        }
        else return stackarr[top];
    }

    public void printStack(){
        System.out.print("\n STACK [");
        for(int i =0; i<= top; i++){
            System.out.print(stackarr[i] + " ");
        }
        System.out.print("] ");
    }
}

public class Assignment5_1 {
    public static void main(String[] args){
        Stack stack = new Stack();
        int item;
        System.out.print("\n ** 순차 스택 연산 **\n");
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