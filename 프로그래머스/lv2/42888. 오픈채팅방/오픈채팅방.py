def solution(record):
    answer = []
    names = {}
    sequence = []
    for case in record:
        if(case[0]=='E' or case[0] == 'C'):
            state, uid, name = case.split()
            names[uid] = name
            if state == 'Enter':
                sequence.append([1,uid])
        else:
            state,uid = case.split()
            sequence.append([0,uid])
            
    for i in sequence:
        if i[0] == 1:
            answer.append(names[i[1]]+"님이 들어왔습니다.")
        else:
            answer.append(names[i[1]]+"님이 나갔습니다.")
    
    return answer