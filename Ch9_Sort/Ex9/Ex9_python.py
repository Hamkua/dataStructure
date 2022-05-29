from numpy import disp


class TreeNode:
    def __init__(self, key = 0, left = None, right = None):
        self.key = key
        self.left = left
        self.right = right

def search_BST(root, x):
    p = root
    while(p!=None):
        if(x < p.key):
            p = p.left
        elif( x == p.key):
            return p
        else:
            p = p.right

    print("\n 찾는 키가 없습니다!", end="")
    return p

def insert_BSTNode(p, x):
    if(p == None):
        newNode = TreeNode(x)
        return newNode

    elif(x < p.key):
        p.left = insert_BSTNode(p.left, x)

    elif(x > p.key):
        p.right = insert_BSTNode(p.right, x)

    else:
        print("이미 같은 키가 있습니다!",end="")

    return p
        
def delete_BSTNode(root, key):
    parent = None
    p = root
    while((p != None) and (p.key != key)):
        parent = p
        if(key < p.key):
            p = p.left
        else:
            p = p.right

    if(p == None):
        print("\n찾는 키가 이진 트리에 없습니다!", end="")
        return

    if((p.left == None) and (p.right == None)):
        if(parent != None):
            if(parent.left == p):
                parent.left = None
            else:
                parent.right = None 
        else:
            root = None

    elif((p.left == None) or (p.right == None)):
        if(p.left != None):
            child = p.left
        else:
            child = p.right 

        if(parent != None):
            if(parent.left == p):
                parent.left = child
            else:
                parent.right = child 
        else:
            root = child

    else:    #삭제할 노드가 자식 노드를 두개 가진 경우
        succ_parent = p 
        succ = p.left
        while(succ.right != None):
            succ_parent = succ 
            succ = succ.right
        
        if(succ_parent.left == succ):    
            succ_parent.left = succ.left
        
        else:
            succ_parent.right = succ.left 

        p.key = succ.key
        p = succ 


def display_inorder(root):
    if(root):
        display_inorder(root.left)
        print("{} ".format(root.key), end="")
        display_inorder(root.right)

def tree_sort(a, n):
    root = None
    root = insert_BSTNode(root, a[0])
    for i in range(1, n):
        insert_BSTNode(root, a[i])

    display_inorder(root)

li = [69, 10, 30, 2, 16, 8, 31, 22]
size = len(li)

print("정렬할 원소 : ", end ="")
for i in range(size):
    print("  {}".format(li[i]), end = "")

print("\n <<<<<<<<<<<<<<<<< 트리 정렬 수행 >>>>>>>>>>>>>>>>>>>")
tree_sort(li, size)