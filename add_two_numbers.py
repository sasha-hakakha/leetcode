# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def to_int(self, node: Optional[ListNode]) -> int:
        depth = 0
        result = 0
        while(node):
            result += node.val * 10 ** depth
            depth += 1
            node = node.next
        return result
            
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l1_int = self.to_int(l1)
        l2_int = self.to_int(l2)
        result =  l1_int + l2_int
        nums = [int(c) for c in str(result)[::-1]]
        current = ListNode(val = nums.pop(0), next=None)
        while(len(nums)):
            new_node = ListNode(val=nums.pop(0), next=None)
            current.next = new_node
            current = new_node
