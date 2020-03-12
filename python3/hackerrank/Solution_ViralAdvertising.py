import math

def viralAdvertising(n):
    index = 0
    people = 5
    result = 0
    while index < n:
        liked = math.floor(people / 2)
        people = liked * 3
        result += liked
        index += 1
    return result

assert 9 == viralAdvertising(3)