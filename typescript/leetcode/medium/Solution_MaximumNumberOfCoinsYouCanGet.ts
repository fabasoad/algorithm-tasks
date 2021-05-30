{
  // https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
  function maxCoins(piles: number[]): number {
    piles.sort((a: number, b: number): number => a-  b);
    let sum: number = 0;
    const start: number = piles.length / 3;
    for (let i = start; i < piles.length; i += 2) {
      sum += piles[i];
    }
    return sum;
  }

  console.log(maxCoins([2,4,1,2,7,8]));
  console.log(maxCoins([2,4,5]));
  console.log(maxCoins([9,8,7,6,5,1,2,3,4]));
  console.log(maxCoins([7,5,7,7,8,8,5,10,7]));
  console.log(maxCoins([9,5,6,8,10,1,4,10,7]));
}
