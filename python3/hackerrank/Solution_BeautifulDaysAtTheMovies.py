def beautifulDays(i, j, k):
    return len([i for i in range(i, j + 1, 1) if abs(i - int(str(i)[::-1])) % k == 0])

assert 2 == beautifulDays(20, 23, 6)