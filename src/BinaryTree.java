public class BinaryTree {
    public static void main(String[] args) {

        BinaryTreeInstance binaryTreeInstance = new BinaryTreeInstance();
        UsrNode root = new UsrNode(1, "HY");
        UsrNode u1 = new UsrNode(2, "H");
        UsrNode u2 = new UsrNode(3, "Y");
        UsrNode u3 = new UsrNode(4, "HYY");
        UsrNode u4 = new UsrNode(5, "HYYY");
        UsrNode u5 = new UsrNode(6, "YY");

        root.setLeft(u1);
        root.setRight(u2);
        u2.setLeft(u3);
        u3.setLeft(u4);
        u3.setRight(u5);

        binaryTreeInstance.setRoot(root);

        binaryTreeInstance.preOrder();

        binaryTreeInstance.delNode(4);

        binaryTreeInstance.preOrder();


    }

}

class BinaryTreeInstance {
    UsrNode root = new UsrNode();

    public void setRoot(UsrNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else
            System.out.println("二叉树为空");
    }

    public void midOrder() {
        if (root != null) {
            root.midOrder();
        } else
            System.out.println("二叉树为空");
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else
            System.out.println("二叉树为空");
    }

    public void delNode(int no) {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        if (root.getNo() == no) {
            System.out.println("二叉树置空");
            root = null;
            return;
        }
        root.delNode(no);
    }

}

class UsrNode {
    private int no;
    private String name;
    private UsrNode left;
    private UsrNode right;

    public UsrNode() {

    }

    public UsrNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UsrNode getLeft() {
        return left;
    }

    public void setLeft(UsrNode left) {
        this.left = left;
    }

    public UsrNode getRight() {
        return right;
    }

    public void setRight(UsrNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "UsrNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        if (this.right != null) {
            this.right.midOrder();
        }
        System.out.println(this);
    }


    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            //分特定情况确定字数处理逻辑
            UsrNode curJudgeNode = this.left;
            if (curJudgeNode.left != null && curJudgeNode.right != null) {
                UsrNode temp = curJudgeNode.right;
                this.left = curJudgeNode.left;
                this.left.right = temp;
                return;
            }
            if (curJudgeNode.left != null) {
                this.left = curJudgeNode.left;
                return;
            }
            if (curJudgeNode.right != null) {
                this.left = curJudgeNode.right;
                return;
            }
            //不考虑子树有无时直接置空
//            this.left = null;
//            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null && this.right.no == no) {
            UsrNode curJudgeNode = this.right;
            if (curJudgeNode.left != null && curJudgeNode.right != null) {
                UsrNode temp = curJudgeNode.right;
                this.right = curJudgeNode.left;
                this.right.right = temp;
                return;
            }
            if (curJudgeNode.left != null) {
                this.right = this.right.left;
                return;
            }
            if (curJudgeNode.right != null) {
                this.right = curJudgeNode.right;
                return;
            }
//            this.right = null;
//            return;
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}
