MAX_VERTICES = 5
INF = 10000

A = [[None]*MAX_VERTICES for _ in range(MAX_VERTICES)]
weight = [
        [0,10,5,INF,INF],
        [INF,0,2,1,INF],
        [INF,3,0,9,2],
        [INF, INF, INF, 0, 4],
        [7, INF, INF, 6, 0]
]

def print_step(step):
    print("\n A{} : ".format(step),end="")
    for i in range(MAX_VERTICES):
        print("\t",end="")
        for j in range(MAX_VERTICES):
            if(A[i][j] == INF):
                print("   *", end="")
            
            else:
                print("   {}".format(A[i][j]), end="")
        print("\n")


def Floyd_shortestPath(n):
    step = -1
    for v in range(n):
        for w in range(n):
            A[v][w] = weight[v][w]

    print_step(step)

    for k in range(n):
        for v in range(n):
            for w in range(n):
                if((A[v][k] + A[k][w]) < A[v][w]):
                    A[v][w] = A[v][k] + A[k][w]
        step += 1
        print_step(step)

print("\n************ 가중치 인접 행렬 ***********\n\n",end="")
for i in range(MAX_VERTICES):
    for j in range(MAX_VERTICES):
        if(weight[i][j] == INF):
            print("   *",end="")
        
        else:
            print("   {}".format(weight[i][j]),end="")
        
    print("\n")


print("\n************ 플루이드 최단 경로 구하기 ***********\n")
Floyd_shortestPath(MAX_VERTICES)