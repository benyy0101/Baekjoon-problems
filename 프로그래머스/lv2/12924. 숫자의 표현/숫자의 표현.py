def solution(n):
    answer = 0
    
    target = [i for i in range(1,n+1)]
    start = 0
    end = 0
    temp = 0

    for i in range(len(target)):
        temp += target[i]
        while temp > n:
            temp -= target[start]
            start += 1
        if temp == n:
            answer += 1
            
    return answer