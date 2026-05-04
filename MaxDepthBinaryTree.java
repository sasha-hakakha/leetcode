
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
    public int recursiveSearch(int current, TreeNode node){
	if(node.left == null && node.right == null) return current;
	if(node.left == null) return recursiveSearch(current + 1, node.right);
	if(node.right == null) return recursiveSearch(current + 1, node.left);
	else return Math.max(recursiveSearch(current + 1, node.left), recursiveSearch(current+1, node.right));
	
    }
    public int maxDepth(TreeNode root) {
	if(root == null) return 0;
	return recursiveSearch(1, root);
	    
    }
}
