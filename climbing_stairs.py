class Solution:
    def climbStairs(self, n: int) -> int:
        cache = {}
        def climb(current):
            if current > n:
                return 0
            if current == n:
                return 1
            if current in cache:
                return cache[current]
            result= climb(current + 1) + climb(current + 2)
            cache[current] = result
            return result
        return climb(0)
