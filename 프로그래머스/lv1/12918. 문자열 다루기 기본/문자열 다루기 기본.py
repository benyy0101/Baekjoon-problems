def solution(s):
    
    alp = '0123456789'
    if len(s) == 4 or len(s) == 6:
        for i in s:
            if i not in alp:
                return False
        return True
    else:
        return False
            