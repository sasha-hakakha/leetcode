function containsNearbyDuplicate(nums: number[], k: number): boolean {
    let window = new Set<number>();
    var L = 0;

    for(let R = 0; R < nums.length; R++){
        if(R - L > k){
            window.delete(nums[L]);
            L += 1;
        }
        if(window.has(nums[R]))
           return true;
        window.add(nums[R])
    }
    return false;
};

//1343
function numOfSubarrays(arr: number[], k: number, threshold: number): number {
    let window = 0;
    for(let i = 0; i < k - 1; i++)
        window += arr[i];
    let L = 0;
    let count = 0;
    
    for(let i = k - 1; i < arr.length; i++){
        window += arr[i];

        if (window / k >= threshold)
            count += 1;
        window -= arr[i - k + 1];
    }
    return count;
};
