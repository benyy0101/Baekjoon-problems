from collections import defaultdict

n = int(input())
target = defaultdict(int)
for _ in range(n):
  target[int(input())] += 1

answer = sorted(list(target.items()), key = lambda x: (-x[1],x[0]))

print(answer[0][0])
  