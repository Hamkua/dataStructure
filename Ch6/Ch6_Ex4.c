#include<stdio.h>
#include<stdlib.h>

typedef char element;

typedef struct DQNode {
    element data;
    struct DQNode* llink;
    struct DQNode* rlink;

} DQNode;

typedef struct{
    DQNode* front,* rear;
} DQueType;

DQueType* createDQue(void);
int isDeQEmpty(DQueType* DQ);
void insertFront(DQueType* DQ, element item);
void insertRear(DQueType* DQ, element item);
element deleteFront(DQueType* DQ);
element deleteRear(DQueType* DQ);
element peekFront(DQueType* DQ);
element peekRear(DQueType* DQ);
void printDQ(DQueType* DQ);

int main(void){
    DQueType* DQ1 = createDQue();
    element data;
    printf("\n ***** 데크 연산 *****\n");
    printf("\n front 삽입 A>> "); insertFront(DQ1, 'A'); printDQ(DQ1);
    printf("\n front 삽입 B>> "); insertFront(DQ1, 'B'); printDQ(DQ1);
    printf("\n rear 삽입 C>> "); insertRear(DQ1, 'C'); printDQ(DQ1);

    printf("\n front 삭제 >> "); data = deleteFront(DQ1); printDQ(DQ1);
    printf("\t 삭제 데이터: %c", data);

    printf("\n rear 삭제 >> "); data = deleteRear(DQ1); printDQ(DQ1);
    printf("\t 삭제 데이터: %c", data);


    printf("\n rear 삽입 D >> "); insertRear(DQ1, 'D'); printDQ(DQ1);
    printf("\n front 삽입 E >> "); insertFront(DQ1, 'E'); printDQ(DQ1);
    printf("\n front 삽입 F >> "); insertFront(DQ1, 'F'); printDQ(DQ1);

    data = peekFront(DQ1); printf("\n peek Front item : %c \n", data);
    data = peekRear(DQ1); printf(" peek Rear item : %c \n", data);


    getchar(); return 0;
}


DQueType* createDQue(void){
    DQueType* DQ;
    DQ = (DQueType*)malloc(sizeof(DQueType));
    DQ ->front = NULL;
    DQ ->rear = NULL;
    return DQ;
}

int isDeQEmpty(DQueType* DQ){
    if(DQ->front == NULL){
        return 1;
    }
    return 0;
}

void insertFront(DQueType* DQ, element item){
    DQNode* newNode = (DQNode*)malloc(sizeof(DQNode));
    newNode -> data = item;

    if(isDeQEmpty(DQ)){
        DQ->front = newNode;
        DQ->rear = newNode;
        newNode -> rlink = NULL;
        newNode -> llink = NULL;
    }
    else{
        DQ -> front -> llink = newNode;
        newNode -> rlink = DQ -> front;
        newNode -> llink = NULL;
        DQ -> front = newNode;
    }
}

void insertRear(DQueType* DQ, element item){
    DQNode* newNode = (DQNode*)malloc(sizeof(DQNode));
    newNode -> data = item;
    if(isDeQEmpty(DQ)){
        DQ -> front = newNode;
        DQ -> rear = newNode;
        newNode -> rlink = NULL;
        newNode -> llink = NULL;
    }
    else{
        DQ -> rear -> rlink = newNode;
        newNode -> llink = DQ -> rear;
        newNode -> rlink = NULL;
        DQ -> rear = newNode;
    }
}

element deleteFront(DQueType* DQ){
    DQNode* old = DQ -> front;
    element item;
    if(isDeQEmpty(DQ)){
        printf("\n Linked deQue is empty! \n"); return 0;
    }
    else{
        item = old -> data;
        if(DQ -> front -> rlink == NULL){
            DQ -> front = NULL;
            DQ -> rear = NULL;
        }
        else{
            DQ -> front = DQ -> front -> rlink;
            DQ -> front -> llink = NULL;
        }
        free(old);
        return item;
    }
}

element deleteRear(DQueType* DQ){
    DQNode* old = DQ -> rear;
    element item;
    if(isDeQEmpty(DQ)){
        printf("\n Linked deQue is empty! \n"); return 0;
    }
    else{
        item = old -> data;
        if(DQ -> rear -> llink == NULL){
            DQ -> front = NULL;
            DQ -> rear = NULL;
        }
        else{
            DQ -> rear = DQ -> rear -> llink;
            DQ -> rear -> rlink = NULL;
        }
        free(old);
        return item;
    }
}

element peekFront(DQueType* DQ){
    element item;
    if(isDeQEmpty(DQ)){
        printf("\n Linked deQue is empty! \n"); return 0;
    }
    else{
        item = DQ -> front -> data;
        return item;
    }
}

element peekRear(DQueType* DQ){
    element item;
    if(isDeQEmpty(DQ)){
        printf("\n Linked deQue is empty! \n"); return 0;
    }
    else{
        item = DQ -> rear -> data;
        return item;
    }
}

void printDQ(DQueType* DQ){
    DQNode* temp = DQ -> front;
    printf("DeQue : [");
    while(temp){
        printf("%3c", temp -> data);
        temp = temp -> rlink;
    }
    printf(" ] ");
}

