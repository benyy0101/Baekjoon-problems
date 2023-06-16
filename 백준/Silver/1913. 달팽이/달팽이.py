n = int(input())
num = int(input())

diag = [[0 for _ in range(n)] for _ in range(n)]

dir = [
    [1,0],
    [0,1],
    [-1,0],
    [0,-1]
]
cnt = n * n
x,y = 0,0
idx = 0
result_x, result_y = 0,0
while cnt > 0:
    diag[x][y] = cnt
    if cnt == num:
        result_x = x
        result_y = y
    cnt -= 1
    if (0 <= x +dir[idx][0] < n and 0 <= y + dir[idx][1] < n and diag[x + dir[idx][0]][y + dir[idx][1]] == 0):
        x += dir[idx][0]
        y += dir[idx][1]

    else:
        idx += 1
        idx %= 4
        x += dir[idx][0]
        y += dir[idx][1]


for k in diag:
    print(' '.join(map(str, k)))
print(result_x + 1, result_y + 1, end=" ")