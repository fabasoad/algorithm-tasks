function checkCell(path: Set<string>, n: number[], matrix: number[][], i: number, j: number): void {
	if (matrix[i][j] === 1 && !path.has(`${i}_${j}`)) {
		path.add(`${i}_${j}`);
		n[0] = n[0] + 1;
		if (i + 1 < matrix.length) {
			checkCell(path, n, matrix, i + 1, j);
		}
		if (j + 1 < matrix[i].length) {
			checkCell(path, n, matrix, i, j + 1);
		}
		if (i - 1 >= 0) {
			checkCell(path, n, matrix, i - 1, j);
		}
		if (j - 1 >= 0) {
			checkCell(path, n, matrix, i, j - 1);
		}
	}
}

export function riverSizes(matrix: number[][]): number[] {
	let result: number[] = [];
	let path: Set<string> = new Set<string>();
	let x: number[] = [0];
  for (let i = 0; i < matrix.length; i++) {
		for (let j = 0; j < matrix[i].length; j++) {
			if ((i === 0 || matrix[i - 1][j] !== 1) && (j === 0 || matrix[i][j - 1] !== 1)) {
				checkCell(path, x, matrix, i, j);
				if (x[0] !== 0) {
					result.push(x[0]);
					x[0] = 0;
				}
			}
		}
	}
	return result;
}

const m: number[][] = [
	[1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0],
	[1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0],
	[0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1],
	[1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0],
	[1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1]
];
const actual: number[] = riverSizes(m);
const expected: number[] = [ 2, 1, 21, 5, 2, 1 ];
console.log(arrayEquals(actual, expected));

function arrayEquals(a: number[], b: number[]): boolean {
	if (a.length !== b.length) {
		return false;
	}
	const a1: number[] = a.sort();
	const b1: number[] = b.sort();
	for (let i = 0; i < a1.length; i++) {
		if (a1[i] !== b1[i]) {
			return false;
		}
	}
	return true;
}