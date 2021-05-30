{
// https://leetcode.com/problems/most-common-word/
  function mostCommonWord(paragraph: string, banned: string[]): string {
    const map: Map<string, number> = new Map<string, number>();
    const words: string[] = paragraph.match(/[a-zA-Z0-9]+/g) as Array<string>;
    let max: number = 0;
    let maxWord: string = '';
    for (let i = 0; i < words.length; i++) {
      const w: string = words[i].toLowerCase();
      if (!banned.includes(w)) {
        const val: number = (map.get(w) || 0) + 1;
        map.set(w, val);
        if (val > max) {
          max = val;
          maxWord = w;
        }
      }
    }
    return maxWord;
  }

  const res: string = mostCommonWord('Bob hit a ball, the hit BALL flew far after it was hit.', ['hit']);
  console.log(res);
}
