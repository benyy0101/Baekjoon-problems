from collections import defaultdict
answer = []
for _ in range(int(input())):
  clothes = defaultdict(int)
  for _ in range(int(input())):
    n, m = input().split()
    clothes[m] += 1
  result = 1

  for i in clothes.values():
    result *= (i+1)

  answer.append(result - 1)

print('\n'.join(map(str, answer)))
    
    

  
  