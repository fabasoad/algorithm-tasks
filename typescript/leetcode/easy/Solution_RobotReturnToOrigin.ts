{
  function check(moves: string, c1: string, c2: string): boolean {
    let c: number = 0
    for (let i = 0; i < moves.length; i++) {
      c += (moves[i] === c1 ? 1 : (moves[i] === c2 ? -1 : 0))
    }
    return c === 0
  }

  function judgeCircle(moves: string): boolean {
    return check(moves, 'U', 'D') && check(moves, 'L', 'R')
  }

  console.log(judgeCircle("UD"))
  console.log(judgeCircle("LL"))
  console.log(judgeCircle("RRDD"))
  console.log(judgeCircle("LDRRLRUULR"))
}
