n = int(input())

works = []

for _ in range(n):
  works.append(list(map(int,input().split())))

dp = [0] * (n+1)
for i in range(n-1, -1, -1):
  if works[i][0] + i <= n: 
    dp[i] = max(dp[i+1], dp[works[i][0] + i] + works[i][1])
  else:
    dp[i] = dp[i+1]

print(dp[0])