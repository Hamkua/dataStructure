#include<stdio.h>
#include<stdlib.h>
#define MAX_VERTEX 30
#define FALSE 0
#define TRUE 1


typedef char element;

typedef struct QNode{
    element data;
    struct QNode* link;
}QNode;

typedef struct LQueueType{
    QNode* front, *rear;
}LQueueType;

typedef struct stackNode{
    element data;
    struct stackNode* link;
} stackNode;


stackNode* top;

typedef struct graphNode{
    int vertex;
    struct graphNode* link;
} graphNode;

typedef struct graphType{
    int n;
    graphNode* adjList_H[MAX_VERTEX];
    int visited[MAX_VERTEX];
} graphType;



void createGraph(graphType* g);
void insertVertex(graphType* g, int v);
void insertEdge(graphType* g, int n, int v);
void print_adjList(graphType* g);


LQueueType* createLinkedQueue(void);
int isLQEmpty(LQueueType* LQ);
void enLQueue(LQueueType* LQ, element item);
element deLQueue(LQueueType* LQ);

void BFS_adjList(graphType* g, int v);


int main(void){
    int i;
    graphType* G9;
    G9 = (graphType*)malloc(sizeof(graphType));
    createGraph(G9);

    for(i=0; i<7; i++){
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

    printf("\n G9의 인접 리스트");
    print_adjList(G9);

    printf("\n\n ////////////////////////// \n\n 너비 우선 탐색 >>");
    BFS_adjList(G9,0);



    getchar(); return 0;
}

void createGraph(graphType* g){
    int v;
    g -> n = 0;
    for(v = 0; v< MAX_VERTEX; v++){
        g -> adjList_H[v] = NULL;
        g -> visited[v] = FALSE;
    }
}

void insertVertex(graphType* g, int v){
    if(((g->n) + 1) > MAX_VERTEX){
        printf("\n 그래프 정점의 개수를 초과하였습니다!");
        return;
    }
    g -> n++;
}

void insertEdge(graphType* g, int n, int v){
    graphNode* node;
    if(n>=g->n || v >= g->n){
        printf("\n 그래프에 없는 정점입니다!");
        return;
    }
    node = (graphNode*)malloc(sizeof(graphNode));
    node -> vertex = v;
    node -> link = g -> adjList_H[n];
    g -> adjList_H[n] = node;
}

void print_adjList(graphType* g){
    int i;
    graphNode* p;
    for(i = 0; i< g->n; i++){
        printf("\n\t\t정점 %c의 인접 리스트", i + 65);
        p = g -> adjList_H[i];
        while(p){
            printf(" -> %c", p -> vertex + 65);
            p = p -> link;
        }
    }
}
LQueueType* createLinkedQueue(void){
    LQueueType* LQ;
    LQ = (LQueueType*)malloc(sizeof(LQueueType));
    LQ -> front = NULL;
    LQ -> rear = NULL;
    return LQ;
}

int isLQEmpty(LQueueType* LQ){
    if(LQ->front == NULL){
        // printf(" Linked Queue is empty!");
        return 1;
    }
    return 0;
}

void enLQueue(LQueueType* LQ, element item){
    QNode* newNode = (QNode*)malloc(sizeof(QNode));
    newNode -> data = item;
    newNode -> link = NULL;

    if(LQ->front == NULL){
        LQ->front = newNode;
        LQ->rear = newNode;
    }
    else{
        LQ->rear->link = newNode;
        LQ->rear = newNode;
    }
}

element deLQueue(LQueueType* LQ){
    QNode* old = LQ->front;
    element item;
    if(isLQEmpty(LQ)){
        return 0;
    }
    item = old -> data;
    LQ -> front = LQ -> front ->link;
    if(LQ->front == NULL){
        LQ->rear = NULL;
    }
    free(old);
    return item;
}


void BFS_adjList(graphType* g, int v){
    graphNode* w;
    LQueueType* Q;
    Q = createLinkedQueue();
    g -> visited[v] = TRUE;
    printf(" %c", v+ 65);
    enLQueue(Q,v);

    while(!isLQEmpty(Q)){
        v = deLQueue(Q);
        for(w = g -> adjList_H[v]; w; w = w -> link){
            if(!g->visited[w -> vertex]){
                g -> visited[w -> vertex] = TRUE;
                printf(" %c", w -> vertex + 65);
                enLQueue(Q, w->vertex);
            }
        }
    }
}