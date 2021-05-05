{
  function thirdMax(nums: number[]): number {
    const set = new Set(nums);
    const firstMax: number = Math.max(...set.values());
    let max: number = firstMax;
    if (set.size > 2) {
      for (let i = 0; i < 3; i++) {
        max = Math.max(...set.values());
        set.delete(max);
      }
    }
    return max;
  }

  console.log(thirdMax([2,3,2,1,14]));
}
