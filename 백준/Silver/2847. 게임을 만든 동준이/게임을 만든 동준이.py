n = int(input())

games = []

for i in range(n):
    games.append(int(input()))

games.reverse()
cnt = 0
for i in range(len(games) - 1):
    while games[i] <= games[i + 1]:
        games[i + 1] -= 1
        cnt += 1

print(cnt)
