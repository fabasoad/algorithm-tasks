def permutationEquation(p):
    calc = lambda a: [p.index(x) + 1 for x in a]
    return [el for el in calc(calc(range(1, len(p) + 1)))]

assert [1, 3, 5, 4, 2] == permutationEquation([4, 3, 5, 1, 2])