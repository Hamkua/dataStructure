package dataStructure.ch8;

public class Ex2 {
    static int MAX_VERTEX = 30;


    public static void main(String[] args) {
        GraphType G1 = new GraphType();
        GraphType G2 = new GraphType();
        GraphType G3 = new GraphType();
        GraphType G4 = new GraphType();

        for(int i = 0; i<4; i++){
            insertVertex(G1, i);
        }
        insertEdge(G1, 0, 3);
        insertEdge(G1, 0, 1);
        insertEdge(G1, 1, 3);
        insertEdge(G1, 1, 2);
        insertEdge(G1, 1, 0);
        insertEdge(G1, 2, 3);
        insertEdge(G1, 2, 1);
        insertEdge(G1, 3, 2);
        insertEdge(G1, 3, 1);
        insertEdge(G1, 3, 0);


        for(int i = 0; i<3; i++){
            insertVertex(G2, i);
        }
        insertEdge(G2, 0, 2);
        insertEdge(G2, 0, 1);
        insertEdge(G2, 1, 2);
        insertEdge(G2, 1, 0);
        insertEdge(G2, 2, 1);
        insertEdge(G2, 2, 0);


        for(int i = 0; i<4; i++){
            insertVertex(G3, i);
        }
        insertEdge(G3, 0, 3);
        insertEdge(G3, 0, 1);
        insertEdge(G3, 1, 3);
        insertEdge(G3, 1, 2);
        insertEdge(G3, 2, 3);


        for(int i = 0; i<3; i++){
            insertVertex(G4, i);
        }
        insertEdge(G4, 0, 2);
        insertEdge(G4, 0, 1);
        insertEdge(G4, 1, 2);
        insertEdge(G4, 1, 0);


        System.out.print("\n G1의 인접리스트");
        print_adjList(G1);

        System.out.print("\n\n G2의 인접 리스트");
        print_adjList(G2);

        System.out.print("\n\n G3의 인접 리스트");
        print_adjList(G3);

        System.out.print("\n\n G4의 인접 리스트");
        print_adjList(G4);


    }


    static class GraphType{
        private int n;
        public GraphNode[] adjList_H;

        public GraphType(){
            n = 0;
            adjList_H = new GraphNode[MAX_VERTEX];
        }
    }

    static class GraphNode{
        private int vertex;
        private GraphNode link;

        public GraphNode(int vertex, GraphNode link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    static void insertVertex(GraphType g, int v){
        if(((g.n) + 1) > MAX_VERTEX){
            System.out.print("\n 그래프 정점의 개수를 초과하였습니다!");
            return;
        }

        if(v < (g.n)){
            return;
        }

        g.n += 1;
    }

    static void insertEdge(GraphType g, int u, int v){
        if(u >= g.n || v >= g.n){
            System.out.print("\n 그래프에 없는 정점입니다!");
            return;
        }
        GraphNode node = new GraphNode(v, g.adjList_H[u]);
        g.adjList_H[u] = node;
    }

    static void print_adjList(GraphType g){
        GraphNode p;
        for(int i = 0; i< g.n; i++){
            System.out.print("\n\t\t정점 " + (char)(i + 65) + "의 인접 리스트");
            p = g.adjList_H[i];
            while(p != null){
                System.out.print(" -> " + (char)(p.vertex + 65));
                p = p.link;
            }
        }
    }

}
