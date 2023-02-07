n = int(input())

elem = list(map(int,input().split()))

target = int(input())
answer = 0
end = len(elem) - 1
start = 0
elem.sort()

while start < end:
  temp = elem[start] + elem[end]
  if temp > target:
    end -= 1
  elif temp < target:
    start += 1
  else:
    answer += 1
    start += 1
    end -= 1

print(answer)
    