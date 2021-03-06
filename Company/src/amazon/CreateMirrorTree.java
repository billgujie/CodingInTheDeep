package amazon;

import lib.TreeNode;

public class CreateMirrorTree {

   /**
    * Create the mirror tree of the original tree
    */
   public static void main(String[] args) {
      TreeNode root = new TreeNode(new int[]{1,2,3,4,5});
      System.out.println(root.printTree());
//      mirror1(root);
//      System.out.println(root.printTree());
      System.out.println(mirror2(root).printTree());
   }
   // in plcae change
   public static void mirror1(TreeNode node){
      if(node == null)  return;
      mirror1(node.left);
      mirror1(node.right);
      TreeNode tmp = node.left; node.left = node.right; node.right = tmp;
   }
   // create a new tree
   public static TreeNode mirror2(TreeNode node){
      if (node == null) return null;
      TreeNode copy = new TreeNode(node.val);
      copy.left = mirror2(node.right);
      copy.right = mirror2(node.left);
      return copy;
   }

}
