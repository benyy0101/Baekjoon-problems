answer = []

while 1:
  stack = []
  target = input()
  flag = 0
  
  if target == '.':
    break
  
  for i in target:
    if i =="(":
      stack.append('(')
    elif i == "[":
      stack.append('[')
      
    elif i == ")":
      if len(stack) != 0 and stack[-1] == "(":
        stack.pop()
      else:
        flag = 1
        break

    elif i == "]":
      if len(stack) !=0 and stack[-1] == "[":
        stack.pop()
      else:
        flag = 1
        break

  if flag == 0 and len(stack) == 0:
    answer.append('yes')
  else:
    answer.append('no')

print('\n'.join(answer))