import sys
input = sys.stdin.readline

m,n = map(int,input().split())
target = [[0]* (m+1)]
for _ in range(m):
  temp = [0] + [int(x) for x in input().split()]
  target.append(temp)
  
sum_target = [[0]* (m+1) for _ in range(m+1)]

for i in range(1,m+1):
  for j in range(1,m+1):
    sum_target[i][j] = sum_target[i-1][j] + sum_target[i][j-1] - sum_target[i-1][j-1] + target[i][j]


answer = []
for _ in range(n):
  start_x, start_y,end_x, end_y = map(int,input().split())
  result = sum_target[end_x][end_y] - sum_target[start_x-1][end_y] - sum_target[end_x][start_y-1] + sum_target[start_x -1][start_y-1]
  answer.append(result)

print('\n'.join(map(str,answer)))

  




