{
  const map: Map<string, string[]> = new Map<string, string[]>([
      ['2', ['a', 'b', 'c']],
      ['3', ['d', 'e', 'f']],
      ['4', ['g', 'h', 'i']],
      ['5', ['j', 'k', 'l']],
      ['6', ['m', 'n', 'o']],
      ['7', ['p', 'q', 'r', 's']],
      ['8', ['t', 'u', 'v']],
      ['9', ['w', 'x', 'y', 'z']]
  ]);

  function cartesian(args: string[][]) {
    const r: string[][] = [];
    const max = args.length-1;
    function helper(arr: string[], i: number) {
      for (let j=0, l=args[i].length; j<l; j++) {
        const a: string[] = arr.slice(0); // clone arr
        a.push(args[i][j]);
        if (i==max)
          r.push(a);
        else
          helper(a, i+1);
      }
    }
    helper([], 0);
    return r;
  }

  function letterCombinations(digits: string): string[] {
    const args: string[][] = [];
    for (const c of digits) {
      args.push(map.get(c) || []);
    }
    return digits.length === 0 ? [] : cartesian(args).map(a => a.join(''));
  }

  console.log(letterCombinations('23'));
}
