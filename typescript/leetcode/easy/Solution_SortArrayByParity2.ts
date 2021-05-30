{
  // https://leetcode.com/problems/sort-array-by-parity-ii/
  function sortArrayByParityII(nums: number[]): number[] {
    const result: number[] = new Array<number>(nums.length);

    let lastOddIndex: number = 1;
    let lastEvenIndex: number = 0;
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        result[lastEvenIndex] = nums[i];
        lastEvenIndex += 2;
      } else {
        result[lastOddIndex] = nums[i];
        lastOddIndex += 2;
      }
    }
    return result;
  }

  console.log(sortArrayByParityII([4,2,5,7]));
}
