import sys
input = sys.stdin.readline

N = int(input())

balls = [list(map(int,input().split())) + [i] for i in range(N)]
sortedBalls = sorted(balls, key= lambda x:x[1])
total = 0
totalByColor = [0 for _ in range(N+1)]
answer = [0 for _ in range(N+1)]
j = 0
for i in range(N):
    while sortedBalls[j][1] < sortedBalls[i][1]:
        total += sortedBalls[j][1]
        totalByColor[sortedBalls[j][0]] += sortedBalls[j][1]
        j += 1
    answer[sortedBalls[i][2]] = total - totalByColor[sortedBalls[i][0]]
for i in range(N):
    print(answer[i])