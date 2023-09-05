import sys
from collections import deque

input = sys.stdin.readline

n,q = map(int,input().split())

link = [[] for i in range(n+1)]

for _ in range (n-1):
    a,b,c = map(int,input().split())
    link[a].append([b,c])
    link[b].append([a,c])

for _ in range(q):
    thres, target = map(int,input().split())
    v = [False for _ in range(n+1)]
    qq = deque()
    v[target] = True
    qq.append(target)
    answer = 0
    while qq:
        cur = qq.popleft()
        for adj in link[cur]:
            if adj[1] >= thres and v[adj[0]] == False:
                v[adj[0]] = True
                answer += 1
                qq.append(adj[0])
    print(answer)