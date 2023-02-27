length = int(input())

target = []

for i in range(length):
  temp = int(input())
  target.append(temp)
  
flag = True
stk = []
idx = 0
result = []

for i in target:
  while idx < i:
    idx += 1
    stk.append(idx)
    result.append("+")
    
  if stk[-1] == i:
    stk.pop()
    result.append("-")
  else:
    flag = False
    break
    
if flag:
  print('\n'.join(map(str,result)))
else:
  print("NO")
    
