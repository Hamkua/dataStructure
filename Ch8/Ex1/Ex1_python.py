
MAX_VERTEX = 30

class graphType:
    def __init__(self):
        self.n = 0
        self.adjMatrix = [[0]*MAX_VERTEX for _ in range(MAX_VERTEX)]


def insertVertex(g,v):
    if(((g.n) + 1) > MAX_VERTEX):
        print("\n 그래프 정점의 개수를 초과하였습니다!", end="")
        return

    if(v < (g.n)):
        return

    g.n += 1

def insertEdge(g,u,v):
    if(u >= g.n or v >= g.n):
        print("\n 그래프에 없는 정점입니다!",end="")
        return

    g.adjMatrix[u][v] = 1


def print_adjMatrix(g):
    for i in range(g.n):
        print("\n\t\t", end="")
        for j in range(g.n):
            print(" {}".format(g.adjMatrix[i][j]), end="")


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

print("\n G1의 인접 행렬",end="")
print_adjMatrix(G1)

print("\n G2의 인접 행렬",end="")
print_adjMatrix(G2)

print("\n G3의 인접 행렬",end="")
print_adjMatrix(G3)

print("\n G4의 인접 행렬",end="")
print_adjMatrix(G4)