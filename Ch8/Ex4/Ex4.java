package dataStructure.ch8;

import com.sun.corba.se.impl.orbutil.graph.Graph;

public class Ex4 {
    static int MAX_VERTEX = 30;

    public static void main(String[] args) {
        GraphType G9 =  new GraphType();

        for(int i=0; i<7; i++){
            insertVertex(G9, i);
        }
        insertEdge(G9,0,2);
        insertEdge(G9,0,1);
        insertEdge(G9,1,4);
        insertEdge(G9,1,3);
        insertEdge(G9,1,0);
        insertEdge(G9,2,4);
        insertEdge(G9,2,0);
        insertEdge(G9,3,6);
        insertEdge(G9,3,1);
        insertEdge(G9,4,6);
        insertEdge(G9,4,2);
        insertEdge(G9,4,1);
        insertEdge(G9,5,6);
        insertEdge(G9,6,5);
        insertEdge(G9,6,4);
        insertEdge(G9,6,3);

        System.out.printf("\n G9의 인접 리스트");
        print_adjList(G9);

        System.out.printf("\n\n ////////////////////////// \n\n 너비 우선 탐색 >>");
        BFS_adjList(G9,0);
    }

    static class QNode{
        private char data;
        public QNode link;

        public QNode(char data, QNode link) {
            this.data = data;
            this.link = link;
        }
    }

    static class LQueueType{
        public QNode front, rear;

        public LQueueType(QNode front, QNode rear) {
            this.front = front;
            this.rear = rear;
        }
    }

    static class GraphNode{
        private int vertex;
        public GraphNode link;

        public GraphNode(int vertex, GraphNode link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    static class GraphType{
        public int n;
        public GraphNode[] adjList_H = new GraphNode[MAX_VERTEX];
        public int[] visited = new int[MAX_VERTEX];

        public GraphType(){
        }

        public GraphType(int n, GraphNode[] adjList_H, int[] visited) {
            this.n = n;
            this.adjList_H = adjList_H;
            this.visited = visited;
        }
    }

    static void insertVertex(GraphType g, int v){
        if(((g.n) + 1) > MAX_VERTEX){
            System.out.printf("\n 그래프 정점의 개수를 초과하였습니다!");
            return;
        }
        g.n++;
    }

    static void insertEdge(GraphType g, int n, int v){

        if(n>=g.n || v >= g.n){
            System.out.printf("\n 그래프에 없는 정점입니다!");
            return;
        }
        GraphNode node = new GraphNode(v, g.adjList_H[n]);
        g.adjList_H[n] = node;
    }

    static void print_adjList(GraphType g){
        int i;
        GraphNode p = new GraphNode(0, null);
        for(i = 0; i< g.n; i++){
            System.out.printf("\n\t\t정점 %c의 인접 리스트", i + 65);
            p = g.adjList_H[i];
            while(p != null){
                System.out.printf(" -> " + (char)(p.vertex + 65));
                p = p.link;
            }
        }
    }



    static int isLQEmpty(LQueueType LQ){
        if(LQ.front == null){
            // printf(" Linked Queue is empty!");
            return 1;
        }
        return 0;
    }

    static void enLQueue(LQueueType LQ, char item){
        QNode newNode = new QNode(item, null);

        if(LQ.front == null){
            LQ.front = newNode;
            LQ.rear = newNode;
        }
        else{
            LQ.rear.link = newNode;
            LQ.rear = newNode;
        }
    }

    static char deLQueue(LQueueType LQ){
        QNode old = LQ.front;
        char item;
        if(isLQEmpty(LQ) == 1){
            return 0;
        }
        item = old.data;
        LQ.front = LQ.front.link;
        if(LQ.front == null){
            LQ.rear = null;
        }
        return item;
    }

    static void BFS_adjList(GraphType g, int v){
        GraphNode w;
        LQueueType Q = new LQueueType(null,null);

        g.visited[v] = 1;
        System.out.printf(" " + (char)(v+ 65));
        enLQueue(Q,(char)v);

        while(isLQEmpty(Q) != 1){
            v = deLQueue(Q);
            w = g.adjList_H[v];
            while(w != null){  //
                if(g.visited[w.vertex] == 0){
                    g.visited[w.vertex] = 1;
                    System.out.printf(" " + (char)(w.vertex + 65));
                    enLQueue(Q, (char)(w.vertex));
                }
                w = w.link;
            }
        }
    }
}
