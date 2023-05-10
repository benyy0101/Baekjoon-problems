max_val = -1
max_x = 0
max_y = 0

for i in range(9):
  temp = list(map(int,input().split()))

  for j in range(len(temp)):
    if temp[j] >= max_val:
      max_val = temp[j]
      max_x = i
      max_y = j

print(max_val)
print(max_x + 1, max_y + 1)
