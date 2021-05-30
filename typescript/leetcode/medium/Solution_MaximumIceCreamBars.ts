{
  // https://leetcode.com/problems/maximum-ice-cream-bars/
  function maxIceCream(costs: number[], coins: number): number {
    costs.sort((a, b) => a - b);
    let res: number = 0;
    for (let i = 0; i < costs.length; i++) {
      if (costs[i] <= coins) {
        res += 1;
        coins -= costs[i];
      } else {
        break;
      }
    }
    return res;
  }

  console.log(maxIceCream([1,3,2,4,1], 7));
  console.log(maxIceCream([10,6,8,7,7,8], 5));
}
