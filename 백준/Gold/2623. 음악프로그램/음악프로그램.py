import sys
from collections import deque

input = sys.stdin.readline

v,e = map(int,input().split())

inDegree = [0] * (v+1)

graph = [[] for i in range(v+1)]

for _ in range(e):
    temp = list(map(int, input().split()))

    for i in range(len(temp) - 2):
        graph[temp[i+1]].append(temp[i+2])
        inDegree[temp[i+2]] += 1

result = []
qq = deque()

for i in range(1, v + 1):
    if inDegree[i] == 0:
        qq.append(i)

while qq:
    now = qq.popleft()
    result.append(now)
    for i in graph[now]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            qq.append(i)


if len(result) != v:
    print(0)
else:
    for i in result:
        print(i)
