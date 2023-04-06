n = int(input())

target = [0]

for i in range(n):
  target.append(int(input()))

dp = [0] * (n+1)
dp[1] = target[1]

for i in range(2,len(target)):
  dp[i] = max(dp[i-2], dp[i-3] + target[i-1]) + target[i]

print(dp[-1])
  