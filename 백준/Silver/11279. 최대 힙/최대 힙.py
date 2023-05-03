import heapq as hq
import sys 
input = sys.stdin.readline

qq = []
answer = []
n = int(input())

for i in range(n):
  temp = int(input())
  
  if temp != 0:
    hq.heappush(qq, -temp)

  elif qq and temp == 0:
    result = hq.heappop(qq)
    answer.append(-result)

  elif not qq and temp == 0:
    answer.append(0)

print('\n'.join(map(str, answer)))

