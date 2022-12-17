// Kadane's algorithm

function maxSubArray(nums: number[]): number {
    //var max_sum = Number.MIN_SAFE_INTEGER;
    var max_sum = 0;
    var current = 0;
    for(var n of nums){
        current = Math.max(n, current + n);
        max_sum = Math.max(current, max_sum);
    }
    return max_sum;
};

function maxSubarraySumCircular(nums: number[]): number {
    var max_sum  = nums[0];
    var current_max = nums[0];
    var min_sum = nums[0];
    var current_min = nums[0];

    var sum = 0;
    for(let n of nums) sum += n;

    nums.shift();
    
    for(let n of nums){
        current_min = Math.min(n, current_min + n);
        current_max = Math.max(n, current_max + n);
        max_sum = Math.max(current_max, max_sum);
        min_sum = Math.min(current_min, min_sum);
    }
    if (min_sum == sum)
        return max_sum
    return Math.max(max_sum, sum - min_sum)
};

function maxTurbulenceSize(arr: number[]): number {
    if(arr.length < 2)
        return arr.length;
    var max_length_one = 0
    var current_one= 1;
    var max_length_two = 0;
    var current_two= 1;
    for(let i = 1; i < arr.length; i++){
        if (i % 2 == 0){
            if(arr[i-1] > arr[i])
                current_one += 1;
            else
                current_one = 1;
        }
        else{
            if(arr[i-1] < arr[i])
                current_one += 1;
            else
                current_one = 1;
        }
        max_length_one = Math.max(max_length_one, current_one);
    }
    for(let i = 1; i < arr.length; i++){
        if (i % 2 == 0){
            if(arr[i-1] < arr[i])
                current_two += 1;
            else
                current_two = 1;
        }
        else{
            if(arr[i-1] > arr[i])
                current_two += 1;
            else
                current_two = 1;
        }
        max_length_two = Math.max(max_length_two, current_two);
    }
    return Math.max(max_length_one, max_length_two);
};

