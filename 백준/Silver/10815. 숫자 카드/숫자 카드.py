n = int(input())
cards = list(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))
cards.sort()
result = []
for target in targets:
  flag = 0
  start = 0
  end = len(cards) - 1

  while start <= end:
    mid = (start + end) // 2
    if cards[mid] > target:
      end = mid - 1
    elif cards[mid] < target:
      start = mid + 1
    else:
      result.append(1)
      flag = 1
      break

  if flag == 0:
    result.append(0)


print(' '.join(map(str,result)))    