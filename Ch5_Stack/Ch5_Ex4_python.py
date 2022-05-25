class StackNode:
    def __init__(self, data=None, link=None):
        self.data = data
        self.link = link

def evalPostfix(exp):
    global top
    length = len(exp)
    
    top = None
    for i in range(length):
        symbol = exp[i]
        if(symbol != '+' and symbol != '-' and symbol != '*' and symbol != '/'):
            value = int(symbol)
            push(value)

        else:
            opr2 = pop()
            opr1 = pop()
            if(symbol == '+'):
                push(opr1 + opr2)
            elif(symbol == '-'):
                push(opr1 - opr2)
            elif(symbol == '*'):
                push(opr1 * opr2)
            elif(symbol == '/'):
                push(opr1 / opr2)
    return pop()

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



express = "35*62/-"
print("후위 표기식 : {}".format(express))

result = evalPostfix(express)

print("\n연산 결과 -> {}".format(result))