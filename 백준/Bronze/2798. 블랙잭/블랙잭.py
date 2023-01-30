import itertools 

n,m = map(int,input().split())

cards = list(map(int,input().split()))
cards.sort()

permutation = itertools.permutations(cards,3)
record = 0
for i in permutation:
  temp = sum(i)
  if temp <= m and record < temp:
    record = temp

print(record)