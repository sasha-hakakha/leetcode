# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def is_same_tree(r1: Optional[TreeNode], r2: Optional[TreeNode]) -> bool:
            if(not r1 and not r2):
                return True
            if(not r1 or not r2):
                return False
            if(r1.val != r2.val):
                return False
            return is_same_tree(r1.left, r2.left) and is_same_tree(r1.right, r2.right)
        def recursive_check(r1: Optional[TreeNode], r2: Optional[TreeNode]) -> bool:
            if(not r1):
                return bool(r2)
            return is_same_tree(r1, r2) or recursive_check(r1.left, r2) or recursive_check(r1.right, r2) 
        return recursive_check(root, subRoot)
