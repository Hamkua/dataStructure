MAX_VERTICES = 5
INF = 10000

distance = [None]*MAX_VERTICES
S = [False]*MAX_VERTICES

weight = [
        [0,10,5,INF,INF],
        [INF,0,2,1,INF],
        [INF,3,0,9,2],
        [INF, INF, INF, 0, 4],
        [7, INF, INF, 6, 0]
]

def next_vertex(n):
    min = INF
    minPos = -1
    for i in range(n):
        if((distance[i] < min)and not S[i]):
            min = distance[i]
            minPos = i

    return minPos

def print_step(step):
    print("\n   {}단계 : S = [".format(step), end="")
    for i in range(MAX_VERTICES):
        if(S[i] == True):
            print("  {}".format(chr(i+65)), end="")

    if(step < 1):
        print("] \t\t\t", end="")

    elif(step < 4):
        print("] \t\t", end="")
    
    else:
        print("] \t", end="")

    print(" distance : [ ", end="")
    for i in range(MAX_VERTICES):
        if(distance[i] == INF):
            print("   {}".format("*"), end="")
        else:
            print("   {}".format(distance[i]), end="")
    
    print("   ]",end="")
    step += 1
    return step

def Dijkstra_shortestPath(start, n):
    for i in range(n):
        distance[i] = weight[start][i]
        
    S[start] = True
    distance[start] = 0
    
    step = print_step(0)

    for i in range(n-1):
        u = next_vertex(n)
        S[u] = True
        for w in range(n):
            if(not S[w]):
                if(distance[u] + weight[u][w] < distance[w]):
                    distance[w] = distance[u] + weight[u][w]

        step = print_step(step)


print("\n ************가중치 인접 행렬*************\n\n", end="")
for i in range(MAX_VERTICES):
    for j in range(MAX_VERTICES):
        if(weight[i][j] == INF):
            print("   *", end="")
        
        else:
            print("   {}".format(weight[i][j]), end="")
            
    print("\n\n", end="")



print("\n *********** 다익스트라 최단 경로 구하기 ************\n", end="")
Dijkstra_shortestPath(0, MAX_VERTICES)