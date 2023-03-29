import re

def solution(new_id):
    new_id = new_id.lower()
    
    permitted = 'abcdefghijklmnopqrstuvwxyz0123456789-_.'
    
    for i in new_id:
        if i not in permitted:
            new_id = new_id.replace(i,' ')
    new_id = new_id.replace(' ','')
            
    while '..' in new_id:
        new_id = new_id.replace('..','.')
    
    if new_id and new_id[0] == '.':
        new_id = new_id[1:]
        
    if new_id and new_id[-1] == '.':
        new_id = new_id[:-1]
    
    if not new_id:
        new_id = 'a'
        
    if len(new_id) >= 16:
        print(1)
        new_id = new_id[:15]
    
    if new_id[-1] == '.':
        new_id = new_id[:-1]
        
    while len(new_id) <= 2:
        new_id += new_id[-1]
        
    return new_id