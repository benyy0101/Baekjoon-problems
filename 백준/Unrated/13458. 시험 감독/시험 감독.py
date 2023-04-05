n = int(input())

target = list(map(int,input().split()))

k = list(map(int,input().split()))
mm = [0 for _ in range(max(target)+1)]
for i in range(1,k[0]+1):
  mm[i] = 1
temp = 0
idx = 2
for i in range(k[0]+1,len(mm)):
  mm[i] += idx
  temp += 1
  if temp == k[1]:
    temp = 0
    idx += 1
answer = 0
for i in target:
  answer += mm[i]

print(answer)
