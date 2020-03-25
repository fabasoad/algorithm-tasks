// https://www.hackerrank.com/challenges/counting-valleys/problem
function countingValleys(n, s) {
    const op = { 'U': 1, 'D': -1 };
    let step = 0;
    let result = 0;
    [...s].forEach(c => {
        if (step < 0 && step + op[c] === 0) {
            result++;
        }
        step += op[c];
    });
    return result;
}

const result1 = countingValleys(8, 'UDDDUDUU');
const result2 = countingValleys(12, 'DDUUDDUDUUUD');
const result = result1;
console.log(result);
/*
_          /\_
 \  /\    /
  \/  \/\/

*/