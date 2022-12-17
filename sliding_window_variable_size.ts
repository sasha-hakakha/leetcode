//209
function minSubArrayLen(target: number, nums: number[]): number {
    var L = 0, total = 0, length = Infinity;

    for(let R = 0; R < nums.length; R++){
        total += nums[R];
        while(total >= target){
            length = Math.min(R-L+1, length);
            total -= nums[L];
            L += 1;
        }
    }
    if(length == Infinity)
        return 0;
    return length;
};

//3
function lengthOfLongestSubstring(s: string): number {
    const chars = new Set();
    var L = 0, length = 0;

    for(let R = 0; R < s.length; R++){
        while(chars.has(s[R])){
            chars.delete(s[L]);
            L += 1;
        }
        chars.add(s[R]);    
        length = Math.max(R-L+1, length);
    }
    return length;
};
