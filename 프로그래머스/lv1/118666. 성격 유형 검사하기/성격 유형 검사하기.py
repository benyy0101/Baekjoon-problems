from collections import defaultdict

def solution(survey, choices):
    answer = ''
    
    points = defaultdict(int)
    
    for i in range(len(survey)):
        a,b = survey[i][0], survey[i][1]
        
        if choices[i] > 4:
            points[b] += choices[i] - 4
        elif choices[i] < 4:
            points[a] += 4 - choices[i]
        else:
            continue
            
    if (points['R'] < points['T']):
        answer += 'T'
    else:
        answer += 'R'
        
    if (points['C'] < points['F']):
        answer += 'F'
    else:
        answer += 'C'
        
    if (points['J'] < points['M']):
        answer += 'M'
    else:
        answer += 'J'
        
    if (points['A'] < points['N']):
        answer += 'N'
    else:
        answer += 'A'
        
    return answer