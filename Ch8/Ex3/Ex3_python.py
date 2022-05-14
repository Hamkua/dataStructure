
MAX_VERTEX = 30

class stackNode:
    def __init__(self):
        self.data = None
        self.link = None

class graphNode:
    def __init__(self):
        self.vertex = None
        self.link = None
    
class graphType:
    def __init__(self):
        self.n = 0
        self.adjList_H = [None]*MAX_VERTEX
        self.visited = [False]*MAX_VERTEX

top = stackNode()

def is_stack_empty():
    if(top == None):
        return 1
    return 0

def push(item):
    global top
    temp = stackNode()
    temp.data = item
    temp.link = top
    top = temp

def pop():
    global top
    temp = top
    
    if(is_stack_empty()):
        print("\n\n Stack is empty!")
        return 0
    item = temp.data
    top = temp.link 
    return item

def peek():
    if(is_stack_empty()):
        print("\n\n Stack is empty!")
        return 0

    return top.data

def print_stack():
    p = top
    print("\n STACK [",end="")
    while(p):
        print("{} ".format(p.data))
        p = p.link

    print("] ")


def insertVertex(g,v):
    if(((g.n)+1)>MAX_VERTEX):
        print("\n그래프 정점의 개수를 초과하였습니다!",end="")
        return
    g.n += 1

def insertEdge(g,n,v):
    node = graphNode()
    if(n >= g.n or v >= g.n):
        print("\n 그래프에 없는 정점입니다!",end="")
        return

    node.vertex = v
    node.link = g.adjList_H[n]
    g.adjList_H[n] = node

def print_adjList(g):
    p = graphNode()
    for i in range(g.n):
        print("\n\t\t정점 {}의 인접 리스트".format(chr(i + 65)), end="")
        p = g.adjList_H[i]
        while(p):
            print(" -> {}".format(chr(p.vertex + 65)),end="")
            p = p.link
    
def DFS_adjList(g,v):
    global top
    w = graphNode()
    top = None
    push(v)
    g.visited[v] = True
    print(" {}".format(chr(v + 65)), end="")
    
    while(not is_stack_empty()):
        w = g.adjList_H[v]
        while(w):
            if(not g.visited[w.vertex]):
                push(w.vertex)
                g.visited[w.vertex] = True
                print(" {}".format(chr(w.vertex + 65)), end="")
                v = w.vertex 
                w = g.adjList_H[v] 
            else:
                w = w.link
        v = pop()




G9 = graphType()
for i in range(7):
    insertVertex(G9, i)

insertEdge(G9, 0, 2)
insertEdge(G9, 0, 1)
insertEdge(G9, 1, 4)
insertEdge(G9, 1, 3)
insertEdge(G9, 1, 0)
insertEdge(G9, 2, 4)
insertEdge(G9, 2, 0)
insertEdge(G9, 3, 6)
insertEdge(G9, 3, 1)
insertEdge(G9, 4, 6)
insertEdge(G9, 4, 2)
insertEdge(G9, 4, 1)
insertEdge(G9, 5, 6)
insertEdge(G9, 6, 5)
insertEdge(G9, 6, 4)
insertEdge(G9, 6, 3)

print("\n G9의 인접 리스트",end="")
print_adjList(G9)

print("\n\n ////////////////////////// \n\n 깊이 우선 탐색 >>",end="")
DFS_adjList(G9,0)
