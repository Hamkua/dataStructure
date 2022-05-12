class TreeNode:
    def __init__(self, data = None, left = None, right = None):
        self.data = data
        self.left = left 
        self.right = right

def preorder(root):
    if(root != None):
        print(root.data, end="")
        preorder(root.left)
        preorder(root.right)

def inorder(root):
    if(root != None):
        inorder(root.left)
        print(root.data, end="")
        inorder(root.right)

def postorder(root):
    if(root != None):
        postorder(root.left)
        postorder(root.right)
        print(root.data, end="")

n7 = TreeNode(data = 'D')
n6 = TreeNode(data = 'C')
n5 = TreeNode(data = 'B')
n4 = TreeNode(data = 'A')
n3 = TreeNode(data = '/', left = n6, right= n7)
n2 = TreeNode(data = '*', left = n4, right= n5)
n1 = TreeNode(data = '-', left = n2, right= n3)

print("\n preorder : ", end="")
preorder(n1)

print("\n inorder : ", end="")
inorder(n1)

print("\n postorder : ", end="")
postorder(n1)
