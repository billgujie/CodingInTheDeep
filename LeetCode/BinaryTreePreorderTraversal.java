/*
    Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,2,3].

    Note: Recursive solution is trivial, could you do it iteratively?
*/

// Stack Iterative traversal.
// time: O(n); space: O(h), h is the maximum height of the tree
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null || !st.isEmpty()){
            if (root == null)   root = st.pop();
            res.add(root.val);
            if (root.right != null) st.push(root.right);
            root = root.left;
        }
        return res;
    }
}

// Stack Iterative traversal, from Sophie. 2 while loops, logic is easier to understand.
// Refer to BinaryTreeInorderTraversal, only position of 'res.add()'' changes
public class Solution{
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            res.add(root.val);
            root = root.left;
        }
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            curr = curr.right;
            while (curr != null){
                st.push(curr);
                res.add(curr.val);
                curr = curr.left;
            } 
        }
        return res;
    }
}

// Morris threaded tree pre-order traversal
// Great post from AnnieKim. http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
// time: O(n); space: O(1)
// Refer to BinaryTreeInorderTraversal, only position of 'res.add()'' changes
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        TreeNode curr =root;
        while (curr != null){
            if (curr.left != null){
                TreeNode prev = curr.left;
                // find predecessor 
                while (prev.right!=null && prev.right!=curr)    prev = prev.right;
                if (prev.right == curr){    
                    curr = curr.right;
                    prev.right = null;
                }
                else{                  
                    res.add(curr.val);
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