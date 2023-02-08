import itertools

n, m = map(int,input().split())
target = []
for i in range(1,n+1):
  target.append(i)
data = list(itertools.permutations(target,m))

for i in data:
  
  print(' '.join(map(str,i)))