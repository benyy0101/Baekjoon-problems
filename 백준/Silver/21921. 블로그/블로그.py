n,x = map(int,input().split())

record = list(map(int,input().split()))
cnt = 1


temp = sum(record[:x])
high = temp

for i in range(x,n):
  temp += record[i]
  temp -= record[i-x]
  
  if temp > high:
    high = temp
    cnt = 1
  elif temp == high:
    cnt += 1
if high == 0:
  print('SAD')
else:
  print(high)
  print(cnt)