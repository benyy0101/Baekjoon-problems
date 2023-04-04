def solution(ingredient):
    stk = []
    answer = 0
    for i in range(len(ingredient)):
        stk.append(ingredient[i])
        if stk and len(stk) >= 4 and stk[-4:] == [1,2,3,1]:
            stk.pop()
            stk.pop()
            stk.pop()
            stk.pop()
            answer += 1
            
    return answer