class QNode:
    def __init__(self):
        self.link = None
        self.data = None

class LQueueType:
    def __init__(self):
        self.front = None
        self.rear = None
    

def isLQEmpty(LQ):
    if(LQ.front == None):
        print(" Linked Queue is empty!",end="")
        return 1
    return 0

def enLQueue(LQ, item):
    newNode = QNode()
    newNode.data = item

    if(LQ.front == None):
        LQ.front = newNode
        LQ.rear = newNode
    else:
        LQ.rear.link = newNode
        LQ.rear = newNode

def deLQueue(LQ):
    old = LQ.front
    if(isLQEmpty(LQ)):
        return 0
    item = old.data
    LQ.front = LQ.front.link
    if(LQ.front == None):
        LQ.rear = None
    return item

def peekLQ(LQ):
    if(isLQEmpty(LQ)):
        return 0
    item = LQ.front.data
    return item

def printLQ(LQ):
    temp = LQ.front
    print(" Linked Queue : [",end="")
    while(temp):
        print("  {}".format(temp.data),end="")
        temp = temp.link
    print(" ] ",end="")

LQ = LQueueType()
print("\n ***** 원형 큐 연산 ***** \n",end="")
print("\n 삽입 A>>",end="") 
enLQueue(LQ, 'A') 
printLQ(LQ)
print("\n 삽입 B>>",end="") 
enLQueue(LQ, 'B') 
printLQ(LQ)
print("\n 삽입 C>>",end="") 
enLQueue(LQ, 'C') 
printLQ(LQ)
data = peekLQ(LQ)
print(" peek item : {}".format(data),end="")
print("\n 삭제 >>",end="") 
data = deLQueue(LQ) 
printLQ(LQ)
print("\t 삭제 데이터 : {}".format(data),end="")
print("\n 삭제 >>",end="") 
data = deLQueue(LQ) 
printLQ(LQ)
print("\t 삭제 데이터 : {}".format(data),end="")
print("\n 삭제 >>",end="") 
data = deLQueue(LQ) 
printLQ(LQ)
print("\t\t 삭제 데이터 : {}".format(data),end="")

print("\n 삽입 D>>",end="") 
enLQueue(LQ, 'D') 
printLQ(LQ)
print("\n 삽입 E>>",end="") 
enLQueue(LQ, 'E') 
printLQ(LQ)