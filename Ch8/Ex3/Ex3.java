package dataStructure.ch8;

public class Ex3 {

    static int MAX_VERTEX = 30;
    static StackNode top = new StackNode();
    public static void main(String[] args) {
        GraphType G9 = new GraphType();


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

        System.out.print("\n G9의 인접 리스트");
        print_adjList(G9);

        System.out.print("\n\n ////////////////////////// \n\n 깊이 우선 탐색 >>");
        DFS_adjList(G9,0);
    }


    static class StackNode{
        private int data;
        private StackNode link;

        public StackNode() {
        }
    }

    static class GraphType{
        private int n;
        public GraphNode[] adjList_H;
        public boolean[] visited;

        public GraphType(){
            n = 0;
            adjList_H = new GraphNode[MAX_VERTEX];
            visited = new boolean[MAX_VERTEX];
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


    static boolean isStackEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

    static void push(int item){
        StackNode temp = new StackNode();

        temp.data = item;
        temp.link = top;
        top = temp;
    }

    static int pop(){
        int item;
        StackNode temp = top;

        if(isStackEmpty()){
            System.out.print("\n\n Stack is empty! \n");
            return 0;
        }
        item = temp.data;
        top = temp.link;
        return item;
    }

    static int peek(){
        if(isStackEmpty()){
            System.out.print("\n\n Stack is empty! \n");
            return 0;
        }
        return (top.data);

    }

    static void printStack(){
        StackNode p = top;
        System.out.print("\n STACK [ ");
        while(p!= null){
            System.out.print(p.data + " ");
            p = p.link;
        }
        System.out.print("] ");

    }

    static void DFS_adjList(GraphType g, int v){
        GraphNode w = new GraphNode(0,null);
        top = null;
        push(v);
        g.visited[v] = true;
        System.out.print(" " +  (char)(v+ 65));

        while(!isStackEmpty()){
            w = g.adjList_H[v];
            while(w != null){
                if(!g.visited[w.vertex]){
                    push(w.vertex);
                    g.visited[w.vertex] = true;
                    System.out.print(" " + (char)(w.vertex + 65));
                    v = w.vertex;
                    w = g.adjList_H[v];
                }
                else w = w.link;
            }
            v = pop();
        }
    }

}
