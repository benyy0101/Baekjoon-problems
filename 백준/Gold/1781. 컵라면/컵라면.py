import heapq
import sys
input = sys.stdin.readline
n = int(input())
data = []
for i in range(n):
  data.append(list(map(int,input().split())))
data.sort()
qq = []

for case in data:
  heapq.heappush(qq,case[1])

  if case[0] < len(qq):
    heapq.heappop(qq)

print(sum(qq))