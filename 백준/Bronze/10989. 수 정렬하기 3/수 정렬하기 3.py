import sys

n = int(sys.stdin.readline())

map = [0] * 10001

for i in range(n):
  temp = int(sys.stdin.readline())
  map[temp] += 1

for idx in range(10001):
  if map[idx] !=0:
    for _ in range(map[idx]):
      print(idx)