import sys
read = sys.stdin.readline

songs = list(map(int, read().split()))

S = songs[0]

songs = songs[1:]

dp = [[[[-1 for _ in range(S+1)] for _ in range(S+1)] for _ in range(S+1)] for _ in range(S+1)]

def dfs(num, a,b,c):
    if S<0 or a<0 or b<0 or c<0:
        return 0
    if num == 0 and a == 0 and b == 0 and c == 0:
        return 1
    if num == 0:
        return 0
    temp = dp[num][a][b][c]
    if temp != -1:
        return temp

    temp = 0
    temp += dfs(num-1, a-1, b, c)
    temp += dfs(num-1, a, b-1, c)
    temp += dfs(num-1, a, b, c-1)
    temp += dfs(num-1, a-1, b-1, c)
    temp += dfs(num-1, a-1, b, c-1)
    temp += dfs(num-1, a, b-1, c-1)
    temp += dfs(num-1, a-1, b-1, c-1)
    temp %= 1000000007

    dp[num][a][b][c] = temp
    return temp


print(dfs(S, songs[0], songs[1], songs[2]))