import sys

nums = int(sys.stdin.readline())

lines = set(map(int,sys.stdin.readline().split()))

num1 = int(sys.stdin.readline())

target = list(map(int,sys.stdin.readline().split()))

for i in target:
  if i in lines:
    print(1)
  else:
    print(0)