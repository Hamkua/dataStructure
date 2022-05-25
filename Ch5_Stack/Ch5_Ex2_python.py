class StackNode:
    def __init__(self, data=None, link=None):
        self.data = data
        self.link = link

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


def peek():
    global top
    if(isStackEmpty() == 1):
        print("Stack is Empty!")
        return 0
    else:
        return top.data


def printStack():
    global top
    p = top
    print("\nSTACK [", end="")
    while(p!=None and p.data!= None):
        print("{} ".format(p.data),end="")
        p = p.link
    print("] ",end="")


print("\n ** 순차 스택 연산 **\n")
print()
push(1) 
printStack()
push(2)
printStack()
push(3) 
printStack()

item = peek()
printStack()
print("peek -> {}".format(item),end="")

item = pop()
printStack()
print("\t pop -> {}".format(item),end="")

item = pop()
printStack()
print("\t pop -> {}".format(item),end="")

item = pop()
printStack()
print("\t pop -> {}".format(item),end="")