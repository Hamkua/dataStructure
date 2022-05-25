class StackNode:
    def __init__(self, data=None, link=None):
        self.data = data
        self.link = link

def testPair(exp):
    global top
    length = len(exp)
    for i in range(length):
        symbol = exp[i]
        if(symbol == '(' or symbol == '[' or symbol == '{'):
            push(symbol)
        elif(symbol == ')' or symbol == ']' or symbol == '}'):
            if(isStackEmpty() == 1):
                return 0
            else:
                open_pair = pop()
                if((open_pair == '(' and symbol != ')') or (open_pair == '[' and symbol != ']') or (open_pair == '{' and symbol != '}')):
                    return 0
                else:
                    continue
                
    if(top.data == None):
        return 1
    else: 
        return 0

top = StackNode()

def isStackEmpty():
    if(top == None):
        return 1
    return 0

def push(item):
    global top
    temp = StackNode(item, top)
    top = temp
    

def pop():
    global top
    temp = top
    if(isStackEmpty() == 1):
        print("Stack is Empty!")
        return 0
    else:
        item = temp.data
        top = temp.link
        return item



express = "{(A+B)-3}*5+[{cos(x+y)+7}-1]*4"
print(express , end="")

if(testPair(express) == 1):
    print("\n\n수식의 괄호가 맞게 사용되었습니다!")

else:
    print("\n\n수식의 괄호가 틀렸습니다!")