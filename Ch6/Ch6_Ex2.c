#include<stdio.h>
#include<stdlib.h>

#define cQ_SIZE 4


typedef char element;

typedef struct {
    element queue[cQ_SIZE];
    int front, rear;
} QueueType;

QueueType* createCQueue(void);
int isCQueueEmpty(QueueType* cQ);
int isCQueueFull(QueueType* cQ);
void enCQueue(QueueType* cQ, element item);
element deCQueue(QueueType* cQ);
element peekCQ(QueueType* cQ);
void printCQ(QueueType* cQ);


int main(void){
    QueueType* cQ = createCQueue();
    element data;
    printf("\n ***** 원형 큐 연산 ***** \n");
    printf("\n 삽입 A>>"); enCQueue(cQ, 'A'); printCQ(cQ);
    printf("\n 삽입 B>>"); enCQueue(cQ, 'B'); printCQ(cQ);
    printf("\n 삽입 C>>"); enCQueue(cQ, 'C'); printCQ(cQ);
    data = peekCQ(cQ);
    printf(" peek item : %c \n", data);
    printf("\n 삭제 >>"); data = deCQueue(cQ); printCQ(cQ);
    printf("\t 삭제 데이터 : %c", data);
    printf("\n 삭제 >>"); data = deCQueue(cQ); printCQ(cQ);
    printf("\t 삭제 데이터 : %c", data);
    printf("\n 삭제 >>"); data = deCQueue(cQ); printCQ(cQ);
    printf("\t\t 삭제 데이터 : %c", data);

    printf("\n 삽입 D>>"); enCQueue(cQ, 'D'); printCQ(cQ);
    printf("\n 삽입 E>>"); enCQueue(cQ, 'E'); printCQ(cQ);
    getchar(); return 0;
}

QueueType* createCQueue(void){
    QueueType* cQ;
    cQ = (QueueType*)malloc(sizeof(QueueType));
    cQ ->front = 0;
    cQ ->rear = 0;
    return cQ;
}

int isCQueueEmpty(QueueType* cQ){
    if(cQ -> front == cQ -> rear){
        printf(" Circular Queue is empty! ");
        return 1;
    }
    return 0;
}

int isCQueueFull(QueueType* cQ){
    if(((cQ -> rear +1 ) % cQ_SIZE) == cQ->front){
        printf(" Circular Queue is Full!");
        return 1;
    }
    return 0;
}

void enCQueue(QueueType* cQ, element item){
    if(isCQueueFull(cQ)){
        return;
    }
    cQ -> rear = (cQ->rear +1) % cQ_SIZE;
    cQ -> queue[cQ->rear] = item;
}

element deCQueue(QueueType* cQ){
    if(isCQueueEmpty(cQ)){
        return 0;
    }
    cQ -> front = (cQ->front + 1) % cQ_SIZE;
    return cQ -> queue[cQ -> front];
}

element peekCQ(QueueType* cQ){
    if(isCQueueEmpty(cQ)){
        return 0;
    }
    return cQ->queue[(cQ->front + 1) % cQ_SIZE];
}

void printCQ(QueueType* cQ){
    int i, first, last;
    first = (cQ -> front + 1) % cQ_SIZE;
    last = (cQ -> rear + 1) % cQ_SIZE;
    printf(" Circular Queue : [");
    i = first;
    while(i!=last){
        printf("%3c", cQ->queue[i]);
        i = (i + 1) % cQ_SIZE;
    }
    printf(" ] ");
}
