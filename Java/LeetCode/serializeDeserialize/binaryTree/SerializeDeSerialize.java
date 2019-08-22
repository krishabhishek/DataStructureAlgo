package Java.LeetCode.serializeDeserialize.binaryTree;

import Java.LeetCode.HelperDatastructure.TreeNode;
import Java.LeetCode.serializeDeserialize.ISerializeDeserialize;

/**
 * Author: Nitin Gupta(nitin.gupta@walmart.com)
 * Date: 04/04/19
 * Description:
 */


public class SerializeDeSerialize {
    static SerializeDeSerializeBinaryTree serializeDeSerializeBinaryTree = new SerializeDeSerializeBinaryTree();

    static void inOrder(TreeNode root) {
        if (null == root)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);

    }


    public static void main(String args[]) {


        preOrder();
        levelOrder();


    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(4);

        root.right.left = null;
        root.right.right = new TreeNode(9);

        return root;
    }

    private static void preOrder() {
        System.out.println("\n\n Pre order ");
        TreeNode root = getTree();

        System.out.println("Original Tree Inorder");
        inOrder(root);
        ISerializeDeserialize preOrder = serializeDeSerializeBinaryTree.new PreOrder();

        System.out.println("\nSerializing Tree");

        String vv = preOrder.serialize(root);
        System.out.println(" Serialized tree " + vv);

        TreeNode r = preOrder.deserialize(vv);
        System.out.println("Deserialize tree , inorder");
        inOrder(r);


    }


    private static void levelOrder() {

        System.out.println("\n\n Level order ");
        TreeNode root = getTree();

        System.out.println("Original Tree Inorder");
        inOrder(root);


        System.out.println("Serializing Tree");


        ISerializeDeserialize levelOrder = serializeDeSerializeBinaryTree.new LevelOrder();


        String vv = levelOrder.serialize(root);
        System.out.println(" Serialized tree " + vv);

        TreeNode r = levelOrder.deserialize(vv);
        System.out.println("Deserialize tree , inorder");
        inOrder(r);


    }


}