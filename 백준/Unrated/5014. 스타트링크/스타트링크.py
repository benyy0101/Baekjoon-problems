from collections import deque

building,start,goal,up,down = map(int,input().split())

v = [False] * (building+1)

qq = []
qq.append([start,0])
answer = -1

while qq:
    stair, depth = qq.pop(0)
    
    if v[stair] == True:
        continue
    v[stair] = True

    if stair == goal:
        answer = depth
    if up+stair <= building:
        qq.append([up+stair, depth+1])
    if stair-down >0:
        qq.append([stair-down, depth+1])

if answer == -1:
    print("use the stairs")
else:
    print(answer)







