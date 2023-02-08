import itertools

n, m = map(int,input().split())
target = []
for i in range(1,n+1):
  target.append(i)
data = list(itertools.permutations(target,m))
answer = []
for i in data:
  temp = []
  for j in i:
    temp.append(j)
  temp.sort()
  if temp not in answer:
    answer.append(temp)

for i in range(len(answer)):
  print(' '.join(map(str,answer[i])))