/* TODO: Didn't solve */
/* https://leetcode.com/problems/reorganize-string/ */
function reorganizeString(S: string): string {
  const map: Map<string, number> = new Map<string, number>();
  for (let i = 0; i < S.length; i++) {
    const c: string = S.charAt(i);
    map.set(c, (map.get(c) || 0) + 1);
  }
  const maxLength: number = Math.max(...map.values());
  if (maxLength > Math.ceil(S.length / 2)) {
    return '';
  }
  let S_arr: string[] = [...S];
  let R_arr: string[] = new Array<string>(S_arr.length);
  let R_i: number = 0;
  let S_i: number = 0;
  while (S_arr.length > 0) {
    if (R_arr[R_i] === undefined) {
      if (R_i - 1 >= 0 ) {
        if (R_arr[R_i - 1] !== S_arr[S_i]) {
          R_arr[R_i] = S_arr[S_i];
          S_arr.splice(S_i, 1);
          S_i = 0;
          R_i++;
        } else {
          S_i++;
        }
      } else {
        R_arr[R_i] = S_arr[S_i];
        S_arr.splice(S_i, 1);
        S_i = 0;
        R_i++;
      }
    } else {
      R_i++;
    }
  }
  return R_arr.join('');
};

{
  let res: string = reorganizeString('baaba');
  console.log(res);
}