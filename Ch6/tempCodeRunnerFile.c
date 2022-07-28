#include<stdio.h>
#include<stdlib.h>

typedef char element;
typedef struct{
    element data;
    struct QNode* link;
}QNode;

typedef struct{
    QNode* front, *rear;
}LQueueType;

LQueueType* createLinkedQueue(void);
int isLQEmpty(LQueueType* LQ);
void enLQueue(LQueueType* LQ, element item);
element deLQueue(LQueueType* LQ);
element peekLQ(LQueueType* LQ);
void printLQ(LQueueType* LQ);