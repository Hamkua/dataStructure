MAX_VERTEX = 30

class graphNode:
    def __init__(self):
        self.vertex = 0
        self.link = None
    
class graphType:
    def __init__(self):
        self.n = 0
        self.adjList_H = [None]*MAX_VERTEX


def insertVertex(g,v):
    if(((g.n) + 1) > MAX_VERTEX):
        print("\n 그래프 정점의 개수를 초과하였습니다!", end="")
        return
    
    g.n += 1

def insertEdge(g,u,v):
    node = graphNode()
    if(u >= g.n or v >= g.n):
        print("\n그래프에 없는 정점입니다!", end="")
        return
    
    node.vertex = v
    node.link = g.adjList_H[u]
    g.adjList_H[u] = node

def print_adjList(g):
    p = graphNode()
    for i in range(g.n):
        print("\n\t\t정점 {}의 인접 리스트".format(i+65),end="")
        p = g.adjList_H[i]
        while(p):
            print(" -> {}".format(chr(p.vertex + 65)), end="")
            p = p.link


G1 = graphType()
G2 = graphType()
G3 = graphType()
G4 = graphType()


for i in range(4):
    insertVertex(G1, i)

insertEdge(G1, 0, 3)
insertEdge(G1, 0, 1)
insertEdge(G1, 1, 3)
insertEdge(G1, 1, 2)
insertEdge(G1, 1, 0)
insertEdge(G1, 2, 3)
insertEdge(G1, 2, 1)
insertEdge(G1, 3, 2)
insertEdge(G1, 3, 1)
insertEdge(G1, 3, 0)

for i in range(3):
    insertVertex(G2, i)

insertEdge(G2, 0, 2)
insertEdge(G2, 0, 1)
insertEdge(G2, 1, 2)
insertEdge(G2, 1, 0)
insertEdge(G2, 2, 1)
insertEdge(G2, 2, 0)

for i in range(4):
    insertVertex(G3, i)

insertEdge(G3, 0, 3)
insertEdge(G3, 0, 1)
insertEdge(G3, 1, 3)
insertEdge(G3, 1, 2)
insertEdge(G3, 2, 3)

for i in range(3):
    insertVertex(G4, i)

insertEdge(G4, 0, 2)
insertEdge(G4, 0, 1)
insertEdge(G4, 1, 2)
insertEdge(G4, 1, 0)

print("\n G1의 인접리스트",end="")
print_adjList(G1)

print("\n\n G2의 인접 리스트",end="")
print_adjList(G2)

print("\n\n G3의 인접 리스트",end="")
print_adjList(G3)

print("\n\n G4의 인접 리스트",end="")
print_adjList(G4)