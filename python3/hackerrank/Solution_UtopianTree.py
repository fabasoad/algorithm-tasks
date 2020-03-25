# https://www.hackerrank.com/challenges/utopian-tree/problem
def utopianTree(n):
    result = 0
    index = 0
    while index <= n:
        if index % 2 == 0:
            result += 1
        else:
            result *= 2
        index += 1
    return result

assert 1 == utopianTree(0)
assert 2 == utopianTree(1)
assert 7 == utopianTree(4)