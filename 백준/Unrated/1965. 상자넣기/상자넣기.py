n = int(input())
k = list(map(int,input().split()))

v = [1 for _ in range(n)]

for i in range(1,n):
    for j in range(i):
        if k[i] > k[j]:
            v[i] = max(v[i], v[j]+1)

print(max(v))