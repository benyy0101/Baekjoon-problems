n = int(input())

target = list(map(int,input().split()))

m = int(input())

relation = []
v = [False] * (n+1)
graph = [[]for _ in range(n+1)]
result = []
answer  = -1
for _ in range(m):
    x,y = map(int,input().split())

    graph[x].append(y)
    graph[y].append(x)

def dfs(node, depth):
    global answer
    v[node] = True
    if node == target[1]:
        answer = depth
    for i in graph[node]:
        if v[i] == False:
            dfs(i,depth+1)

dfs(target[0],0)
print(answer)


