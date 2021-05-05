{
  function lengthOfLastWord(s: string): number {
    const s1: string = s.trim();
    return s1.length === 0 ? 0 : s1.slice(s1.lastIndexOf(' ') + 1).length;
  }

  console.log(lengthOfLastWord(' '));
}
