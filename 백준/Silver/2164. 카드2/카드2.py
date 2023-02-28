from collections import deque

n = int(input())

temp = [i for i in range(1,n+1)]

target = deque(temp)

while len(target) != 1:
  q = target.popleft()
  qq = target.popleft()
  target.append(qq)

print(target[0])
  