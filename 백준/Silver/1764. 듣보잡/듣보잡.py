import sys

a, b = map(int,sys.stdin.readline().split())
dd = set()
ff = set()
for i in range(a):
  dd.add(sys.stdin.readline().rstrip('\n'))

for j in range(b):
  ff.add(sys.stdin.readline().rstrip('\n'))

temp = []

for i in dd:
  if i in ff:
    temp.append(i)
temp.sort()
print(len(temp))
print('\n'.join(temp))