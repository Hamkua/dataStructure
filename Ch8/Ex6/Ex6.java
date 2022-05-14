package dataStructure.ch8;

public class Ex6 {
    static final int INF = 10000;
    static final int MAX_VERTICES = 5;

    static int[][] A = new int[MAX_VERTICES][MAX_VERTICES];
    static int[][] weight = {
            {0,10,5,INF,INF},
            {INF,0,2,1,INF},
            {INF,3,0,9,2},
            {INF, INF, INF, 0, 4},
            {7, INF, INF, 6, 0}
    };

    public static void main(String[] args) {
        System.out.printf("\n************ 가중치 인접 행렬 ***********\n\n");
        for(int i=0; i<MAX_VERTICES; i++){
            for(int j=0; j<MAX_VERTICES; j++){
                if(weight[i][j] == INF){
                    System.out.printf("   *");
                }
                else{
                    System.out.printf("   " + weight[i][j]);
                }
            }
            System.out.printf("\n\n");
        }

        System.out.printf("\n************ 플루이드 최단 경로 구하기 ***********\n\n");
        Floyd_shortestPath(MAX_VERTICES);
    }

    static void printStep(int step){
        int i,j;
        System.out.printf("\n A" + step + " : ");
        for(i=0; i<MAX_VERTICES; i++){
            System.out.printf("\t");
            for(j =0; j<MAX_VERTICES; j++){
                if(A[i][j] == INF){
                    System.out.printf("   *");
                }
                else{
                    System.out.printf("   " + A[i][j]);
                }
            }
            System.out.printf("\n\n");
        }
    }

    static void Floyd_shortestPath(int n){
        int v, w, k, step = -1;

        for(v=0; v<n; v++){
            for(w=0; w<n; w++){
                A[v][w] = weight[v][w];
            }
        }

        printStep(step);

        for(k=0; k<n; k++){
            for(v=0; v<n; v++){
                for(w=0; w<n; w++){
                    if(A[v][k] + A[k][w] < A[v][w]){
                        A[v][w] = A[v][k] + A[k][w];
                    }
                }
            }
            printStep(++step);
        }
    }
}
