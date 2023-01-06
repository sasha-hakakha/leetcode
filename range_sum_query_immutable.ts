//303
class NumArray {
    prefix: number[];
    constructor(nums: number[]) {
        this.prefix = new Array(nums.length);
        for (let i = 0; i < nums.length; i++){
            if (i == 0){
                this.prefix[i] = nums[i];
            }
            else{
                this.prefix[i] = nums[i] + this.prefix[i-1];
            }

        }

    }

    sumRange(left: number, right: number): number {
        if(left == 0) return this.prefix[right];
        return this.prefix[right] - this.prefix[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */