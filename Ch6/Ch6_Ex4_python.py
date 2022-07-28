
class DQNode:
    def __init__(self):
        self.data = None
        self.llink = None
        self.rlink = None

class DQueType:
    def __init__(self):
        self.front = None
        self.rear = None

def isDeQEmpty(DQ):
    if(DQ.front == None):
        return 1
    return 0

def insertFront(DQ, item):
    newNode = DQNode()
    newNode.data = item

    if(isDeQEmpty(DQ)):
        DQ.front = newNode
        DQ.rear = newNode
        newNode.rlink = None
        newNode.llink = None
    else:
        DQ.front.llink = newNode
        newNode.rlink = DQ.front
        newNode.llink = None
        DQ.front = newNode

def insertRear(DQ, item):
    newNode = DQNode()
    newNode.data = item
    if(isDeQEmpty(DQ)):
        DQ.front = newNode
        DQ.rear = newNode
        newNode.rlink = None
        newNode.llink = None
    else:
        DQ.rear.rlink = newNode
        newNode.llink = DQ.rear
        newNode.rlink = None
        DQ.rear = newNode 

def deleteFront(DQ):
    old = DQ.front
    if(isDeQEmpty(DQ)):
        print("\n Linked deQue is empty! ") 
        return 0

    else:
        item = old.data
        if(DQ.front.rlink == None):
            DQ.front = None
            DQ.rear = None
        else:
            DQ.front = DQ.front.rlink
            DQ.front.llink = None

        return item

def deleteRear(DQ):
    old = DQ.rear
    if(isDeQEmpty(DQ)):
        print("\n Linked deQue is empty! ") 
        return 0
    
    else:
        item = old.data
        if(DQ.rear.llink == None):
            DQ.front = None
            DQ.rear = None
        else:
            DQ.rear = DQ.rear.llink
            DQ.rear.rlink = None
    
        return item

def peekFront(DQ):
    if(isDeQEmpty(DQ)):
        print("\n Linked deQue is empty! ") 
        return 0
    else:
        item = DQ.front.data
        return item

def peekRear(DQ):
    if(isDeQEmpty(DQ)):
        print("\n Linked deQue is empty! ")
        return 0
    else:
        item = DQ.rear.data
        return item

def printDQ(DQ):
    temp = DQ.front
    print("DeQue : [", end="")
    while(temp):
        print("  {}".format(temp.data), end="")
        temp = temp.rlink
    print(" ] ", end="")

DQ1 = DQueType()
print("\n ***** 데크 연산 *****\n", end="")
print("\n front 삽입 A>> ", end="") 
insertFront(DQ1, 'A') 
printDQ(DQ1)
print("\n front 삽입 B>> ", end="") 
insertFront(DQ1, 'B') 
printDQ(DQ1)
print("\n rear 삽입 C>> ", end="") 
insertRear(DQ1, 'C') 
printDQ(DQ1)

print("\n front 삭제 >> ", end="") 
data = deleteFront(DQ1) 
printDQ(DQ1)
print("\t 삭제 데이터: {}".format(data), end="")

print("\n rear 삭제 >> ", end="") 
data = deleteRear(DQ1) 
printDQ(DQ1)
print("\t 삭제 데이터: {}".format(data),end="")


print("\n rear 삽입 D >> ", end="") 
insertRear(DQ1, 'D') 
printDQ(DQ1)
print("\n front 삽입 E >> ", end="") 
insertFront(DQ1, 'E') 
printDQ(DQ1)
print("\n front 삽입 F >> ", end="") 
insertFront(DQ1, 'F') 
printDQ(DQ1)

data = peekFront(DQ1) 
print("\n peek Front item : {}".format(data))
data = peekRear(DQ1) 
print(" peek Rear item : {}".format(data))