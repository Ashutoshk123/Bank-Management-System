#include<stdio.h>
int maze(int cr,int cc,int er,int ec){
	int rightways=0;
	int downways=0;
	if(cr<er && cc<ec){
		rightways+=(cr,cc+1,er,ec);
		downways+=(cr+1,cc,er,ec);
    }
	if(cr==er) {
	rightways+=(cr,cc+1,er,ec);
    }
	if(cc==ec) {
	downways+=(cr+1,cc,er,ec);
    }
	if(cr==er&&cc==ec) {
		return 1;
	}
		
	int ways = rightways + downways;
	return ways;
}
int main()
{
	int n,m;
	printf("Enter no. of rows\n");
	scanf("%d",&n);
	printf("Enter no. of columns\n");
	scanf("%d",&m);
	int totalways = maze(1,1,n,m);
	printf("No. of ways to reach end point is %d",totalways);
	return 0;
}