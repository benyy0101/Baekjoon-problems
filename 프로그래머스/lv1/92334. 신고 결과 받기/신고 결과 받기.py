from collections import defaultdict

def solution(id_list, report, k):
    report = set(report)
    target = defaultdict(int)
    reported = defaultdict(list)
    
    for case in report:
        a,b = case.split()
        reported[a].append(b)
        target[b] += 1
        
        
    banned = [i for i in target.keys() if target[i] >= k]
    result = {}
    
    for i in id_list:
        result[i] = 0
        
    for i in reported.keys():
        for j in reported[i]:
            if j in banned:
                result[i] += 1
    return list(result.values())