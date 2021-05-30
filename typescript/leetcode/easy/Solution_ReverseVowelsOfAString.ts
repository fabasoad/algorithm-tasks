{
  // https://leetcode.com/problems/reverse-vowels-of-a-string/
  function reverseVowels(s: string): string {
    if (s === null || s.length === 0) {
      return s;
    }
    const vowels: string[] = ['a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'];
    let left: number = 0;
    let right: number = s.length - 1;
    let leftResult: string = '';
    let rightResult: string = '';
    while (left <= right) {
      const lc: string = s.charAt(left);
      const rc: string = s.charAt(right);
      if (!vowels.includes(lc)) {
        leftResult += lc;
        left++;
        continue;
      }
      if (!vowels.includes(rc)) {
        rightResult = rc + rightResult;
        right--;
        continue;
      }

      leftResult += rc;
      if (left !== right) {
        rightResult = lc + rightResult;
      }

      left++;
      right--;
    }
    return leftResult + rightResult;
  }

  const res: string = reverseVowels('aA');
  console.log(res);
}
