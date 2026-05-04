
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class Solution {
    private boolean recursiveCompare(TreeNode one, TreeNode two){
	if(one == null && two == null) return true;
	if(one == null || two == null) return false;
	if(one.val != two.val) return false;
	return recursiveCompare(one.left, two.left) && recursiveCompare(one.right, two.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
	return recursiveCompare(p, q);
        
    }
}
