n = int(input())

vertex = list(map(int,input().split()))

node = list(map(int,input().split()))
cur = 0
answer = 0
for i in range(1,len(node)):
  length = 0
  if node[cur] > node[i]:
    for j in range(cur, i):
      length += vertex[j]
    answer += (length * node[cur])
    cur = i

  if i == len(node) - 1 and i != cur:
    for j in range(cur, i):
      length += vertex[j]
    answer += (length * node[cur])
print(answer)