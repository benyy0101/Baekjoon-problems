n,m = map(int,input().split())

target = []

for i in range(n):
  target.append(list(map(int,input().split())))

for i in range(n):
  temp = list(map(int,input().split()))
  for j in range(m):
    target[i][j] += temp[j]

for i in range(len(target)):
  print(" ".join(map(str,target[i])))
    
    