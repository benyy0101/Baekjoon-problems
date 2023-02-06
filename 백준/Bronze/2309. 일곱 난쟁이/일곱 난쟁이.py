dwarfs = []
total = 0

for _ in range(9):
  temp = int(input())
  dwarfs.append(temp)
  total += temp

for i in range(len(dwarfs)-1):
  for j in range(i+1,len(dwarfs)):
    if (dwarfs[i] + dwarfs[j] + 100) == total:
      one = dwarfs[i]
      two = dwarfs[j]

dwarfs.remove(one)
dwarfs.remove(two)

print('\n'.join(map(str, sorted(dwarfs))))



