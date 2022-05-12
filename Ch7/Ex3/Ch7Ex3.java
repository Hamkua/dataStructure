package dataStructure;

class TreeThNode{
    char data;
    TreeThNode left, right;
    int isThreadRight;

    public TreeThNode(char data, int isThreadRight){
        this.data = data;
        this.isThreadRight = isThreadRight;
    }

    public TreeThNode(char data, TreeThNode leftNode, TreeThNode rightNode, int isThreadRight){
        this.data = data;
        this.left = leftNode;
        this.right = rightNode;
        this.isThreadRight = isThreadRight;
    }

    public static TreeThNode findThreadSuccessor(TreeThNode p){
        TreeThNode q = p.right;
        if(q == null){
            return q;
        }
        if(p.isThreadRight == 1){
            return q;
        }
        while(q.left != null){
            q = q.left;
        }
        return q;
    }

    public static void threadInorder(TreeThNode root){
        TreeThNode q = root;
        while(q.left != null){
            q = q.left;
        }

        while(q != null){
            System.out.print("  " + q.data);
            q = findThreadSuccessor(q);
        }
    }
}

public class Ch7Ex3 {
    public static void main(String[] args) {
        TreeThNode n7 = new TreeThNode('D',0);
        TreeThNode n6 = new TreeThNode('C',1);
        TreeThNode n5 = new TreeThNode('B',1);
        TreeThNode n4 = new TreeThNode('A',1);
        TreeThNode n3 = new TreeThNode('/',n6,n7,0);
        TreeThNode n2 = new TreeThNode('*',n4,n5,0);
        TreeThNode n1 = new TreeThNode('-',n2,n3,0);

        n4.right = n2;
        n5.right = n1;
        n6.right = n3;

        System.out.print("\n 스레드 이진 트리의 중위 순회 : ");
        TreeThNode.threadInorder(n1);

    }
}
