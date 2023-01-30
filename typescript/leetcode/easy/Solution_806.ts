{
  // https://leetcode.com/problems/number-of-lines-to-write-string
  function numberOfLines(widths: number[], s: string): number[] {
    const DELTA = 97
    const LIMIT = 100
    let pos = 0
    const result: number[] = [0, 0]
    while (pos < s.length) {
      let sum = 0
      let posExceeded = false
      while (sum <= LIMIT) {
        if (pos === s.length) {
          posExceeded = true
          break
        }
        const ind = s.charCodeAt(pos) - DELTA
        if (sum + widths[ind] > LIMIT) {
          break
        }
        sum += widths[ind]
        pos++
      }
      result[0]++
      if (posExceeded) {
        result[1] = sum
      }
    }
    return result
  }
  let actual: number[] = numberOfLines(
      [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10],
      "abcdefghijklmnopqrstuvwxyz"
  )
  console.log('Expected: [ 3, 60 ]. Actual:', actual)
  actual = numberOfLines(
      [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10],
      "bbbcccdddaaa"
  )
  console.log('Expected: [ 2, 4 ]. Actual:', actual)
  actual = numberOfLines(
      [1,10,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,8],
      "abcz"
  )
  console.log('Expected: [ 1, 28 ]. Actual:', actual)
}