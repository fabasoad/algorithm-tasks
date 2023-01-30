{
  // https://leetcode.com/problems/battleships-in-a-board/description/
  function countBattleships(board: string[][]): number {
    function traverse(b: string[][], i: number, j: number, s: boolean[][], sum: number, boo: boolean): number {
      if (i >= b.length || j >= b[i].length) {
        return sum
      }
      if (s[i][j]) {
        return sum
      }
      s[i][j] = true
      if (b[i][j] === '.') {
        return sum
      }
      if (!boo) {
        sum++
      }
      return Math.max(
          traverse(b, i + 1, j, s, sum, true),
          traverse(b, i, j + 1, s, sum, true)
      )
    }
    // Create empty field
    let saved: boolean[][] = []
    for (let i = 0; i < board.length; i++) {
      saved[i] = Array(board[i].length).fill(false)
    }
    let sum = 0
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[i].length; j++) {
        sum = traverse(board, i, j, saved, sum, false)
      }
    }
    return sum
  }
  let actual: number = countBattleships(
      [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
  )
  console.log('Expected: 2. Actual:', actual)
  actual = countBattleships(
      [["."]]
  )
  console.log('Expected: 0. Actual:', actual)
}