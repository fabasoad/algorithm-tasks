// https://leetcode.com/problems/longest-common-prefix/
function longestCommonPrefix(strs: string[]): string {
  if (strs.length === 0) {
    return '';
  }
  strs = strs.sort((a, b) => Math.min(a.length, b.length));
  let prefix: string = strs[0];
  for (let i = 0; i < strs.length;) {
    if (!strs[i].startsWith(prefix)) {
      prefix = prefix.slice(0, prefix.length - 1);
      i = 0
    }
    i++;
  }
  return prefix;
};

{
  const res = longestCommonPrefix(["flower","flow","flight"]);
  console.log(res);
}