{
  function addBinary(a: string, b: string): string {
    function sum(a1: string, b1: string, k: string): string {
      if (a1 === '1' && b1 === '1') {
        return k === '' ? '10' : '11'
      }
      if ((a1 === '1' && b1 === '0') || (a1 === '0' && b1 === '1')) {
        return k === '' ? '1' : '10'
      }
      return k === '' ? '0' : '1'
    }
    // Make same length
    const maxLength = Math.max(a.length, b.length)
    a = a.padStart(maxLength, '0')
    b = b.padStart(maxLength, '0')
    let i = maxLength - 1
    let result = ''
    let k = ''
    while (i >= 0) {
      let sumResult: string = sum(a.charAt(i), b.charAt(i), k)
      if (sumResult.length === 1) {
        result = sumResult + result
        k = ''
      } else {
        result = sumResult.charAt(sumResult.length - 1) + result
        k = sumResult.charAt(0)
      }
      i--
    }
    return k + result
  }
  let actual: string = addBinary('11', '1')
  console.log('Expected: 100. Actual:', actual)
  actual = addBinary('1010', '1011')
  console.log('Expected: 10101. Actual:', actual)
}