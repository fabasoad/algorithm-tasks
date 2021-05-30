{
  // https://leetcode.com/problems/roman-to-integer
  const fortiesMap: Map<string, string> = new Map<string, string>();
  fortiesMap.set('D', 'C');
  fortiesMap.set('M', 'C');
  fortiesMap.set('L', 'X');
  fortiesMap.set('C', 'X');
  fortiesMap.set('V', 'I');
  fortiesMap.set('X', 'I');
  const map: Map<string, number> = new Map<string, number>();
  map.set('I', 1);
  map.set('V', 5);
  map.set('X', 10);
  map.set('L', 50);
  map.set('C', 100);
  map.set('D', 500);
  map.set('M', 1000);
  map.set('IV', 4);
  map.set('IX', 9);
  map.set('XL', 40);
  map.set('XC', 90);
  map.set('CD', 400);
  map.set('CM', 900);

  function romanToInt(s: string): number {
    let sum: number = 0;
    for (let i = s.length - 1; i >= 0; i--) {
      let k: string;
      if (fortiesMap.has(s[i]) && i - 1 >= 0 && fortiesMap.get(s[i]) === s[i - 1]) {
        k = s.substr(i - 1, 2);
        i--;
      } else {
        k = s[i];
      }
      sum += map.get(k) || 0;
    }
    return sum;
  }

  const res: number = romanToInt('MCMXCIV');
  console.log(res);
}
