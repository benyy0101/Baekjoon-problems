chunk = input().split('-')
answer = []

for i in chunk:
  answer.append(sum(list(map(int,i.split('+')))))

result = answer[0]

for i in range(1,len(answer)):
  result -= answer[i]

print(result)