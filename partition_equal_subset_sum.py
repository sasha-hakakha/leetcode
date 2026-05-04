class Solution:
    def canPartition(self, nums: List[int]) -> bool:
       if sum(nums) % 2:
           return False
       dp = set([0])
       for i in range(len(nums)):
           next_dp = set()
           for num in dp:
               next_dp.add(num)
               next_dp.add(num + nums[i])
           dp = next_dp
       return sum(nums) // 2 in dp 
