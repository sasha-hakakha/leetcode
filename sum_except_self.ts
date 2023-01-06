function productExceptSelf(nums: number[]): number[] {
    var from_left = Array(nums.length);
    var from_right = Array(nums.length);
    var result = Array(nums.length);
    
    from_left[0] = nums[0];
    for(var i = 1; i < nums.length; i++){
        from_left[i] = nums[i] * from_left[i-1];
    }
    
    from_right[nums.length - 1] = nums[nums.length - 1];
    for(var i = nums.length - 2; i >= 0; i--){
        from_right[i] = nums[i] * from_right[i+1];
    }
    
    result[0] = from_right[1];
    result[nums.length - 1] = from_left[nums.length - 2];
    for(var i = 1; i < nums.length - 1; i++){
        result[i] = from_left[i-1] * from_right[i+1];
    }
    return result;
};