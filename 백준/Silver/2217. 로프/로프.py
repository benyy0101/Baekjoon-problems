n = int(input())

ropes = []

for i in range(n):
    ropes.append(int(input()))

ropes.sort(reverse=True)

answer = 0

for i in range(n):
    if (i+1) * ropes[i] > answer:
        answer = (i+1) * ropes[i]

print(answer)