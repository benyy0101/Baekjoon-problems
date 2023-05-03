k,n=map(int, input().split())
nums=[]
max_len=0
max_num=0
for _ in range(k):
  temp=input()
  nums.append(temp)
  max_num=max(max_num,int(temp))

for i in range(n-k):
  nums.append(str(max_num))

nums.sort(key=lambda x: x*10, reverse=True)

print("".join(nums))