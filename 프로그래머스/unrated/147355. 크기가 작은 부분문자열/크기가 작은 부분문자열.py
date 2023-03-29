def solution(t, p):
    answer = 0
    pp = len(p)
    ppp = int(p)
    for i in range(len(t)-pp+1):
        temp = int(t[i:i+pp])
        if temp <= ppp:
            print(temp)
            answer += 1
        
    return answer