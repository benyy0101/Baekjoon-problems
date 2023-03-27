from collections import deque

def solution(picks, minerals):
    answer = 0
    minerals = minerals[:5 * sum(picks)]
    target = deque(minerals)

    tiredness = {
        "diamond": [1, 5, 25],
        "iron": [1,1,5],
        "stone": [1,1,1]
    }
    result = []
    while target:
        dia = 0
        iron = 0
        stone = 0
        
        for i in range(5):
            if not target:
                break
            m = target.popleft()
            
            dia += tiredness[m][0]
            iron += tiredness[m][1]
            stone += tiredness[m][2]
            
        result.append([dia,iron,stone])
    result.sort(key = lambda x: [x[2],x[1],x[0]])
    
    for idx, pick in enumerate(picks):
        for i in range(pick):
            if result:
                answer += result.pop()[idx]
            else:
                return answer
        
    return answer