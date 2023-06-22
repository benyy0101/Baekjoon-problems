from collections import deque

def solution(s):
    answer = 0
    s = deque(s)
    for _ in range(len(s)):
        s.append(s.popleft())
        stk = []
        for i in s:
            if stk and i == ']' and stk[-1] == '[':
                stk.pop()
            elif stk and i == '}' and stk[-1] == '{':
                stk.pop()
            elif stk and i == ')' and stk[-1] == '(':
                stk.pop()
            else:
                stk.append(i)
        if len(stk) == 0:
            answer += 1
        
    return answer