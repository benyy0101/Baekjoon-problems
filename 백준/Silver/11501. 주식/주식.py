for i in range(int(input())):
  n = int(input())
  prices = list(map(int,input().split()))

  prices.reverse()
  answer = 0
  max_price = prices[0]
  for case in prices:
    if case > max_price:
      max_price = case
      continue

    answer += (max_price - case)

  print(answer)
  
    