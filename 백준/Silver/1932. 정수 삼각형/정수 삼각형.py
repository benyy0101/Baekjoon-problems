n = int(input())
triangle = []

for i in range(n):
    triangle.append(list(map(int, input().split())))

dp = []
for i in range(n):
    dp.append([0 for _ in range(len(triangle[i]))])

dp[0][0] = triangle[0][0]
for i in range(1, n):
    for j in range(len(triangle[i]) - 1):
        if j == 0:
            dp[i][0] = dp[i - 1][0] + triangle[i][0]
        else:
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
    dp[i][-1] = dp[i-1][-1] + triangle[i][-1]

print(max(dp[-1]))



