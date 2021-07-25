{
  // Common
  function wordToMap(word: string): Map<string, number> {
    const map: Map<string, number> = new Map<string, number>()
    for (let i = 0; i < word.length; i++) {
      map.set(word[i], (map.get(word[i]) || 0) + 1)
    }
    return map
  }

  // Option 1
  function commonChars1(words: string[]): string[] {
    const maps: Map<string, number>[] = []
    for (let i = 0; i < words.length; i++) {
      maps.push(wordToMap(words[i]))
    }
    const chars: string[] = []
    for (let i = 0; i < words[0].length; i++) {
      let res: number = Math.min(...maps.map(m => m.get(words[0][i]) || 0));
      for (let j = 0; j < maps.length; j++) {
        maps[j].delete(words[0][i])
      }
      for (let j = 0; j < res; j++) {
        chars.push(words[0][i])
      }
    }
    return chars
  }

  // Option 2
  function mergeMap(map1: Map<string, number>, map2: Map<string, number>): Map<string, number> {
    const resMap: Map<string, number> = new Map<string, number>()
    while (map1.size > 0 && map2.size > 0) {
      const key: string = map1.entries().next().value[0]
      let n: number = Math.min(map1.get(key) || 0, map2.get(key) || 0)
      if (n > 0) {
        resMap.set(key, n)
      }
      map1.delete(key)
      map2.delete(key)
    }
    return resMap
  }

  function commonChars2(words: string[]): string[] {
    const maps: Map<string, number>[] = []
    for (let i = 0; i < words.length; i++) {
      maps.push(wordToMap(words[i]))
    }
    const chars: string[] = []
    for (let i = 0; i < maps.length - 1; i++) {
      maps[i + 1] = mergeMap(maps[i], maps[i + 1])
    }
    maps[maps.length - 1].forEach((v, k, m) => {
      for (let i = 0; i < v; i++) {
        chars.push(k)
      }
    })
    return chars
  }

  const commonChars = commonChars2
  console.log(commonChars(["bella","label","roller"]))
  console.log(commonChars(["cool","lock","cook"]))
}
