import sys

input = sys.stdin.readline

n = int(input())

target = []

for i in range(n):
    target.append(int(input()))

target.sort()
answer = 0
for i in range(n):
    answer += abs(target[i] - (i+1))
print(answer)
