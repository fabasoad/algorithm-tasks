{
  function sortedSquares(nums: number[]): number[] {
    let index: number = -1;
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        index = i;
        break;
      }
    }
    const result: number[] = [];
    if (index == -1) {
      for (let i = nums.length - 1; i >= 0; i--) {
        result[result.length] = Math.pow(nums[i], 2);
      }
    } else {
      let left: number = index - 1;
      let right: number = index;
      while (left >= 0 && right < nums.length) {
        let left_sqr: number = Math.pow(nums[left], 2);
        let right_sqr: number = Math.pow(nums[right], 2);
        if (left_sqr < right_sqr) {
          left--;
          result[result.length] = left_sqr;
        } else {
          right++;
          result[result.length] = right_sqr;
        }
      }
      if (left >= 0) {
        for (let i = left; i >= 0; i--) {
          result[result.length] = Math.pow(nums[i], 2);
        }
      }
      if (right < nums.length) {
        for (let i = right; i < nums.length; i++) {
          result[result.length] = Math.pow(nums[i], 2);
        }
      }
    }
    return result;
  }

  console.log(sortedSquares([-4,-1,0,3,10]));
  console.log(sortedSquares([-4,-3,-2,-1]));
}
