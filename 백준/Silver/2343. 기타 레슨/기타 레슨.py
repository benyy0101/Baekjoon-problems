n, m = map(int,input().split())

target = list(map(int,input().split()))

start = end = 0

for i in target:
  if start < i:
    start = i
  end += i

while start <= end:
  middle = (start + end) // 2

  sum = 0
  count = 0

  for i in range(n):
    if sum + target[i] > middle:
      count += 1
      sum = 0
    sum += target[i]

  if sum != 0:
    count += 1

  if count > m:
    start = middle + 1
  else:
    end = middle - 1

print(start)