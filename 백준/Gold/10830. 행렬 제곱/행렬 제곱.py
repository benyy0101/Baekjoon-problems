from sys import stdin

input = stdin.readline
a, b = map(int, input().split())
matrix = [list(map(lambda x: x % 1000, map(int, input().split()))) for _ in range(a)]

def power(m, y):
    if y == 1:
        return m
    partial = power(m, y // 2)
    partial_square = multiply_matrix(partial, partial)
    if y % 2 == 0:
        return partial_square
    elif y % 2 == 1:
        return multiply_matrix(partial_square, m)


def multiply_matrix(matrix_1, matrix_2):
    length = len(matrix_1)
    result = [[0 for _ in range(length)] for _ in range(length)]
    for i in range(length):
        for j in range(length):
            result[i][j] = sum([(matrix_1[i][k] * matrix_2[k][j])%1000 for k in range(length)])%1000
    return result

answer = power(matrix, b)
for i in range(a):
    print(' '.join(map(str, answer[i])))