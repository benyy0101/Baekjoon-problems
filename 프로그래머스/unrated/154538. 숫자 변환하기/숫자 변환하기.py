from collections import deque
from collections import defaultdict

def solution(x, y, n):
    answer = []
    qq = deque()
    qq.append([x,0])
    visited = defaultdict(int)
    while qq:
        num,trial = qq.popleft()
        
        if num != y and visited[num] == 1:
            continue
        else:
            visited[num] = 1
            
        if num == y:
            answer.append(trial)
        else:
            if (num + n) <= y:
                qq.append([num + n, trial + 1])
            if (num * 2) <= y:
                qq.append([num * 2, trial + 1])
            if (num * 3) <= y:
                qq.append([num * 3, trial + 1])
        
    if answer:
        return min(answer)
    else:
        return -1
