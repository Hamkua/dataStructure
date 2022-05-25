stackarr = [0 for _ in range(100)]

top = -1
def isStackEmpty():
    global top
    if(top == -1):
        return 1
    return 0

def isStackFull():
    global top
    if(top == 99):
        return 1
    return 0

def push(item):
    global top
    if(isStackFull() == 1):
        print("\n Stack is FULL!")
    else:
        top += 1
        stackarr[top] = item
    

def pop():
    global top
    if(isStackEmpty() == 1):
        print("Stack is Empty!")
        return 0
    else:
        top -= 1
        return stackarr[top]

def peek():
    global top
    if(isStackEmpty() == 1):
        print("Stack is Empty!")
        return 0
    else:
        return stackarr[top]

def printStack():
    global top
    print("\nSTACK [", end="")
    for i in range(top+1):
        print("{} ".format(stackarr[i]),end="")
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