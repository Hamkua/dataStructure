class QueueType:
    def __init__(self, front = -1, rear = -1):
        self.queue = [0,0,0,0]
        self.front = front
        self.rear = rear

def isQueueEmpty(Q):
    if(Q.front == Q.rear):
        print(" Queue is empty! \n\t" ,end ="")
        return 1    
    return 0

def isQueueFull(Q):
    if(Q.rear == 3):
        print("Queue is full! \n\t", end="")
        return 1
    return 0

def enQueue(Q, item):
    if(isQueueFull(Q) == 0):
        Q.rear += 1
        Q.queue[Q.rear] = item

def deQueue(Q):
    if(isQueueEmpty(Q) == 0):
        Q.front+= 1
        return Q.queue[Q.front]

def peekQ(Q):
    if(isQueueEmpty(Q) == 0):
        return Q.queue[Q.front + 1]

def printQ(Q):
    print("Queue : [", end="")
    for i in range(Q.front + 1, Q.rear + 1):
        if(Q.queue[i] != 0):
            print("  {}".format(Q.queue[i]), end="")
        
    print(" ] ", end="")


Q1 = QueueType()

print("\n ***** 순차 큐 연산 ***** \n", end="")
print("\n 삽입 A>>", end="")
enQueue(Q1, 'A')
printQ(Q1)

print("\n 삽입 B>>", end="")
enQueue(Q1, 'B')
printQ(Q1)

print("\n 삽입 C>>", end="")
enQueue(Q1, 'C')
printQ(Q1)

data = peekQ(Q1)
print(" peek item : {} \n".format(data), end="")
print("\n 삭제 >>", end="")
data = deQueue(Q1)
printQ(Q1)
print("\t삭제 데이터: {}".format(data), end="")

print("\n 삭제 >>", end="")
data = deQueue(Q1)
printQ(Q1)
print("\t삭제 데이터: {}".format(data), end="")

print("\n 삭제 >>", end="")
data = deQueue(Q1)
printQ(Q1)
print("\t\t삭제 데이터: {}".format(data), end="")

print("\n 삽입 D>>", end="")
enQueue(Q1, 'D')
printQ(Q1)

print("\n 삽입 E>>", end="")
enQueue(Q1, 'E')
printQ(Q1)