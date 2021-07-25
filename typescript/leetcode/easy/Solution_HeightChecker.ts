{
  function sortNLogN(heights: number[]): number[] {
    return [...heights].sort((a, b) => a - b)
  }

  function heightChecker(heights: number[]): number {
    const sort = sortNLogN; // Counting sort improves it with the given constraints
    const sorted: number[] = sort(heights)
    let count: number = 0
    for (let i = 0; i < sorted.length; i++) {
      count += (heights[i] === sorted[i] ? 0 : 1)
    }
    return count
  }

  console.log(heightChecker([1,1,4,2,1,3]))
}
