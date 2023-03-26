from collections import deque

def solution(s):
    answer = 0
    pivot = 0
    is_x, not_x = 0,0
    
    for i in range(len(s)-1):
        if s[pivot] == s[i]:
            is_x += 1
        else:
            not_x += 1
            
        if is_x == not_x:
            answer += 1
            pivot = i + 1
            
    return answer + 1