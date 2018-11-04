#include <stdio.h>

int main(int argc, char *argv[]) {
	int x = 0;
	x=foo(6,2);
	printf("x = %d",x);
}
int foo(int x,int n){
	
	
	return n==0?1:x*foo(x,n-1);
	
}
int foo(int num,int den);