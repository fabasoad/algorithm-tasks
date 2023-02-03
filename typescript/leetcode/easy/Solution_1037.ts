{
  function isBoomerang(points: number[][]): boolean {
    function f(x1: number, y1: number, x2: number, y2: number, x3: number, y3: number): boolean {
      const a1 = y2 - y1
      const b1 = x2 - x1
      const a2 = y3 - y1
      const b2 = x3 - x1
      if (a1 === a2 && b1 === b2) {
        return false
      }
      const n1 = a1/ b1
      const n2 = a2/ b2
      if (isNaN(n1)) {
        return isNaN(n2)
      }
      if (isNaN(n2)) {
        return isNaN(n1)
      }
      if (!isFinite(n1)) {
        return isFinite(n2)
      }
      if (!isFinite(n2)) {
        return isFinite(n1)
      }
      return n1 !== n2
    }
    return f(points[0][0], points[0][1], points[1][0], points[1][1], points[2][0], points[2][1])
  }
  let actual: boolean = false
  actual = isBoomerang([[1,1],[2,3],[3,2]])
  console.log('Expected: true. Actual:', actual)
  actual = isBoomerang([[1,1],[2,2],[3,3]])
  console.log('Expected: false. Actual:', actual)
  actual = isBoomerang([[1,1],[2,3],[3,2]])
  console.log('Expected: true. Actual:', actual)
  actual = isBoomerang([[0,1],[0,1],[2,1]])
  console.log('Expected: false. Actual:', actual)
  actual = isBoomerang([[1,0],[1,0],[1,0]])
  console.log('Expected: false. Actual:', actual)
  actual = isBoomerang([[73,31],[73,19],[73,45]])
  console.log('Expected: false. Actual:', actual)
}