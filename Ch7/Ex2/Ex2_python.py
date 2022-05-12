class TreeNode:
    def __init__(self, size = None, left = None, right = None):
        self.size = size
        self.left = left 
        self.right = right


def postorder_FoldersSize(root):
    global folderSize
    if(root != None):
        postorder_FoldersSize(root.left)
        postorder_FoldersSize(root.right)
        folderSize += root.size
    return folderSize

folderSize = 0

f11 = TreeNode(size=120)
f10 = TreeNode(size=55)
f9 = TreeNode(size=100)
f8 = TreeNode(size=200)
f7 = TreeNode(size=68, left = f10, right = f11)
f6 = TreeNode(size=40)
f5 = TreeNode(size=15)
f4 = TreeNode(size=2, left = f8, right = f9)
f3 = TreeNode(size=10, left =f6, right = f7)
f2 = TreeNode(size=0, left = f4, right = f5)
f1 = TreeNode(size=0, left = f2, right = f3)

print("\n\n C:\\의 용량 : {} M".format(postorder_FoldersSize(f2)))
folderSize = 0
print("\n\n D:\\의 용량 : {} M".format(postorder_FoldersSize(f3)))
folderSize = 0
print("\n\n 내 컴퓨터의 전체 용량 : {} M".format(postorder_FoldersSize(f1)))
