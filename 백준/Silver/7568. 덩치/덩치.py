n = int(input())
people = []

for i in range(n):
  weight, height = map(int,input().split())
  people.append([weight,height])

for person in people:
  rank = 1
  
  for counterpart in people:
    if person[0] < counterpart[0] and person[1] < counterpart[1]:
      rank += 1

  print(rank, end = ' ')
  
