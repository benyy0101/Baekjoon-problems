import sys

num, num2 = map(int,sys.stdin.readline().split())
line = set()
cnt = 0

for i in range(num):
  line.add(sys.stdin.readline())

temp = []

for i in range(num2):
  temp.append(sys.stdin.readline())  

for i in temp:
  if i in line:
    cnt += 1
print(cnt)
