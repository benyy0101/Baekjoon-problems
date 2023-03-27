def solution(park, routes):
    h = len(park)
    w = len(park[0])
    x,y = 0,0
    nav = {
        'S': [1,0],
        'N':[-1,0],
        'W': [0,-1],
        'E':[0,1]
    }
    
    for i in range(h):
        for j in range(w):
            if park[i][j] == "S":
                x = i
                y = j
    
    for route in routes:
        direction, distance = route.split()
        distance = int(distance)
        flag = 0
        step_x = x
        step_y = y
        for i in range(1,distance+1):
            step_x += nav[direction][0]
            step_y += nav[direction][1]
            
            if step_x >= h or step_x <= -1 or step_y >= w or step_y <= -1 or park[step_x][step_y] == 'X':
                flag = 1
                break
            
        if(flag == 0):
            x += nav[direction][0] * distance
            y += nav[direction][1] * distance
    
    answer = [x,y]
    return answer