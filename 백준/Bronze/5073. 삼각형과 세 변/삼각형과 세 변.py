while True:
  a,b,c = map(int,input().split())
  if a == b and  b == c and a == 0:
    break
  longest = max(a,b,c)
  if (a + b + c - longest*2 <= 0):
    print('Invalid')
    continue
  if a == b and b == c:
    print('Equilateral')
  elif a == b or a == c or b == c:
    print('Isosceles')
  else:
    print('Scalene')