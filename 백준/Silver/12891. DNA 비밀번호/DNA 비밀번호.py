dna = {
  'A':0,
  'C':0,
  'G':0,
  'T':0
}
result = 0
n,end = map(int,input().split())
end -= 1
start = 0
chromo = input()
a,c,g,t = list(map(int,input().split()))
target = chromo[start:end]

for i in target:
  dna[i] += 1

while end < len(chromo):

  dna[chromo[end]] += 1
  
  if dna['A'] >= a and dna['C'] >= c and dna['G'] >= g and dna['T'] >= t:
    result += 1

  dna[chromo[start]] -=1
  
  start += 1
  end += 1

print(result)