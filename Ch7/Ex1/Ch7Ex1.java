//package dataStructure;
//
//import apple.laf.JRSUIUtils;
//
//class TreeNode{
//    char data;
//    TreeNode left;
//    TreeNode right;
//
//    public TreeNode(char data, TreeNode leftNode, TreeNode rightNode){
//        this.data = data;
//        this.left = leftNode;
//        this.right = rightNode;
//    }
//
//    public TreeNode(char data){
//        this.data = data;
//    }
//
//    public static void preorder(TreeNode root){
//        if(root != null) {
//            System.out.print(root.data);
//            preorder(root.left);
//            preorder(root.right);
//        }
//    }
//
//    public static void inorder(TreeNode root){
//        if(root != null){
//            inorder(root.left);
//            System.out.print(root.data);
//            inorder(root.right);
//        }
//    }
//
//    public static void postorder(TreeNode root){
//        if(root != null) {
//            postorder(root.left);
//            postorder(root.right);
//            System.out.print(root.data);
//        }
//    }
//}
//public class Ch7Ex1 {
//    public static void main(String[] args) {
//        TreeNode n7 = new TreeNode('D');
//        TreeNode n6 = new TreeNode('C');
//        TreeNode n5 = new TreeNode('B');
//        TreeNode n4 = new TreeNode('A');
//        TreeNode n3 = new TreeNode('/', n6, n7);
//        TreeNode n2 = new TreeNode('*', n4, n5);
//        TreeNode n1 = new TreeNode('-', n2, n3);
//
//        System.out.print("\n preorder : ");
//        TreeNode.preorder(n1);
//
//        System.out.print("\n inorder : ");
//        TreeNode.inorder(n1);
//
//        System.out.print("\n postorder : ");
//        TreeNode.postorder(n1);
//
//
//
//    }
//}
