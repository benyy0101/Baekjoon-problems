from collections import defaultdict
n = int(input())

v = defaultdict(int)

v[0] = 1
v[1] = 3

for i in range(2, n+1):
    v[i] = (v[i-1]*2 + v[i-2]) % 9901

print(v[n])