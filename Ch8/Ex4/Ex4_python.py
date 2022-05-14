MAX_VERTEX = 30

class QNode:
    def __init__(self):
        self.data = None
        self.link = None

class LQueueType:
    def __init__(self):
        self.front = None
        self.rear = None

class graphNode:
    def __init__(self):
        self.vertex = None
        self.link = None

class graphType:
    def __init__(self):
        self.n = 0
        self.adjList_H = [None]*MAX_VERTEX
        self.visited = [False]*MAX_VERTEX

def insert_vertex(g,v):
    if(((g.n) + 1)>MAX_VERTEX):
        print("\n 그래프 정점의 개수를 초과하였습니다!",end="")
        return
    g.n += 1
    
def insertEdge(g,n,v):
    node = graphNode()
    if(n >= g.n or v >= g.n):
        print("\n 그래프에 없는 정점입니다!", end="")
        return
    node.vertex = v
    node.link = g.adjList_H[n]
    g.adjList_H[n] = node


def print_adjList(g):
    p = graphNode()
    for i in range(g.n):
        print("\n\t\t 정점 {}의 인접 리스트".format(chr(i + 65)), end="")
        p = g.adjList_H[i]
        while(p):
            print(" -> {}".format(chr(p.vertex + 65)), end="")
            p = p.link

def is_LQ_empty(LQ):
    if(LQ.front == None):
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
    if(is_LQ_empty(LQ)):
        return 0 
    
    item = old.data
    LQ.front = LQ.front.link
    if(LQ.front == None):
        LQ.rear = None
    return item

def BFS_adjList(g,v):
    w = graphNode()
    Q = LQueueType()
    
    print(" {}".format(chr(v + 65)),end="")
    enLQueue(Q,v)

    while(not is_LQ_empty(Q)):
        v = deLQueue(Q)
        w = g.adjList_H[v]
        while(w):
            if(not g.visited[w.vertex]):
                g.visited[w.vertex] = True
                print(" {}".format(chr(w.vertex + 65)),end="")
                enLQueue(Q, w.vertex)
            w = w.link
    

G9 = graphType()
for i in range(7):
    insert_vertex(G9, i)

insertEdge(G9,0,2)
insertEdge(G9,0,1)
insertEdge(G9,1,4)
insertEdge(G9,1,3)
insertEdge(G9,1,0)
insertEdge(G9,2,4)
insertEdge(G9,2,0)
insertEdge(G9,3,6)
insertEdge(G9,3,1)
insertEdge(G9,4,6)
insertEdge(G9,4,2)
insertEdge(G9,4,1)
insertEdge(G9,5,6)
insertEdge(G9,6,5)
insertEdge(G9,6,4)
insertEdge(G9,6,3)

print("\n G9의 인접 리스트", end="")
print_adjList(G9)

print("\n\n ////////////////////////// \n\n 너비 우선 탐색 >>", end="")
BFS_adjList(G9,0)
