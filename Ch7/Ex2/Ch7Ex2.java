//package dataStructure;
//class TreeNode{
//    int size;
//    TreeNode left, right;
//    static int folderSize = 0;
//
//    public TreeNode(int size){
//        this.size = size;
//    }
//
//    public TreeNode(int size, TreeNode leftNode, TreeNode rightNode){
//        this.size = size;
//        this.left = leftNode;
//        this.right = rightNode;
//    }
//
//    public static int  postorder_FolderSize(TreeNode root){
//        if(root != null){
//            postorder_FolderSize(root.left);
//            postorder_FolderSize(root.right);
//            folderSize += root.size;
//        }
//        return folderSize;
//    }
//}
//public class Ch7Ex2 {
//    public static void main(String[] args) {
//        TreeNode f11 = new TreeNode(120);
//        TreeNode f10= new TreeNode(55);
//        TreeNode f9 = new TreeNode(100);
//        TreeNode f8 = new TreeNode(200);
//        TreeNode f7 = new TreeNode(68, f10, f11);
//        TreeNode f6 = new TreeNode(40);
//        TreeNode f5 = new TreeNode(15);
//        TreeNode f4 = new TreeNode(2, f8, f9);
//        TreeNode f3 = new TreeNode(10, f6, f7);
//        TreeNode f2 = new TreeNode(0, f4, f5);
//        TreeNode f1 = new TreeNode(0, f2, f3);
//
//        System.out.print("\n\n C:\\의 용량 : " + TreeNode.postorder_FolderSize(f2) + "M");
//
//        TreeNode.folderSize = 0;
//        System.out.print("\n\n D:\\의 용량 : " + TreeNode.postorder_FolderSize(f3) + "M");
//
//        TreeNode.folderSize = 0;
//        System.out.print("\n\n 내 컴퓨터의 전체 용량 : " + TreeNode.postorder_FolderSize(f1) + "M");
//    }
//}
