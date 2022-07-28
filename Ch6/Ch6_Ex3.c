#include<stdio.h>
#include<stdlib.h>

typedef char element;
typedef struct QNode{
    element data;
    struct QNode* link;
}QNode;

typedef struct{
    QNode* front;
    QNode* rear;
}LQueueType;

LQueueType* createLinkedQueue(void);
int isLQEmpty(LQueueType* LQ);
void enLQueue(LQueueType* LQ, element item);
element deLQueue(LQueueType* LQ);
element peekLQ(LQueueType* LQ);
void printLQ(LQueueType* LQ);

int main(void){
    LQueueType* LQ = createLinkedQueue();
    element data;
    printf("\n ***** 원형 큐 연산 ***** \n");
    printf("\n 삽입 A>>"); enLQueue(LQ, 'A'); printLQ(LQ);
    printf("\n 삽입 B>>"); enLQueue(LQ, 'B'); printLQ(LQ);
    printf("\n 삽입 C>>"); enLQueue(LQ, 'C'); printLQ(LQ);
    data = peekLQ(LQ);
    printf(" peek item : %c \n", data);
    printf("\n 삭제 >>"); data = deLQueue(LQ); printLQ(LQ);
    printf("\t 삭제 데이터 : %c", data);
    printf("\n 삭제 >>"); data = deLQueue(LQ); printLQ(LQ);
    printf("\t 삭제 데이터 : %c", data);
    printf("\n 삭제 >>"); data = deLQueue(LQ); printLQ(LQ);
    printf("\t\t 삭제 데이터 : %c", data);

    printf("\n 삽입 D>>"); enLQueue(LQ, 'D'); printLQ(LQ);
    printf("\n 삽입 E>>"); enLQueue(LQ, 'E'); printLQ(LQ);
    getchar(); return 0;
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
        printf(" Linked Queue is empty!");
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
        LQ->rear = NULL; //---------------------
    }
    free(old);
    return item;
}

element peekLQ(LQueueType* LQ){
    element item;
    if(isLQEmpty(LQ)){
        return 0;
    }
    item = LQ -> front -> data;
    return item;
}

void printLQ(LQueueType* LQ){
    QNode* temp = LQ->front;
    printf(" Linked Queue : [");
    while(temp){
        printf("%3c", temp->data);
        temp = temp -> link;
    }
    printf(" ] ");

}