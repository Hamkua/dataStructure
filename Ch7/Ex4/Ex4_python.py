class TreeNode:
    def __init__(self, key = None, left = None, right = None):
        self.key = key
        self.left = left
        self.right = right

def displayInorder(root):
    if(root != None):
        displayInorder(root.left)
        print("{}_".format(root.key), end="")
        displayInorder(root.right)

def searchBST(root, x):
    p = root
    while(p != None):
        if(x < p.key):
            p = p.left
        elif(x == p.key):
            return p
        else:
            p = p.right
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
        print("이미 같은 키가 있습니다!", end="")
    return p

def deleteBSTNode(root, key):
    p = root
    while((p != None) and (p.key != key)):
        parent = p
        if(key < p.key):
            p = p.left
        else:
            p = p.right
    
    #삭제할 노드가 없는 경우
    if(p == None):
        print("\n 찾는 키가 이진 트리에 없습니다!", end="")
        return

    #삭제할 노드가 단말 노드인 경우
    if((p.left == None) and (p.right == None)):
        if(parent != None):
            if(parent.left == p):
                parent.left = None
            else:
                parent.right = None
        else:
            root = None
    
    #삭제할 노드가 자식노드를 한개 가지는 경우
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

    #삭제할 노드가 자식 노드를 두개 가진 경우
    else:
        succParent = p
        succ = p.left
        while(succ.right != None):
            succParent = succ
            succ = succ.right

        if(succParent.left == succ):
            succParent.left = succ.left
        else:
            succParent.right = succ.left
        p.key = succ.key
        p = succ

def menu():
    print("\n*------------------------*",end = "")
    print("\n\t1 : 트리 출력",end = "")
    print("\n\t2 : 문자 삽입",end = "")
    print("\n\t3 : 문자 삭제",end = "")
    print("\n\t4 : 문자 검색",end = "")
    print("\n\t5 : 종료",end = "")
    print("\n*------------------------*",end = "")
    print("\n메뉴입력 >> ",end = "")

root = TreeNode(key = 'G')
insertBSTNode(root,'I')
insertBSTNode(root,'H')
insertBSTNode(root,'D')
insertBSTNode(root,'B')
insertBSTNode(root,'M')
insertBSTNode(root,'N')
insertBSTNode(root,'A')
insertBSTNode(root,'J')
insertBSTNode(root,'E')
insertBSTNode(root,'Q')

while(1):
    menu()
    choice = int(input())

    if(choice == 1):
        print("\t[이진 트리 출력]  ",end="")
        displayInorder(root)
        print()
    
    elif(choice == 2):
        print("삽입할 문자를 입력하세요 : ",end="")
        key = input()
        insertBSTNode(root, key)

    elif(choice == 3):
        print("삭제할 문자를 입력하세요 : ",end="")
        key = input()
        deleteBSTNode(root, key)

    elif(choice == 4):
        print("찾을 문자를 입력하세요 : ", end="")
        key = input()
        foundedNode = searchBST(root, key)
        if(foundedNode != None):
            print("\n{}를 찾았습니다!".format(foundedNode.key))
        else:
            print("\n 문자를 찾지 못했습니다!")
    
    elif(choice == 5):
        break

    else:
        print("없는 메뉴입니다. 메뉴를 다시 선택하세요! \n")
        continue