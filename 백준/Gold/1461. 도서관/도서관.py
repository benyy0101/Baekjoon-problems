N,M=[*map(int,input().split())]
books=[*map(int,input().split())]
 
positive_li = []; negative_li = []; last = 0
for b in books:
    last = max(abs(b),last)
    if b>0:
        positive_li.append(b)
    else:
        negative_li.append(abs(b))
positive_li.sort(reverse = 1); negative_li.sort(reverse = 1)
 
result = 0
for i in range(0, len(positive_li), M):
    result += positive_li[i]*2
for i in range(0, len(negative_li), M):
    result += negative_li[i]*2
print(result-last)