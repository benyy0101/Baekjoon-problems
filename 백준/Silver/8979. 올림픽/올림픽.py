n,m = map(int,input().split())

target = [] 

for i in range(n):
  temp = list(map(int,input().split()))

  target.append(temp)

target.sort(key = lambda x: (x[1],x[2],x[3]), reverse = True)

idx = [target[i][0] for i in range(n)].index(m)

for i in range(len(target)):
  if target[idx][1:] == target[i][1:]:
    print(i+1)
    break
