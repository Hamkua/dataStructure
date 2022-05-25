#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef char element;

typedef struct stackNode{
    element data;
    struct stackNode* link;
} stackNode;

stackNode* top;

int isStackEmpty(void);
void push(element item);
element pop(void);
element peek(void);
void printStack(void);

element evalPostfix(char* exp);

int main(void){
    int result;
    char* express = "35*62/-";
    printf("후위 표기 : %s", express);

    result = evalPostfix(express);
    printf("\n\n연산 결과 -> %d\n", result);
    getchar(); return 0;
}

element evalPostfix(char* exp){
    int opr1, opr2, value, i =0;
    int length = strlen(exp);
    char symbol;

    top = NULL;

    for(i=0;i<length; i++){
        symbol = exp[i];
        if(symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/'){
            value = symbol - '0';
            push(value);
        }
        else{
            opr2 = pop();
            opr1 = pop();

            switch(symbol){
                case '+': push(opr1 + opr2); break;
                case '-': push(opr1 - opr2); break;
                case '*': push(opr1 * opr2); break;
                case '/': push(opr1 / opr2); break;
            }
        }
    }
    return pop();
}

int isStackEmpty(void){
    if(top == NULL){
        return 1;
    }
    return 0;
}
void push(element item){
    stackNode* temp = (stackNode*)malloc(sizeof(stackNode));

    temp -> data = item;
    temp -> link = top;
    top = temp;
}

element pop(void){
    element item;
    stackNode* temp = top;

    if(isStackEmpty()){
        printf("\n\n Stack is empty! \n");
        return 0;
    }
    item = temp -> data;
    top = temp -> link;
    free(temp);
    return item;
}

element peek(void){
    if(isStackEmpty()){
        printf("\n\n Staack is empty! \n");
        return 0;
    }
    return (top->data);
}

void printStack(void){
    stackNode* p = top;
    printf("\n STACK [ ");
    while(p){
        printf("%d ",p->data);
        p = p -> link;
    }
    printf("] ");

}