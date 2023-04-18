from collections import deque

n,m = map(int,input().split())
pic = []
for i in range(n):
  temp = list(map(int,input().split()))
  pic.append(temp)
directions = [
  [1,0],
  [0,1],
  [-1,0],
  [0,-1]
]
answer = []

def bfs(x,y):
  qq = deque()
  qq.append([x,y])
  cnt = 0
  while qq:
    a, b = qq.popleft()
    if pic[a][b] == 1:
      pic[a][b] = 0
      cnt += 1
    else:
      continue

    for i in directions:
      nx,ny = a+i[0], b+i[1]

      if nx < 0 or nx >= n or ny <0 or ny >= m:
        continue
      else:
        qq.append([nx,ny])
  return cnt

for i in range(n):
  for j in range(m):
    kk = bfs(i,j)
    if kk !=0:
      answer.append(kk)

print(len(answer))

if len(answer) == 0:
  print(0)
else:
  print(max(answer))
      
        
        
     