from collections import deque
import sys
input = sys.stdin.readline
n,m = map(int,input().split())

diag = []

for i in range(n):
    temp = list(map(int,input().split()))
    diag.append(temp)
answer = 0
v = [[0 for _ in range(m)] for _ in range(n)]
direction = [
        [1, 0],
        [0, 1],
        [0, -1],
        [-1, 0]
    ]
def bfs(i, j, v):
    qq = deque()
    qq.append([i, j])

    v[i][j] = 1
    while qq:
        x, y = qq.popleft()

        for k in direction:
            nx, ny = x + k[0], y + k[1]
            if 0 <= nx < n and 0 <= ny < m and diag[nx][ny] != 0 and v[nx][ny] == 0:
                qq.append([nx, ny])
                v[nx][ny] = 1

    return True

while True:
    v = [[0 for _ in range(m)] for _ in range(n)]
    if v == diag:
        print(0)
        exit()
    cnt = 0
    for i in range(n):
        for j in range(m):
            if diag[i][j] != 0 and v[i][j] == 0:
                bfs(i,j,v)
                cnt += 1
    if cnt >= 2:
        break
    else:
        answer += 1

        for i in range(n):
            for j in range(m):
                for k in direction:
                    dx,dy = i + k[0], j + k[1]
                    if 0<=dx<n and 0<=dy<m and diag[dx][dy] == 0 and diag[i][j] > 0 and v[dx][dy] == 0:
                        diag[i][j] -= 1


print(answer)
