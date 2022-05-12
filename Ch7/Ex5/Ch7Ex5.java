//package dataStructure;
//class TreeNode{
//    int key;
//    TreeNode left, right;
//
//    public TreeNode(int key){
//        this.key = key;
//    }
//
//    public static void displayInorder(TreeNode root){
//        if(root != null){
//            displayInorder(root.left);
//            System.out.print(root.key + "_");
//            displayInorder(root.right);
//        }
//    }
//    public static TreeNode searchBST(TreeNode root, int x){
//        TreeNode p;
//        int count = 0;
//        p = root;
//        while(p!=null){
//            count++;
//            if(x < p.key){
//                p = p.left;
//            }
//            else if(x == p.key){
//                System.out.print(count + "번째에 탐색 성공");
//                return p;
//            }
//            else{
//                p = p.right;
//            }
//        }
//        count++;
//        System.out.print(count + "번째에 탐색 실패! 찾는 키가 없습니다!");
//        return p;
//    }
//
//    public static TreeNode insertBSTNode(TreeNode p, int x){
//        if(p == null){
//            TreeNode newNode = new TreeNode(x);
//            newNode.left = null;
//            newNode.right = null;
//            return newNode;
//        } else if(x< p.key){
//            p.left = insertBSTNode(p.left, x);
//        }else if(x > p.key){
//            p.right = insertBSTNode(p.right, x);
//        } else{
//            System.out.print("이미 같은 키가 있습니다!");
//        }
//        return p;
//    }
//
//    public static TreeNode LL_rotate(TreeNode parent){
//        TreeNode child = parent.left;
//        parent.left = child.right;
//        child.right = parent;
//        return child;
//    }
//
//    public static TreeNode RR_rotate(TreeNode parent){
//        TreeNode child = parent.right;
//        parent.right = child.left;
//        child.left = parent;
//        return child;
//    }
//
//    public static TreeNode LR_rotate(TreeNode parent){
//        TreeNode child = parent.left;
//        parent.left = RR_rotate(child);
//        return LL_rotate(parent);
//    }
//
//    public static TreeNode RL_rotate(TreeNode parent){
//        TreeNode child = parent.right;
//        parent.right = LL_rotate(child);
//        return RR_rotate(parent);
//    }
//
//    // 서브 트리의 높이를 구하는 연산
//    public static int getHeight(TreeNode p){
//        int height =0;
//        if(p != null){
//            height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
//        }
//        return height;
//    }
//
//    //서브 트리의 높이를 이용, 균형 인수 BF를 구하는 함수
//    public static int getBF(TreeNode p){
//        if(p == null){
//            return 0;
//        }
//        return getHeight(p.left) - getHeight(p.right);
//    }
//
//    public static TreeNode rebalance(TreeNode p){
//        int BF = getBF(p);
//        if(BF > 1){
//            if(getBF(p.left) > 0){
//                p = LL_rotate(p);
//            } else{
//                p = LR_rotate(p);
//            }
//        }
//        else if(BF < -1){
//            if(getBF(p.right) < 0){
//                p = RR_rotate(p);
//            } else{
//                p = RL_rotate(p);
//            }
//        }
//        return p;
//    }
//
//    //AVL트리에 노드를 삽입하는 연산: 이진 탐색 연산처럼 삽입한 후에, rebalance() 호출
//    public static TreeNode insertAVLNode(TreeNode root, int x){
//        if(root == null){
//            TreeNode newNode = new TreeNode(x);
//            newNode.left = null;
//            newNode.right = null;
//            return newNode;
//        } else if(x < root.key){
//            root.left = insertAVLNode(root.left,x);
//            root = rebalance(root);
//        } else if(x > root.key){
//            root.right = insertAVLNode(root.right,x);
//            root = rebalance(root);
//        } else{
//            System.out.print("\n 이미 같은 키가 있습니다! \n");
//        }
//        return root;
//    }
//}
//public class Ch7Ex5 {
//    public static void main(String[] args) {
//        TreeNode root_AVL = null;
//        TreeNode root_BST = null;
//
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 50);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 60);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 70);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 90);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 80);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 75);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 73);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 72);
//        root_AVL = TreeNode.insertAVLNode(root_AVL, 78);
//
//        System.out.print("\n ********** AVL 트리 출력 ****************** \n\n");
//        TreeNode.displayInorder(root_AVL);
//
//        System.out.print("\n\n AVL 트리에서 70 탐색 : ");
//        TreeNode.searchBST(root_AVL, 70);
//
//        System.out.print("\n\n AVL 트리에서 72 탐색 : ");
//        TreeNode.searchBST(root_AVL, 72);
//
//        System.out.print("\n\n AVL 트리에서 76 탐색 : ");
//        TreeNode.searchBST(root_AVL, 76);
//
//
//
//
//        root_BST = TreeNode.insertBSTNode(root_BST, 50);
//        TreeNode.insertBSTNode(root_BST, 60);
//        TreeNode.insertBSTNode(root_BST, 70);
//        TreeNode.insertBSTNode(root_BST, 90);
//        TreeNode.insertBSTNode(root_BST, 80);
//        TreeNode.insertBSTNode(root_BST, 75);
//        TreeNode.insertBSTNode(root_BST, 73);
//        TreeNode.insertBSTNode(root_BST, 72);
//        TreeNode.insertBSTNode(root_BST, 78);
//
//        System.out.print("\n ********** BST 출력 ****************** \n\n");
//
//        TreeNode.displayInorder(root_BST);
//
//        System.out.print("\n\n BST 트리에서 70 탐색 : ");
//        TreeNode.searchBST(root_BST, 70);
//
//        System.out.print("\n\n BST 트리에서 72 탐색 : ");
//        TreeNode.searchBST(root_BST, 72);
//
//        System.out.print("\n\n BST 트리에서 76 탐색 : ");
//        TreeNode.searchBST(root_BST, 76);
//    }
//}
