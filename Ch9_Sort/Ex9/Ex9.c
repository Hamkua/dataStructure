#include<stdio.h>
#include<stdlib.h>

typedef int element;

typedef struct treeNode {
    element key;
    struct treeNode* left;
    struct treeNode* right;
} treeNode;

treeNode* searchBST(treeNode* root, element x);
treeNode* insertBSTNode(treeNode* p, element x);
void deleteBSTNode(treeNode* root, element key);
void displayInorder(treeNode* root);
void treeSort(int a[], int n);

int main(void){
    int i, list[8] = {69, 10, 30, 2, 16, 8, 31, 22};
    int size = sizeof(list)/sizeof(list[0]);
    printf("\n 정렬할 원소 >> ");
    for(i = 0; i<size; i++){
        printf("%3d", list[i]);
    }
    printf("\n\n <<<<<<<<<< 트리 정렬 수행 >>>>>>>>>>\n");
    treeSort(list, size);
    getchar(); return 0;
}

void displayInorder(treeNode* root){
    if(root){
        displayInorder(root -> left);
        printf("%d ", root -> key);
        displayInorder(root -> right);
    }
}

void treeSort(int a[], int n){
    treeNode* root = NULL;
    root = insertBSTNode(root, a[0]);
    for(int i = 1; i<n; i++){
        insertBSTNode(root, a[i]);
    }
    displayInorder(root);
}

treeNode* searchBST(treeNode* root, element x){
    treeNode* p;
    p = root;
    while(p != NULL){
        if(x< p->key){
            p = p -> left;
        }
        else if(x == p -> key){
            return p;
        }
        else{
            p = p -> right;
        }
    }
    printf("\n 찾는 키가 없습니다!");
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

void deleteBSTNode(treeNode* root, element key){
    treeNode* parent, * p, * succ, * succ_parent;
    treeNode* child;

    parent = NULL;
    p = root;
    while((p != NULL) && (p->key != key)){
        parent = p;
        if(key < p ->key){
            p = p -> left;
        }
        else{
            p = p -> right;
        }
    }

    //삭제할 노드가 없는 경우
    if(p == NULL){
        printf("\n 찾는 키가 이진 트리에 없습니다!");
        return;
    }

    //삭제할 노드가 단말 노드인 경우
    if((p -> left == NULL) && (p -> right == NULL)){
        if(parent != NULL){
            if(parent -> left == p){
                parent -> left = NULL;
            }
            else{
                parent -> right = NULL;
            }
        }
        else root = NULL;
    }


    //삭제할 노드가 자식노드를 한개 가지는 경우
    else if((p -> left == NULL) || (p -> right == NULL)){
        if(p -> left != NULL){
            child = p -> left;
        }
        else{
            child = p -> right;
        }

        if(parent != NULL){
            if(parent -> left == p){
                parent -> left = child;
            }
            else{
                parent -> right = child;
            }
        }
        else root = child;
    }

    //삭제할 노드가 자식 노드를 두개 가진 경우
    else{
        succ_parent = p;
        succ = p -> left;
        while(succ -> right != NULL){
            succ_parent = succ;
            succ = succ -> right;
        }

        if(succ_parent -> left == succ){
            succ_parent -> left =succ -> left;
        }
        else{
            succ_parent -> right = succ -> left;
        }
        p->key = succ -> key;
        p = succ;
    }
    free(p);
}
