n = int(input())

graph = []
max_num = 0
for _ in range(n):
    temp = list(map(int, input().split()))
    if max(temp) > max_num:
        max_num = max(temp)
    graph.append(temp)

answer = []
directions = [
    [1,0],
    [-1,0],
    [0,1],
    [0,-1]
]
for i in range(1,max_num+1):
    v = []
    for j in graph:
        temp = []
        for k in j:
            if k < i:
                temp.append(1)
            else:
                temp.append(0)
        v.append(temp)

    qq = []
    nom = 0
    for j in range(n):
        for k in range(n):
            if v[j][k] == 0:
                qq.append([j,k])
                nom += 1
                while qq:
                    x,y = qq.pop(0)
                    if v[x][y] == 1:
                        continue
                    v[x][y] = 1
                    for r in directions:
                        nx, ny = x + r[0], y + r[1]
                        if 0 <= nx < n and 0 <= ny < n:
                            qq.append([nx,ny])
    answer.append(nom)
print(max(answer))