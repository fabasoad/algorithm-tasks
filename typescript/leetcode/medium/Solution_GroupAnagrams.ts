// https://leetcode.com/problems/group-anagrams/
function groupAnagrams(strs: string[]): string[][] {
  const map: Map<string, string[]> = new Map<string, string[]>();
  for (let i = 0; i < strs.length; i++) {
    const w: string = [...strs[i]].sort().join('');
    map.set(w, (map.get(w) || []).concat(strs[i]));
  }
  return [...map.values()]
};
