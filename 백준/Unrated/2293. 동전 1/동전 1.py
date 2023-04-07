n,k = map(int,input().split())

values = []

for _ in range(n):
  values.append(int(input()))

dp = [0]* (k+1)

dp[0] = 1

for i in values:
  for j in range(k+1):
    if j - i >= 0:
      dp[j] += dp[j-i]

print(dp[-1])

