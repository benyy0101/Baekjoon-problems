n = int(input())
m = int(input())

target = list(map(int,input().split()))

target.sort()

end = n - 1
start = 0
count = 0

while start < end:
  temp = target[start] + target[end]

  if temp == m:
    count += 1
    start += 1
    end -=1

  elif temp > m:
    end -= 1
  elif temp < m:
    start += 1
    
print(count)
  