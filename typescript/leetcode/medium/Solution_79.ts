function traverse(board: string[][], word: string, visited: boolean[][], x: number, y: number, i: number): boolean {
  if (word.length === i) {
    return true;
  }
  if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || visited[x][y]) {
    return false;
  }
  visited[x][y] = true;
  if (board[x][y] === word.charAt(i)) {
    if (word.length - 1 == i) {
      return true;
    }
    let a: boolean = traverse(board, word, visited, x + 1, y, i + 1);
    let b: boolean = traverse(board, word, visited, x - 1, y, i + 1);
    let c: boolean = traverse(board, word, visited, x, y + 1, i + 1);
    let d: boolean = traverse(board, word, visited, x, y - 1, i + 1);
    return a || b || c || d;
  }
  return false;
}

function exist(board: string[][], word: string): boolean {
  // Main algorithm
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      // Fill visited
      const visited: boolean[][] = []
      for (let i = 0; i < board.length; i++) {
        visited.push([]);
        for (let j = 0; j < board[i].length; j++) {
          visited[i].push(false);
        }
      }
      const res: boolean = traverse(board, word, visited, i, j, 0);
      if (res) return true;
    }
  }
  return false;
}

// console.log('true ->', exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
// console.log('true ->', exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
// console.log('false ->', exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))
console.log('true ->', exist([['a','b'],['c','d']], 'cdba'))
