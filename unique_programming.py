class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = {}
        def rec_paths(x, y) -> int:
            if (x,y) in dp:
                return dp[(x,y)]
            if x == m -1 and y == n -1:
                return 1
            if x == m - 1:
                dp[(x,y)] = rec_paths(x, y+1)
                return dp[(x,y)]
            if y == n - 1:
                dp[(x,y)] = rec_paths(x+1, y)
                return dp[(x,y)]
            dp[(x,y)] = rec_paths(x+1, y) + rec_paths(x,y+1)
            return dp[(x,y)] 
        return rec_paths(0,0)
