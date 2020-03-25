# https://www.hackerrank.com/challenges/the-hurdle-race/problem
def hurdleRace(k, height):
    a = max(height) - k
    return a if a > 0 else 0