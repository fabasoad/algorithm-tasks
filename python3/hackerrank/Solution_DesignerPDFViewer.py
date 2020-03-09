def designerPdfViewer(h, word):
    return max([h[ord(ch) - ord('a')] for ch in word]) * len(word)

assert 9 == designerPdfViewer([1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5], 'abc')