#include <stdio.h>
#include <stdlib.h>
#define MAX 105

typedef struct Graph{
	int mat[MAX][MAX];
	int n, m;
};

typedef struct XY{
	int x;
	int y;
	int count; 
};

typedef struct Queue{
	XY queue[10100];
	int rear, front;
};

void enqueue(Queue* q, XY value){
	q->rear = (q->rear+1)%10100;
	q->queue[q->rear] = value;
}

XY dequeue(Queue* q){
	q->front = (q->front+1)%10100;
	return q->queue[q->front];
}

void search(Graph* g){
	
	Queue* q = (Queue*)malloc(sizeof(Queue));
	q->front = 0; q->rear = 0;
	
	Graph checked;
	int i, k;
	for(i=0; i<g->n; i++)
		for(k=0; k<g->m; k++)
			checked.mat[i][k] = 0;
	
	XY now, tmp;
	now.x = 0; now.y = 0; now.count = 0;
	
	int min;
	min = 999999;
	
	enqueue(q, now);
	checked.mat[0][0] = 1;
	while(q->front!=q->rear){
		while(now.x!=g->n-1 || now.y!=g->m-1){
			if(q->front==q->rear){
				break;}
			now = dequeue(q);
			(now.count)++;
			if(now.x==g->n-1 && now.y==g->m-1){
				break;}	
			if(now.x-1>-1 && now.x<g->n && now.y>-1 && now.y<g->m){
				tmp.x = now.x-1;
				tmp.y = now.y;
				tmp.count = now.count;
				if(checked.mat[tmp.x][tmp.y]==0 && g->mat[tmp.x][tmp.y] == 1){
					enqueue(q, tmp);
					checked.mat[tmp.x][tmp.y]=1;}}
			if(now.x>-1 && now.x+1<g->n && now.y>-1 && now.y<g->m){
				tmp.x = now.x+1;
				tmp.y = now.y;
				tmp.count = now.count;
				if(checked.mat[tmp.x][tmp.y]==0 && g->mat[tmp.x][tmp.y] == 1){
					enqueue(q, tmp);
					checked.mat[tmp.x][tmp.y]=1;}}
			if(now.x>-1 && now.x<g->n && now.y-1>-1 && now.y<g->m){
				tmp.x = now.x;
				tmp.y = now.y-1;
				tmp.count = now.count;
				if(checked.mat[tmp.x][tmp.y]==0 && g->mat[tmp.x][tmp.y] == 1){
					enqueue(q, tmp);
					checked.mat[tmp.x][tmp.y]=1;}}
			if(now.x>-1 && now.x<g->n && now.y>-1 && now.y+1<g->m){
				tmp.x = now.x;
				tmp.y = now.y+1;
				tmp.count = now.count;
				if(checked.mat[tmp.x][tmp.y]==0 && g->mat[tmp.x][tmp.y] == 1){
					enqueue(q, tmp);
					checked.mat[tmp.x][tmp.y]=1;}}
		}
		if(min>now.count){
			min = now.count;}
		now.x = 0; now.y = 0;
	}
	
	printf("%d", min);	
	free(q);
}

int main(void){
	
	int i,k,N,M;
	scanf("%d %d", &N, &M);
	
	Graph* g = (Graph*)malloc(sizeof(Graph));
	g->n = N; g->m = M;	
	
	char c;
	for(i=0; i<N; i++){
		getchar();
		for(k=0; k<M; k++){
			scanf("%c", &c);
			g->mat[i][k] = c-'0';}}
		
	search(g);
	free(g);
	return 0;
}