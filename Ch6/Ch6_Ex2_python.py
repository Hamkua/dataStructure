
class QueueType:
    def __init__(self, front = None, rear = None):
        self.queue = [0,0,0,0]
        self.front = 0
        self.rear = 0

def isCQueueEmpty(cQ):
    if(cQ.front == cQ.rear):
        print(" Circular Queue is empty! ", end="")
        return 1
    return 0

def isCQueueFull(cQ):
    if(((cQ.rear +1 ) % 4) == cQ.front):
        print(" Circular Queue is Full!", end="")
        return 1
    return 0

def enCQueue(cQ, item):
    if(isCQueueFull(cQ)):
        return 0
    cQ.rear = (cQ.rear +1) % 4
    cQ.queue[cQ.rear] = item

def deCQueue(cQ):
    if(isCQueueEmpty(cQ)):
        return 0
    cQ.front = (cQ.front + 1) % 4
    return cQ.queue[cQ.front]

def peekCQ(cQ):
    if(isCQueueEmpty(cQ)):
        return 0
    return cQ.queue[(cQ.front + 1) % 4]


def printCQ(cQ):
    first = (cQ.front + 1) % 4
    last = (cQ.rear + 1) % 4
    print(" Circular Queue : [",end="")
    i = first
    while(i!=last):
        print("  {}".format(cQ.queue[i]),end="")
        i = (i + 1) % 4
    print(" ] ",end="")

cQ = QueueType()
print("\n ***** 원형 큐 연산 ***** \n", end="")
print("\n 삽입 A>>", end="") 
enCQueue(cQ, 'A') 
printCQ(cQ)
print("\n 삽입 B>>", end="") 
enCQueue(cQ, 'B') 
printCQ(cQ)
print("\n 삽입 C>>", end="") 
enCQueue(cQ, 'C') 
printCQ(cQ)
data = peekCQ(cQ)
print(" peek item : {}".format(data), end="")
print("\n 삭제 >>", end="") 
data = deCQueue(cQ) 
printCQ(cQ)
print("\t 삭제 데이터 : {}".format(data), end="")
print("\n 삭제 >>", end="") 
data = deCQueue(cQ) 
printCQ(cQ)
print("\t 삭제 데이터 : {}".format(data), end="")
print("\n 삭제 >>", end="") 
data = deCQueue(cQ) 
printCQ(cQ)
print("\t\t 삭제 데이터 : {}".format(data), end="")

print("\n 삽입 D>>", end="") 
enCQueue(cQ, 'D') 
printCQ(cQ)
print("\n 삽입 E>>", end="") 
enCQueue(cQ, 'E') 
printCQ(cQ)