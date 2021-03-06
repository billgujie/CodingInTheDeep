/*
    Given a binary tree, return the inorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,3,2].

    Note: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Stack Iterative traversal. from Sophie. 2 while loops, logic is easier to understand than the wiki version.
// time: O(n); space: O(h), h is the maximum height of the tree
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            root = root.left;
        }
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
            while (curr!=null){
                st.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
}

// Threads are references to the predecessor and successor of 
// the node according to an inorder traversal
//
// Trees whose nodes use threads are called 
// threaded trees

// Morris threaded tree in-order traversal, right plays the role of 'next'
// Great post from AnnieKim. http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
// time: O(n); space: O(1)
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        TreeNode curr =root;
        while (curr != null){
            if (curr.left != null){
                TreeNode prev = curr.left;
                // find predecessor 
                while (prev.right!=null && prev.right!=curr)    prev = prev.right;
                if (prev.right == curr){    
                    res.add(curr.val);
                    curr = curr.right;
                    prev.right = null;
                }
                else{                  
                    prev.right = curr;
                    curr = curr.left;
                }
            }else{
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }
}