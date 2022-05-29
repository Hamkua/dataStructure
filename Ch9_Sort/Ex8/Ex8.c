#include<stdio.h>
#include<stdlib.h>

#define RADIX 10
#define DIGIT 2
#define MAX_VERTEX 30
#define FALSE 0
#define TRUE 1


typedef int element;

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

void radixSort(int a[], int n);

int main(void){
    int i, list[8] = {69, 10, 30, 2, 16, 8, 31, 22};
    int size = sizeof(list)/sizeof(list[0]);
    printf("\n정렬할 원소 : ");
    for(i = 0; i<size; i++){
        printf("%3d", list[i]);
    }
    printf("\n <<<<<<<<<<<<< 기수 정렬 수행 >>>>>>>>>>>>>>> \n");
    radixSort(list, size);

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

void radixSort(int a[], int n){
    int i, bucket, d, factor = 1;

    LQueueType* Q[RADIX];
    for(bucket = 0; bucket < RADIX; bucket++){
        Q[bucket] = createLinkedQueue();
    }

    for(d = 0; d<DIGIT; d++){
        for(i = 0; i<n; i++){
            enLQueue(Q[(a[i]/factor) % RADIX], a[i]);
        }
        for(bucket = 0, i = 0; bucket<RADIX; bucket++){
            while(!isLQEmpty(Q[bucket])){
                a[i++] = deLQueue(Q[bucket]);
            }
        }

        printf("\n\n %d 단계 : ", d + 1);
        for(i=0; i<n; i++){
            printf(" %3d", a[i]);
        }
        factor = factor * RADIX;
    }
}