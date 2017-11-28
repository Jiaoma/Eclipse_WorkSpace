#include <stdio.h>
int main()
{
    int i[3];
    i[0]=0;
    i[1]=1;
    i[2]=2;
    int j;
    printf("%d\n",i[3]);
    
    for(j=0;j<=3;j++)
       i[j]=j*3;     
     
    for(j=0;j<=3;j++)
       printf("%d\n",i[j]); 
    
    scanf("%d",&i[0]);
    return 0;
}
