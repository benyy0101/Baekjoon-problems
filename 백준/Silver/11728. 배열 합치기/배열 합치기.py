a,b = map(int,input().split())

aa = list(map(int,input().split()))
bb = list(map(int,input().split()))
pointer1, pointer2 = 0,0
result = []

# while pointer1 != a or pointer2 != b:
#   if pointer1 == a:
#     result.append(bb[pointer2])
#     pointer2 += 1
#   elif pointer2 == b:
#     result.append(aa[pointer1])
#     pointer1 += 1
#   else:
#     if aa[pointer1] < bb[pointer2]:
#       result.append(aa[pointer1])
#       pointer1 += 1
#     else:
#       result.append(bb[pointer2])
#       pointer2 += 1
      
while pointer1 < a and pointer2 < b:
  if aa[pointer1] > bb[pointer2]:
    result.append(bb[pointer2])
    pointer2 +=1
  else:
    result.append(aa[pointer1])
    pointer1 += 1

if pointer1 < a:
  result = result + aa[pointer1:]

if pointer2 < b:
  result = result + bb[pointer2:]
  
print(' '.join(map(str,result)))
