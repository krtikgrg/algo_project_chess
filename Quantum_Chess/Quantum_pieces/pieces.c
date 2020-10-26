#include "headers.h"

int findsecondstate(int c , int ind)
{
    random_shuffle(index.begin(),index.end());
    int i=0;
    while(isavail[c][index[i]]==false)
        i++;
    isavail[c][index[i]]=false;
    for(int j=0;j<4;j++)
        pieces[c][ind][4+j]=pieces[c][index[i]][j];
    return 1;
}

int findclassicalstate(int c, int ind)
{
    int p = rand()%2;
    if(p==0)
        return 0;
    else
        return 4;
}

int init_pieces()
{
    for(int i=0;i<16;i++)
    {
        int y = i;
        int j=0;
        while(j<4)
        {
            if(y%2==0)
            {
                pieces[0][i][3-j]=0;
                pieces[1][i][3-j]=0;
            }
            else
            {
                pieces[0][i][3-j]=1;
                pieces[1][i][3-j]=1;
            }
            pieces[0][i][4+j]=-1;
            pieces[0][i][4+j]=-1;
            y/=2;
            j++;
        }
        isavail[0][i]=isavail[1][i]=true;
        index.push_back(i);
    }
    return 1;
}


