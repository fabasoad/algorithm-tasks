# https://www.hackerrank.com/challenges/picking-numbers/problem
def pickingNumbers(a):
    a.sort()
    max_num = 0
    big_index = 0
    small_index = 0
    counter = 0
    while big_index < len(a):
        if small_index < len(a) and a[small_index] - a[big_index] <= 1:
            counter += 1
            small_index += 1
            continue
        
        max_num = max_num if max_num > counter else counter
        counter = 0
        big_index += 1
        small_index = big_index
    return max_num

assert 5 == pickingNumbers([ 1, 2, 2, 3, 1, 2 ])
assert 3 == pickingNumbers([ 4, 6, 5, 3, 3, 1 ])