class StackNode{
    int data;
    StackNode link;

    static StackNode top;

    public int evalPostfix(String exp){
        char symbol;
        int opr1, opr2;
        int value;
        int length = exp.length();
        StackNode top = null;

        for(int i = 0; i< length; i++) {
            symbol = exp.charAt(i);
            if(symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/'){
                value = (int)symbol - 48;    //아스키코드값으로 변환된다...
                push(value);

            } else{
                opr2 = pop();
                opr1 = pop();

                switch (symbol){
                    case '+': push((opr1 + opr2)); break;
                    case '-': push((opr1 - opr2)); break;
                    case '*': push((opr1 * opr2)); break;
                    case '/': push((opr1 / opr2)); break;
                }
            }
        }
        return pop();
    }

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
            return ' ';
        } else{
            item = temp.data;
            top = temp.link;
            return item;
        }
    }
}

public class Assignment5_4 {
    public static void main(String[] args){
        StackNode stack = new StackNode();
        int result;

        String express = "35*62/-";
        System.out.println("후위 표기식 : " + express);
        result = stack.evalPostfix(express);
        System.out.println("\n연산 결과 -> " + result);
    }
}