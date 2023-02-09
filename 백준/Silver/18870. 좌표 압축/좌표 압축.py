n = int(input())

temp = list(map(int,input().split()))
answer = []

idx = sorted(list(set(temp)))
target = {idx[i]: i for i in range(len(idx))}

for i in temp:
  print(target[i], end = ' ')
  
