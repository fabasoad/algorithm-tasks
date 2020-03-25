# https://www.hackerrank.com/challenges/electronics-shop/problem
def getMoneySpent(keyboards, drives, b):
    res = -1
    for k in keyboards:
        for d in drives:
            sum = k + d
            if sum <= b and sum > res:
                res = sum
    return res

res = getMoneySpent([3, 1], [5, 2, 8], 10)
assert 9 == res
res = getMoneySpent([4], [5], 5)
assert -1 == res
print('All good!')