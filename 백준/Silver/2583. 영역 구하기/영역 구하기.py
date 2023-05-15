from collections import deque

m,n,k = map(int,input().split())

rec = []

for i in range(k):
    temp = list(map(int,input().split()))
    rec.append(temp)
cnt = 0
area = []
diag = [[0 for _ in range(n)] for _ in range(m)]
dir = [
    [1,0],
    [0,1],
    [-1,0],
    [0,-1]
]
for case in rec:
    for j in range(case[0], case[2]):
        for i in range(case[1], case[3]):
            diag[i][j] = 1

def bfs(i,j):
    qq = deque()
    answer = 1
    qq.append([i,j])
    diag[i][j] = 1

    while qq:
        x,y = qq.popleft()

        for k in dir:
            nx,ny = x + k[0], y + k[1]
            if 0<=nx<m and 0<= ny < n and diag[nx][ny] == 0:
                qq.append([nx,ny])
                diag[nx][ny] = 1
                answer += 1

    return answer

for i in range(m):
    for j in range(n):
        if diag[i][j] == 0:
            result = bfs(i,j)
            area.append(result)
            cnt +=1

print(cnt)
area.sort()
print(' '.join(map(str,area)))
