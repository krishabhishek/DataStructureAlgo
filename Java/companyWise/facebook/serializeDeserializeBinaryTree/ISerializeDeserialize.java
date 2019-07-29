package Java.companyWise.facebook.serializeDeserializeBinaryTree;

/**
 * Author: Nitin Gupta(nitin.gupta@walmart.com)
 * Date: 2019-07-29
 * Description:
 */
public interface ISerializeDeserialize {

    String seperator = "$";

    String serialize(TreeNode root);

    TreeNode deserialize(String data);
}
