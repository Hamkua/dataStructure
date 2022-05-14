package dataStructure.ch8;

public class Ex5 {
    static final int TRUE = 1;
    static final int FALSE = 0;
    static final int INF = 10000;
    static final int MAX_VERTICES = 5;

    static int[] distance = new int[MAX_VERTICES];
    static int[] S = new int[MAX_VERTICES];

    static int[][] weight = {
            {0,10,5,INF,INF},
            {INF,0,2,1,INF},
            {INF,3,0,9,2},
            {INF, INF, INF, 0, 4},
            {7, INF, INF, 6, 0}
    };

    public static void main(String[] args) {

        System.out.printf("\n ************가중치 인접 행렬*************\n\n");
        for(int i = 0; i<MAX_VERTICES; i++){
            for(int j =0; j<MAX_VERTICES; j++){
                if(weight[i][j] == INF){
                    System.out.printf("   *");
                }
                else{
                    System.out.printf("   " + weight[i][j]);
                }
            }
            System.out.printf("\n\n");
        }


        System.out.printf("\n *********** 다익스트라 최단 경로 구하기 ************\n");
        Dijkstra_shortestPath(0, MAX_VERTICES);
    }

    static int nextVertex(int n){
        int i, min, minPos;
        min = INF;
        minPos = -1;
        for(i = 0; i<n; i++){
            if((distance[i]<min)&& S[i] == FALSE){
                min = distance[i];
                minPos = i;
            }
        }
        return minPos;
    }

    static int printStep(int step){
        int i;
        System.out.printf("\n   " + step + " 단계 : S ={");
        for(i = 0; i<MAX_VERTICES; i++){
            if(S[i] == TRUE){
                System.out.print("  " + (char)(i + 65));
            }
        }

        if(step < 1){
            System.out.printf("} \t\t\t");
        }
        else if(step < 4){
            System.out.printf("} \t\t");
        }
        else{
            System.out.printf("} \t");
        }
        System.out.printf(" distance : [ ");
        for(i = 0; i<MAX_VERTICES; i++){
            if(distance[i] == INF){
                System.out.printf("   *");
            }
            else{
                System.out.printf("   " + distance[i]);
            }

        }
        System.out.printf("   ]");
        return ++step;
    }


    static void Dijkstra_shortestPath(int start, int n){
        int i, u, w, step = 0;
        for(i=0; i<n; i++){
            distance[i] = weight[start][i];
            S[i] = FALSE;
        }
        S[start] = TRUE;
        distance[start] = 0;

        step = printStep(0);

        for(i=0;i<n-1; i++){
            u = nextVertex(n);
            S[u] = TRUE;
            for(w =0; w<n; w++){
                if(S[w] == FALSE){
                    if(distance[u] + weight[u][w] < distance[w]){
                        distance[w] = distance[u] + weight[u][w];
                    }
                }
            }
            step = printStep(step);
        }
    }

}
