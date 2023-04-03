def solution(n):
    answer = []
    posts = [[0] * n for _ in range(n)]
    num = 1
    directions = [
        [1,0],
        [0,1],
        [-1,-1]
    ]
    position = [-1,0]
    token = 0
    for i in range(n,0,-1):
        for j in range(i):
            dx,dy = directions[token]
            position = [position[0] + dx, position[1] + dy]
            x,y = position
            posts[x][y] = num
            num += 1
            
            
        token += 1
        token %= 3
        
    for i in posts:
        for j in i:
            if j != 0:
                answer.append(j)
    return answer