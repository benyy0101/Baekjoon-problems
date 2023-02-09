from collections import Counter

n,m = map(int,input().split())

a = list(map(int,input().split()))

b = list(map(int,input().split()))

a_dict = Counter(a)
b_dict = Counter(b)

answer = 0

for i in a_dict:
  if i not in b_dict.keys():
    answer += 1

for i in b_dict:
  if i not in a_dict.keys():
    answer += 1

print(answer)


