package dataStructure;

import java.util.Scanner;

class TreeNode{
    char key;
    TreeNode left, right;

    public TreeNode(char x){
        this.key = x;
    }

    public static void displayInorder(TreeNode root){
        if(root != null){
            displayInorder(root.left);
            System.out.print(root.key + "_");
            displayInorder(root.right);
        }
    }

    public static TreeNode searchBST(TreeNode root, char x){
        TreeNode p;
        p = root;
        while(p != null){
            if(x< p.key){
                p = p.left;
            }
            else if(x == p.key){
                return p;
            }
            else{
                p = p.right;
            }
        }
        System.out.print("\n 찾는 키가 없습니다!");
        return p;
    }

    public static TreeNode insertBSTNode(TreeNode p, char x){
        if(p == null){
            TreeNode newNode = new TreeNode(x);
            newNode.left = null;
            newNode.right = null;
            return newNode;
        } else if(x< p.key){
            p.left = insertBSTNode(p.left, x);
        }else if(x > p.key){
            p.right = insertBSTNode(p.right, x);
        } else{
            System.out.print("이미 같은 키가 있습니다!");
        }
        return p;
    }

    public static void deleteBSTNode(TreeNode root, char key){
        TreeNode parent, p, succ, succParent;
        TreeNode child;
        parent = null;
        p = root;
        while((p != null) && (p.key != key)){
            parent = p;
            if(key < p.key){
                p = p.left;
            }
            else{
                p = p.right;
            }
        }

        //삭제할 노드가 없는 경우
        if(p == null){
            System.out.print("\n 찾는 키가 이진 트리에 없습니다!");
            return;
        }

        //삭제할 노드가 단말 노드인 경우
        if((p.left == null) && (p.right == null)){
            if(parent != null){
                if(parent.left == p){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            else{
                root = null;
            }
        }


        //삭제할 노드가 자식노드를 한개 가지는 경우
        else if((p.left == null) || (p.right == null)){
            if(p.left != null){
                child = p.left;
            }
            else{
                child = p.right;
            }

            if(parent != null){
                if(parent.left == p){
                    parent.left = child;
                }
                else{
                    parent.right = child;
                }
            }
            else root = child;
        }

        //삭제할 노드가 자식 노드를 두개 가진 경우
        else{
            succParent = p;
            succ = p.left;
            while(succ.right != null){
                succParent = succ;
                succ = succ.right;
            }

            if(succParent.left == succ){
                succParent.left =succ.left;
            }
            else{
                succParent.right = succ.left;
            }
            p.key = succ.key;
            p = succ;
        }
    }

    public static void menu(){
        System.out.print("\n*------------------------*");
        System.out.print("\n\t1 : 트리 출력");
        System.out.print("\n\t2 : 문자 삽입");
        System.out.print("\n\t3 : 문자 삭제");
        System.out.print("\n\t4 : 문자 검색");
        System.out.print("\n\t5 : 종료");
        System.out.print("\n*------------------------*");
        System.out.print("\n메뉴입력 >> ");
    }
}
public class Ch7Ex4 {
    public static void main(String[] args) {
        TreeNode foundedNode = null;
        char choice, key;

        TreeNode root = new TreeNode('G');
        TreeNode.insertBSTNode(root, 'I');
        TreeNode.insertBSTNode(root, 'H');
        TreeNode.insertBSTNode(root, 'D');
        TreeNode.insertBSTNode(root, 'B');
        TreeNode.insertBSTNode(root, 'M');
        TreeNode.insertBSTNode(root, 'N');
        TreeNode.insertBSTNode(root, 'A');
        TreeNode.insertBSTNode(root, 'J');
        TreeNode.insertBSTNode(root, 'E');
        TreeNode.insertBSTNode(root, 'Q');


        Scanner sc = new Scanner(System.in);

        while(true){
            TreeNode.menu();
            choice = sc.next().charAt(0);

            switch ((int)(choice - '0'))
            {
                case 1:
                    System.out.print("\t[이진 트리 출력]  ");
                    TreeNode.displayInorder(root);
                    System.out.print("\n");
                    break;

                case 2:
                    System.out.print("삽입할 문자를 입력하세요 : ");
                    key = sc.next().charAt(0);
                    TreeNode.insertBSTNode(root, key);
                    break;

                case 3:
                    System.out.print("삭제할 문자를 입력하세요 : ");
                    key = sc.next().charAt(0);
                    TreeNode.deleteBSTNode(root, key);
                    break;

                case 4:
                    System.out.print("찾을 문자를 입력하세요 : ");
                    key = sc.next().charAt(0);
                    foundedNode = TreeNode.searchBST(root, key);
                    if(foundedNode != null){
                        System.out.println("\n" + foundedNode.key + "를 찾았습니다!");
                    }
                    else{
                        System.out.print("\n 문자를 찾지 못했습니다");
                    }
                    break;

                case 5: return;

                default:
                    System.out.print("없는 메뉴입니다. 메뉴를 다시 선택하세요! \n");
                    break;
            }
        }

    }
}
