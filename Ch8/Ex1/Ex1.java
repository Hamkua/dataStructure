//package dataStructure.ch8;
//
//
//public class Ex1 {
//    static int MAX_VERTEX = 30;
//
//    public static void main(String[] args) {
//        GraphType G1 = new GraphType();
//        GraphType G2 = new GraphType();
//        GraphType G3 = new GraphType();
//        GraphType G4 = new GraphType();
//
//        for(int i = 0; i<4; i++){
//            insertVertex(G1, i);
//        }
//        insertEdge(G1, 0, 3);
//        insertEdge(G1, 0, 1);
//        insertEdge(G1, 1, 3);
//        insertEdge(G1, 1, 2);
//        insertEdge(G1, 1, 0);
//        insertEdge(G1, 2, 3);
//        insertEdge(G1, 2, 1);
//        insertEdge(G1, 3, 2);
//        insertEdge(G1, 3, 1);
//        insertEdge(G1, 3, 0);
//
//
//        for(int i = 0; i<3; i++){
//            insertVertex(G2, i);
//        }
//        insertEdge(G2, 0, 2);
//        insertEdge(G2, 0, 1);
//        insertEdge(G2, 1, 2);
//        insertEdge(G2, 1, 0);
//        insertEdge(G2, 2, 1);
//        insertEdge(G2, 2, 0);
//
//
//        for(int i = 0; i<4; i++){
//            insertVertex(G3, i);
//        }
//        insertEdge(G3, 0, 3);
//        insertEdge(G3, 0, 1);
//        insertEdge(G3, 1, 3);
//        insertEdge(G3, 1, 2);
//        insertEdge(G3, 2, 3);
//
//
//        for(int i = 0; i<3; i++){
//            insertVertex(G4, i);
//        }
//        insertEdge(G4, 0, 2);
//        insertEdge(G4, 0, 1);
//        insertEdge(G4, 1, 2);
//        insertEdge(G4, 1, 0);
//
//        System.out.print("\n G1의 인접 행렬");
//        print_adjMatrix(G1);
//
//        System.out.print("\n G2의 인접 행렬");
//        print_adjMatrix(G2);
//
//        System.out.print("\n G3의 인접 행렬");
//        print_adjMatrix(G3);
//
//        System.out.print("\n G4의 인접 행렬");
//        print_adjMatrix(G4);
//    }
//
//    static class GraphType{
//        private int n;
//        private int[][] adjMatrix;
//
//        public GraphType(){
//            n = 0;
//            adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
//        }
//    }
//
//    static void insertVertex(GraphType g, int v){
//        if(((g.n) + 1) > MAX_VERTEX){
//            System.out.print("\n 그래프 정점의 개수를 초과하였습니다!");
//            return;
//        }
//
//        if(v < (g.n)){
//            return;
//        }
//
//        g.n += 1;
//    }
//
//    static void insertEdge(GraphType g, int u, int v){
//        if( u >= g.n || v >= g.n){
//            System.out.print("\n 그래프에 없는 정점입니다!");
//            return;
//        }
//        g.adjMatrix[u][v] = 1;
//    }
//
//    static void print_adjMatrix(GraphType g){
//        for(int i = 0; i<(g.n); i++){
//            System.out.print("\n\t\t");
//            for(int j = 0; j<g.n; j++){
//                System.out.print(" " + g.adjMatrix[i][j]);
//            }
//        }
//    }
//}
