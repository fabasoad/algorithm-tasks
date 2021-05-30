{
  // https://leetcode.com/problems/arithmetic-subarrays/
  function checkArithmeticSubarrays(nums: number[], l: number[], r: number[]): boolean[] {
    let result: boolean[] = [];
    for (let i = 0; i < l.length; i++) {
      result.push(isArithmetic(nums.slice(l[i], r[i] + 1)));
    }
    return result;
  }

  function isArithmetic(nums: number[]): boolean {
    if (!isArithmeticWithSort(nums, (a: number, b: number): number => a - b)) {
      return isArithmeticWithSort(nums, (a: number, b: number): number => b - a);
    }
    return true;
  }

  function isArithmeticWithSort(nums: number[], compareFn: (a: number, b: number) => number): boolean {
    nums.sort(compareFn);
    const diff: number = nums[1] - nums[0];
    for (let i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] - nums[i] !== diff) {
        return false;
      }
    }
    return true;
  }

  console.log(checkArithmeticSubarrays([4,6,5,9,3,7], [0,0,2], [2,3,5]));
  console.log(checkArithmeticSubarrays([-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], [0,1,6,4,8,7], [4,4,9,7,9,10]));
}
