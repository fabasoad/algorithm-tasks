function parse(nums1: number[], nums2: number[], i: number, j: number): number {
  let length = 0
  while (i < nums1.length && j < nums2.length && nums1[i] === nums2[j]) {
    length++
    i++
    j++
  }
  return length
}

function findLength(nums1: number[], nums2: number[]): number {
  let max = 0
  for (let i = 0; i < nums1.length; i++) {
    for (let j = 0; j < nums2.length; j++) {
      let newMax = parse(nums1, nums2, i, j)
      if (newMax > max) {
        max = newMax
      }
    }
  }
  return max
}

console.log('3 ->', findLength([1,2,3,2,1], [3,2,1,4,7]))
console.log('2 ->', findLength([0,1,1,1,1], [1,0,1,0,1]))
