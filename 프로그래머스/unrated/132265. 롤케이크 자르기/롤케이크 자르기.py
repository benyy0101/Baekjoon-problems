from collections import defaultdict, Counter

def solution(topping):
    answer = 0
    a = defaultdict(int)
    b = Counter(topping)
    
    for i in range(len(topping)):
        b[topping[i]] -= 1
        a[topping[i]] += 1
        if b[topping[i]] == 0:
            del b[topping[i]]
        if len(a.keys()) == len(b.keys()):
            answer +=1
        
    return answer