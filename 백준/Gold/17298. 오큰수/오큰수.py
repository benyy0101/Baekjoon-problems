n = int(input())
target = list(map(int,input().split()))
stack = [0]
result = [-1] * n

for i in range(len(target)):
  while stack and target[stack[-1]] < target[i]:
    result[stack.pop()] = target[i]
  stack.append(i)
  
print(' '.join(map(str,result)))
  