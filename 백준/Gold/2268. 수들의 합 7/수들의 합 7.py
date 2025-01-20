import sys
input=sys.stdin.readline

def Modify(node, start , end , index , value) :

    if index<start or index>end:
        return

    if start==end:
        tree[node]=value
        return

    Modify(node*2 , start , (start+end)//2 , index , value)
    Modify(node*2+1 , (start+end)//2+1 , end , index , value)

    tree[node]=tree[node*2]+tree[node*2+1]


def Sum(node , start , end , left , right):


    if left>end or right<start:
        return 0

    if left<=start and right>=end:
        return tree[node]

    return Sum(node*2 , start , (start+end)//2 , left , right) + Sum(node*2+1 , (start+end)//2+1 , end , left , right)

N,M=map(int,input().split())
tree=[0]*(4*N)
L=[0]*N
for i in range(M):

    Q,A,B=map(int,input().split())


    if Q==0:
        if A > B:
            A, B = B, A
        print( Sum(1 , 0 , N-1, A-1 , B-1) )
    else:
        Modify(1,0,N-1 , A-1, B)