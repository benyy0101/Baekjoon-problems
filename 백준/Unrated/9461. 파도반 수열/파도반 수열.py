n = int(input())
ks = []
for _ in range(n):
  ks.append(int(input()))

dp = [0] * (max(ks)+1)

dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2

for i in range(6, len(dp)):
  dp[i] = dp[i-1] + dp[i-5]

for i in ks:
  print(dp[i])

