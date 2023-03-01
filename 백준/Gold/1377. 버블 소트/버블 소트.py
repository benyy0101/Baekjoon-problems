import sys
input = sys.stdin.readline

n = int(input())
target = []

for i in range(n):
  target.append([int(input()),i])

target.sort()

max = 0

for i in range(n):
  if max < target[i][1] - i:
    max = target[i][1] - i

print(max + 1)
