class StackNode{
    char data;
    StackNode link;

    static StackNode top;

    public int testPair(String exp){
        char symbol, open_pair;
        int i, length = exp.length();
        StackNode top = null;

        for(i = 0; i< length; i++){
            symbol = exp.charAt(i);
            switch(symbol){
                case '(':
                case '[':
                case '{':
                    push(symbol); break;

                case ')':
                case ']':
                case '}':
                    if(isStackEmpty() == 1){
                        return 0;
                    }
                    else{
                        open_pair = pop();
                        if((open_pair == '(' && symbol != ')') ||
                                (open_pair == '[' && symbol != ']') ||
                                (open_pair == '{' && symbol != '}')){
                            return 0;
                        }
                        else{
                            break;
                        }
                    }
            }
        }
        if(top != null){
            return 0;
        }
        else{
            return 1;
        }
    }

    public int isStackEmpty(){
        if(top != null){
            return 0;
        } else{
            return 1;
        }
    }

    public void push(char item){
        StackNode temp = new StackNode();
        temp.data = item;
        temp.link = top;
        top = temp;
    }

    public char pop(){
        char item;
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

public class Assignment5_3 {
    public static void main(String[] args){
        StackNode stack = new StackNode();
        int item;

        String expressStr = "{(A+B)-3}*5+[{cos(x+y)+7}-1]*4";

        System.out.println(expressStr);

        if(stack.testPair(expressStr) == 1){
            System.out.println("\n수식의 괄호가 맞게 사용되었습니다!");
        }
        else{
            System.out.println("\n수식의 괄호가 틀렸습니다!");
        }
    }
}