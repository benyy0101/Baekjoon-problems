from collections import deque

def solution(n, m, section):
    answer = 0
    section = deque(section)
    while section:
        q = section.popleft()
        
        for i in range(1,m):
            if section and (q + i) == section[0]:
                    section.popleft()
        answer += 1
            
    return answer