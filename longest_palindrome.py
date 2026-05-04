class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expand(l,r):
            while(l >= 0 and r < len(s) and s[l] == s[r]):
                l-=1
                r+=1
        res = ""
        for i in range(len(s)):
            one = expand(i,i)
            two = expand(i,i+1)
            res = max(res, one, two, key=len)
    return res
            
            
