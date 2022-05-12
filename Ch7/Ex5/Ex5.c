#include<stdio.h>
#include<stdlib.h>
#define MAX(a,b) ((a>b)?a:b)

typedef int element;

typedef struct treeNode {
    element key;
    struct treeNode* left;
    struct treeNode* right;
} treeNode;

void displayInorder(treeNode* root);
treeNode* searchBST(treeNode* p, element x);
treeNode* insertBSTNode(treeNode* root, element key);
void deleteBSTNode(treeNode* root, element key);

treeNode* LL_rotate(treeNode* parent);
treeNode* RR_rotate(treeNode* parent);
treeNode* LR_rotate(treeNode* parent);
treeNode* RL_rotate(treeNode* parent);

int getHeight(treeNode* p);
int getBF(treeNode* p);
treeNode* rebalance(treeNode** p);
treeNode* insertAVLNode(treeNode** root, element x);


int main(void){
    treeNode* root_AVL = NULL;
    treeNode* root_BST = NULL;

    root_AVL = insertAVLNode(&root_AVL, 50);
    insertAVLNode(&root_AVL, 60);
    insertAVLNode(&root_AVL, 70);
    insertAVLNode(&root_AVL, 90);
    insertAVLNode(&root_AVL, 80);
    insertAVLNode(&root_AVL, 75);
    insertAVLNode(&root_AVL, 73);
    insertAVLNode(&root_AVL, 72);
    insertAVLNode(&root_AVL, 78);

    printf("\n ********** AVL 트리 출력 ****************** \n\n");
    displayInorder(root_AVL);

    printf("\n\n AVL 트리에서 70 탐색 : ");
    searchBST(root_AVL, 70);

    printf("\n\n AVL 트리에서 72 탐색 : ");
    searchBST(root_AVL, 72);

    printf("\n\n AVL 트리에서 76 탐색 : ");
    searchBST(root_AVL, 76);




    root_BST = insertBSTNode(root_BST, 50);
    insertBSTNode(root_BST, 60);
    insertBSTNode(root_BST, 70);
    insertBSTNode(root_BST, 90);
    insertBSTNode(root_BST, 80);
    insertBSTNode(root_BST, 75);
    insertBSTNode(root_BST, 73);
    insertBSTNode(root_BST, 72);
    insertBSTNode(root_BST, 78);

    printf("\n ********** BST 출력 ****************** \n\n");
    printf("\n\n BST 트리에서 70 탐색 : ");
    searchBST(root_BST, 70);

    printf("\n\n BST 트리에서 72 탐색 : ");
    searchBST(root_BST, 72);

    printf("\n\n BST 트리에서 76 탐색 : ");
    searchBST(root_BST, 76);

    getchar(); return 0;
}


void displayInorder(treeNode* root){
    if(root){
        displayInorder(root -> left);
        printf("%d_", root -> key);
        displayInorder(root -> right);
    }
}

treeNode* searchBST(treeNode* root, element x){
    treeNode* p;
    int count = 0;
    p = root;
    while(p!=NULL){
        count++;
        if(x < p -> key){
            p = p -> left;
        }
        else if(x == p -> key){
            printf("%3d번째에 탐색 성공", count);
            return p;
        }
        else{
            p = p -> right;
        }
    }
    count++;
    printf("%3d번째에 탐색 실패! 찾는 키가 없습니다!", count);
    return p;
}

treeNode* insertBSTNode(treeNode* p, element x){
    treeNode* newNode;
    if(p == NULL){
        newNode = (treeNode*)malloc(sizeof(treeNode));
        newNode -> key = x;
        newNode -> left = NULL;
        newNode -> right = NULL;
        return newNode;
    }
    else if(x < p ->key){
        p -> left = insertBSTNode(p->left, x);
    }
    else if(x > p ->key){
        p -> right = insertBSTNode(p->right, x);
    }
    else{
        printf("이미 같은 키가 있습니다!");
    }
    return p;
}


treeNode* LL_rotate(treeNode* parent){
    treeNode* child = parent -> left;
    parent -> left = child -> right;
    child -> right = parent;
    return child;
}

treeNode* RR_rotate(treeNode* parent){
    treeNode* child = parent -> right;
    parent -> right = child -> left;
    child -> left = parent;
    return child;
}

treeNode* LR_rotate(treeNode* parent){
    treeNode* child = parent -> left;
    parent -> left = RR_rotate(child);
    return LL_rotate(parent);
}

treeNode* RL_rotate(treeNode* parent){
    treeNode* child = parent -> right;
    parent -> right = LL_rotate(child);
    return RR_rotate(parent);
}

// 서브 트리의 높이를 구하는 연산
int getHeight(treeNode* p){
    int height =0;
    if(p != NULL){
        height = MAX(getHeight(p->left), getHeight(p->right)) + 1;
    }
    return height;
}

//서브 트리의 높이를 이용, 균형 인수 BF를 구하는 함수
int getBF(treeNode* p){
    if(p == NULL){
        return 0;
    }
    return getHeight(p -> left) - getHeight(p -> right);
}

treeNode* rebalance(treeNode** p){
    int BF = getBF(*p);
    if(BF > 1){
        if(getBF((*p) -> left) > 0){
            *p = LL_rotate(*p);
        }
        else{
            *p = LR_rotate(*p);
        }
    }
    else if(BF < -1){
        if(getBF((*p) -> right) < 0){
            *p = RR_rotate(*p);
        }
        else{
            *p = RL_rotate(*p);
        }
    }
    return *p;
}

//AVL트리에 노드를 삽입하는 연산: 이진 탐색 연산처럼 삽입한 후에, rebalance() 호출
treeNode* insertAVLNode(treeNode** root, element x){
    if(*root == NULL){
        *root = (treeNode*)malloc(sizeof(treeNode));
        (*root) -> key = x;
        (*root) -> left = NULL;
        (*root) -> right = NULL;
    }
    else if(x < (*root)->key){
        (*root) -> left = insertAVLNode(&((*root)->left),x);
        *root = rebalance(root);
    }
    else if(x > (*root)->key){
        (*root) -> right = insertAVLNode(&((*root)->right),x);
        *root = rebalance(root);
    }
    else{
        printf("\n 이미 같은 키가 있습니다! \n");
        return 0;
    }
    return *root;
}
