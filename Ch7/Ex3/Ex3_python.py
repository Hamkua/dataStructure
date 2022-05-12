class TreeNode:
    def __init__(self, data = None, left = None, right = None, isThreadRight = None):
        self.data = data
        self.isThreadRight = isThreadRight
        self.left = left   
        self.right = right

def findThreadSuccessor(p):
    q = p.right
    if(q == None):
        return q
    if(p.isThreadRight == 1):
        return q
    while(q.left != None):
        q = q.left
    return q

def threadInorder(root):
    q = root
    while(q.left != None):
        q = q.left

    while(q!= None):
        print("  {}".format(q.data), end ="")
        q = findThreadSuccessor(q)

n7 = TreeNode(data='D', isThreadRight=0)
n6 = TreeNode(data='C', isThreadRight=1)
n5 = TreeNode(data='B', isThreadRight=1)
n4 = TreeNode(data='A', isThreadRight=1)
n3 = TreeNode(data='/', left = n6, right = n7, isThreadRight=0)
n2 = TreeNode(data='*', left = n4, right = n5, isThreadRight=0)
n1 = TreeNode(data='-', left = n2, right = n3, isThreadRight=0)

n4.right = n2
n5.right = n1
n6.right = n3

print("\n 스레드 이진 트리의 중위 순회 : ", end="")
threadInorder(n1)