{
  // https://leetcode.com/problems/sorting-the-sentence/
  function sortSentence(s: string): string {
    const words: string[] = s.split(' ');
    const ordered: string[] = new Array<string>(words.length);
    for (let i = 0; i < words.length; i++) {
      let index: number = +words[i].slice(words[i].length - 1);
      ordered[index - 1] = words[i].slice(0, words[i].length - 1);
    }
    return ordered.join(' ');
  }

  console.log(sortSentence('is2 sentence4 This1 a3'));
}
