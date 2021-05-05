{
  function findDisappearedNumbers(nums: number[]): number[] {
    const map = new Map([...Array(nums.length).keys()].map(k => [k + 1, 0]));
    for (const num of nums) {
      map.delete(num);
    }
    return [...map.keys()];
  }

  console.log(findDisappearedNumbers([4,3,2,7,8,2,3,1]));
}
