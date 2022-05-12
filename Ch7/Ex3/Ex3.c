#include<stdio.h>
#include<stdlib.h>

typedef struct treeThNode{
    char data;
    struct treeThNode* left;
    struct treeThNode* right;
    int isThreadRight;
} treeThNode;

treeThNode* makeRootThNode(char data, treeThNode* leftNode, treeThNode* rightNode, int isThreadRight);
treeThNode* findThreadSuccessor(treeThNode* p);
void threadInorder(treeThNode* root);

int main(void){
    treeThNode* n7 = makeRootThNode('D', NULL, NULL, 0);
    treeThNode* n6 = makeRootThNode('C',NULL, NULL, 1);
    treeThNode* n5 = makeRootThNode('B', NULL, NULL, 1);
    treeThNode* n4 = makeRootThNode('A', NULL,NULL,1);
    treeThNode* n3 = makeRootThNode('/', n6, n7, 0);
    treeThNode* n2 = makeRootThNode('*', n4, n5, 0);
    treeThNode* n1 = makeRootThNode('-', n2, n3, 0);

    n4 -> right = n2;
    n5 -> right = n1;
    n6 -> right = n3;

    printf("\n 스레드 이진 트리의 중위 순회 : ");
    threadInorder(n1);

    getchar(); return 0;
}

treeThNode* makeRootThNode(char data, treeThNode* leftNode, treeThNode* rightNode, int isThreadRight){
    treeThNode* root = (treeThNode*)malloc(sizeof(treeThNode));
    root -> data = data;
    root -> left = leftNode;
    root -> right = rightNode;
    root -> isThreadRight = isThreadRight;
    return root;
}

treeThNode* findThreadSuccessor(treeThNode* p){
    treeThNode* q = p -> right;
    if(q == NULL){
        return q;
    }
    if(p -> isThreadRight == 1){
        return q;
    }
    while(q->left != NULL){
        q = q -> left;
    }
    return q;
}

void threadInorder(treeThNode* root){
    treeThNode* q;
    q = root;
    while(q -> left){
        q = q -> left;
    }
    do{
        printf("%3c", q -> data);
        q = findThreadSuccessor(q);
    }while(q);
}
