from collections import deque
def bfs(x,y):
  qq = deque()
  qq.append([x,y])

  while qq:
    xx,yy = qq.popleft()
    
    if xx < 0 or xx >= width or yy < 0 or yy >= length:
      continue
      
    if graph[xx][yy] == 1:
      graph[xx][yy] = 0
      qq.append([xx+1,yy])
      qq.append([xx-1,yy])
      qq.append([xx,yy+1])
      qq.append([xx,yy-1])
      
loop = int(input())
result = []

for _ in range(loop):
  width, length, locations = map(int,input().split())
  graph = []
  count = 0

  for _ in range(width):
    graph.append([0]*length)

  for _ in range(locations):
    x,y = map(int,input().split())
    graph[x][y] = 1

  for x in range(width):
    for y in range(length):
      if graph[x][y] == 1:
        bfs(x,y)
        count += 1

  result.append(count)

print('\n'.join(map(str,result)))