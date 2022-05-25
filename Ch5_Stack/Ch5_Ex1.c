#include<stdio.h>
#define STACK_SIZE 100

typedef int element;
element stack[STACK_SIZE];

int isStackEmpty(void);
int isStackFull(void);
void push(element item);
element pop(void);
element peek(void);
void printStack(void);

int top = -1;
int main(void){
    element item;
    printf("\n ** 순차 스택 연산 **\n");
    printStack();
    push(1); printStack();
    push(2); printStack();
    push(3); printStack();

    item = peek();
    printStack();
    printf("peek -> %d", item);

    item = pop();
    printStack();
    printf("\t pop -> %d", item);

    item = pop();
    printStack();
    printf("\t pop -> %d", item);

    item = pop();
    printStack();
    printf("\t pop -> %d\n", item);

    getchar(); return 0;
}

int isStackEmpty(void){
    if(top==-1){
        return 1;
    }
    else{
        return 0;
    }
}
int isStackFull(void){
    if(top == STACK_SIZE -1){
        return 1;
    }
    return 0;
}
void push(element item){
    if(isStackFull()){
        printf("\n\n Stack is FULL! \n");
        return;
    }
    stack[++top] = item;
}
element pop(void){
    if(isStackEmpty()){
        printf("\n\n Stack is EMPTY! \n");
        return 0;
    }
    return stack[top--];
}
element peek(void){
    if(isStackEmpty()){
        printf("\n\n Stack is Empty! \n");
        return 0;
    }
    return stack[top];
}
void printStack(void){
    printf("\n STACK [ ");
    for(int i =0; i<=top; i++){
        printf("%d ", stack[i]);

    }
    printf("] ");
}