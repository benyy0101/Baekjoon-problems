def solution(sequence, k):
    answer = []
    start = 0
    end = -1
    temp = 0
    while end < len(sequence):
        if temp < k:
            end += 1
            if end >= len(sequence):
                break
            temp += sequence[end]
        else:
            temp -= sequence[start]
            if start >= len(sequence):
                break
            start += 1
        if temp == k:
            answer.append([start, end])


    return sorted(answer,key = lambda x: x[1] - x[0])[0]