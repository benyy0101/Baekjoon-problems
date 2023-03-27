a,b,c = map(int,input().split())

earth = 1
sun = 1
moon = 1

answer = 1

while earth != a or sun != b or moon != c:
  answer += 1
  
  earth += 1
  sun += 1
  moon += 1

  if earth == 16:
    earth = 1
  if sun == 29:
    sun = 1
  if moon == 20:
    moon = 1
print(answer)