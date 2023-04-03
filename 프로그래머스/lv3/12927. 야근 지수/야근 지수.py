import heapq as q

def solution(n, works):
    heap = []
    for i in works:
        q.heappush(heap, -i)
    
    answer = 0
    idx = 0
    while n > 0:
        work = q.heappop(heap)
        if work == 0:
            break
            
        q.heappush(heap,work+1)
        n -= 1
        idx += 1
        idx %= len(works)
        
        
    print(heap)
    for i in heap:
        answer = answer + i**2
        
    return answer