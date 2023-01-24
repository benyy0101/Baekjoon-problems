answer = []
for _ in range(int(input())):
  target = list(input().split())
  result = ''

  for i in target:
    result += (i[::-1]+' ')

  result = result.rstrip(result[-1])
  answer.append(result)

print('\n'.join(answer))