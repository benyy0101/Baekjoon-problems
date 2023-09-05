import sys
input = sys.stdin.readline

n,m = map(int,input().split())

mapp = []
clouds = set()

clouds.add((n-1,0))
clouds.add((n-2,0))
clouds.add((n-1,1))
clouds.add((n-2,1))

for _ in range(n):
    mapp.append(list(map(int,input().split())))

moves = []

for _ in range(m):
    moves.append(list(map(int,input().split())))

direction = [
    [0,0],
    [0,-1],
    [-1,-1],
    [-1,0],
    [-1,1],
    [0,1],
    [1,1],
    [1,0],
    [1,-1]
]
diagDirection = [
    [1,1],
    [1,-1],
    [-1,1],
    [-1,-1]
]

for move in moves:
    dir = move[0]
    co = move[1]
    dx = direction[dir][0] * co
    dy = direction[dir][1] * co
    tempCloud = set()
    for cloud in clouds:
        x = (cloud[0] + dx) % n
        y = (cloud[1] + dy) % n
        mapp[x][y] += 1
        tempCloud.add((x,y))
    clouds = tempCloud
    for cloud in clouds:
        x = cloud[0]
        y = cloud[1]
        temp = 0
        for i in range(4):
            nx = x + diagDirection[i][0]
            ny = y + diagDirection[i][1]
            if nx >= n or nx < 0 or ny >= n or ny < 0 or mapp[nx][ny] == 0: continue
            temp += 1
        mapp[x][y] += temp
    newClouds = set()
    for i in range(n):
        for j in range(n):
            if (i,j) not in clouds and mapp[i][j] >= 2:
                newClouds.add((i,j))
                mapp[i][j] -= 2
    clouds = newClouds

answer = 0
for i in range(n):
    for j in range(n):
        answer += mapp[i][j]

print(answer)