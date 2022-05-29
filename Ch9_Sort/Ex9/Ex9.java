
public class Ex9 {
    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 트리 정렬 수행 >>>>>>>>>");
        treeSort(list, size);

    }

    public static void treeSort(int[] a, int n){
        TreeNode root = new TreeNode();
        root = insertBSTNode(root, a[0]);

        for(int i = 1; i<n; i++){
            insertBSTNode(root, a[i]);
        }
        displayInorder(root);
    }

    static class TreeNode{
        int key = 0;
        TreeNode left;
        TreeNode right;
    }

    public static void displayInorder(TreeNode root){
        if(root != null){
            displayInorder(root.left);
            System.out.print(root.key + " ");
            displayInorder(root.right);
        }
    }

    public static TreeNode searchBST(TreeNode root, int x){
        TreeNode p = root;
        while(p != null){
            if(x < p.key){
                p = p.left;
            } else if(x == p.key){
                return p;
            } else{
                p = p.right;
            }
        }
        System.out.print("\n찾는 키가 없습니다!");
        return p;
    }

    public static TreeNode insertBSTNode(TreeNode p, int x){
        TreeNode newNode = new TreeNode();
        if(p == null){
            newNode.key = x;
            newNode.left = null;
            newNode.right = null;
            return newNode;
        }else if(x < p.key){
            p.left = insertBSTNode(p.left, x);
        }else if(x > p.key){
            p.right = insertBSTNode(p.right, x);
        }else{
            System.out.println("\n 이미 같은 키가 있습니다!");
        }
        return p;
    }

    public static void deleteBSTNode(TreeNode root, int key){
        TreeNode parent, p, succ, succ_parent;
        TreeNode child;

        parent = null;
        p = root;
        while((p != null)&&(p.key != key)){
            parent = p;
            if(key < p.key){
                p = p.left;
            }else{
                p = p.right;
            }
        }

        if(p == null){
            System.out.print("\n 찾는 키가 이진 트리에 없습니다!");
            return;
        }

        if((p.left == null)&&(p.right == null)){    //삭제할 노드가 단말 노드인 경우
            if(parent != null){
                if(parent.left == p){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }else{
                root = null;
            }
        } else if((p.left == null)||(p.right == null)){    //삭제할 노드가 자식 노드를 하나 가진 경우
            if(p.left != null){
                child = p.left;
            }else{
                child = p.right;
            }

            if(parent != null){
                if(parent.left == p){
                    parent.left = child;
                }else{
                    parent.right = child;
                }
            }else{
                root = child;
            }
        }else{    //삭제할 노드가 자식노드를 두개 가진 경우
            succ_parent = p;
            succ = p.left;
            while(succ.right != null){
                succ_parent = succ;
                succ = succ.right;
            }
            if(succ_parent.left == succ){
                succ_parent.left = succ.left;
            }else{
                succ_parent.right = succ.left;
            }
            p.key = succ.key;
            p = succ;
        }
    }
}
