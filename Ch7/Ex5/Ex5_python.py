class TreeNode:
    def __init__(self, key = None, left =None, right = None):
        self.key = key
        self.left = left
        self.right = right

def displayInorder(root):
    if(root != None):
        displayInorder(root.left)
        print("{}_".format(root.key), end="")
        displayInorder(root.right)

def searchBST(root, x):
    count = 0
    p = root
    while(p != None):
        count += 1
        if(x < p.key):
            p = p.left
        elif(x == p.key):
            print("{}번째에 탐색 성공".format(count), end="")
            return p
        else:
            p = p.right
    count += 1
    print("{}번째에 탐색 실패! ".format(count), end="")
    print("\n찾는 키가 없습니다 !", end="")
    return p

def insertBSTNode(p, x):
    if(p == None):
        newNode = TreeNode(key = x)
        return newNode
    elif(x<p.key):
        p.left = insertBSTNode(p.left, x)
    elif(x>p.key):
        p.right = insertBSTNode(p.right, x)
    else:
        print("이미 같은 키가 있습니다!", end ="")
    return p


def LL_rotate(parent):
    child = parent.left
    parent.left = child.right
    child.right = parent
    return child

def RR_rotate(parent):
    child = parent.right
    parent.right = child.left
    child.left = parent
    return child

def LR_rotate(parent):
    child = parent.left
    parent.left = RR_rotate(child)
    return LL_rotate(parent)

def RL_rotate(parent):
    child = parent.right
    parent.right = LL_rotate(child)
    return RR_rotate(parent)


#서브 트리의 높이를 구하는 연산
def getHeight(p):
    height = 0
    if(p != None):
        height = max(getHeight(p.left),getHeight(p.right)) + 1
    return height

#서브 트리의 높이를 이용, 균형 인수 BF를 구하는 함수
def getBF(p):
    if(p == None):
        return 0
    return getHeight(p.left) - getHeight(p.right)

def rebalance(p):
    BF = getBF(p)
    if(BF > 1):
        if(getBF(p.left) > 0):
            p = LL_rotate(p)
        else:
            p = LR_rotate(p)

    elif(BF < -1):
        if(getBF(p.right) < 0):
            p = RR_rotate(p)
        else:
            p = RL_rotate(p)

    return p

#AVL트리에 노드를 삽입하는 연산: 이진 탐색 연산처럼 삽입한 후에, rebalance() 호출
def insertAVLNode(root, x):
    if( root == None):
        newNode = TreeNode(key=x)
        return newNode
    elif(x < root.key):
        root.left = insertAVLNode(root.left, x)
        root = rebalance(root)
    elif(x > root.key):
        root.right = insertAVLNode(root.right, x)
        root = rebalance(root)
    else:
        print("\n이미 같은 키가 있습니다!")
    
    return root

root_AVL = None
root_BST = None

root_AVL = insertAVLNode(root_AVL, 50)
root_AVL = insertAVLNode(root_AVL, 60)
root_AVL = insertAVLNode(root_AVL, 70)
root_AVL = insertAVLNode(root_AVL, 90)
root_AVL = insertAVLNode(root_AVL, 80)
root_AVL = insertAVLNode(root_AVL, 75)
root_AVL = insertAVLNode(root_AVL, 73)
root_AVL = insertAVLNode(root_AVL, 72)
root_AVL = insertAVLNode(root_AVL, 78)


print("\n ********** AVL 트리 출력 ****************** \n\n", end="")
displayInorder(root_AVL)

print("\n\n AVL 트리에서 70 탐색 : ", end="")
searchBST(root_AVL, 70)

print("\n\n AVL 트리에서 72 탐색 : ", end="")
searchBST(root_AVL, 72)

print("\n\n AVL 트리에서 76 탐색 : ", end="")
searchBST(root_AVL, 76)


root_BST = insertBSTNode(root_BST, 50)
insertBSTNode(root_BST, 60)
insertBSTNode(root_BST, 70)
insertBSTNode(root_BST, 90)
insertBSTNode(root_BST, 80)
insertBSTNode(root_BST, 75)
insertBSTNode(root_BST, 73)
insertBSTNode(root_BST, 72)
insertBSTNode(root_BST, 78)

print("\n ********** BST 출력 ****************** \n\n", end ="")

displayInorder(root_BST)

print("\n\n BST 트리에서 70 탐색 : ", end="")
searchBST(root_BST, 70)

print("\n\n BST 트리에서 72 탐색 : ", end ="")
searchBST(root_BST, 72)

print("\n\n BST 트리에서 76 탐색 : ", end ="")
searchBST(root_BST, 76)