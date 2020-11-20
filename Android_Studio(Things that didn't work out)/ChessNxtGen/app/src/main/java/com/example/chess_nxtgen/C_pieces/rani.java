package com.example.chess_nxtgen.C_pieces;

import com.example.chess_nxtgen.Cnates;
import com.example.chess_nxtgen.jagah;

import java.util.ArrayList;

public class rani extends p_handler{
    public rani(boolean white){
        super(white);
    }

    @Override
    public ArrayList<Cnates> A_moves(Cnates cnates, jagah[][] brd) {
        ArrayList<Cnates> moves = new ArrayList<>();
        Cnates c;
        moves.clear();
        int a=cnates.getx();
        int b=cnates.gety();
        int i;
        for(i=a+1;i<8;i++)
        {
            if(brd[i][b].gPiece()==null)
            {
                c=new Cnates(x:i,y;b);
                moves.add((c));
            }
            else
            {
                if(brd[i][b].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                {
                    c=new Cnates(x:i,y:b);
                    moves.add(c);
                }
                break;
            }
        }

        for(i=a-1;i>=0;i--)
        {
            if(brd[i][b].gPiece()==null)
            {
                c=new Cnates(x:i,y;b);
                moves.add((c));
            }
            else
            {
                if(brd[i][b].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                {
                    c=new Cnates(x:i,y:b);
                    moves.add(c);
                }
                break;
            }
        }

        for(i=b+1;i<8;i++)
        {
            if(brd[a][i].gPiece()==null)
            {
                c=new Cnates(x:a,y;i);
                moves.add((c));
            }
            else
            {
                if(brd[a][i].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                {
                    c=new Cnates(x:a,y:i);
                    moves.add(c);
                }
                break;
            }
        }

        for(i=b-1;i>=0;i--)
        {
            if(brd[a][i].gPiece()==null)
            {
                c=new Cnates(x:a,y;i);
                moves.add((c));
            }
            else
            {
                if(brd[a][i].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                {
                    c=new Cnates(x:a,y:i);
                    moves.add(c);
                }
                break;
            }
        }

        for(i=1;i<8;i++)
        {
            if((a+i)>=0 && (a+i)<8 && (b+i)>=0 && (b+i)<8)
            {
                if(brd[a+i][b+i].gPiece()==null)
                {
                    c=Cnates(x:a+i,y:b+i);
                    moves.add(c);
                }
                else
                {
                    if(brd[a+i][b+i].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                    {
                        c=new Cnates(x:a+i,y:b+i);
                        moves.add(c);
                    }
                    break;
                }
            }
        }

        for(i=1;i<8;i++)
        {
            if((a+i)>=0 && (a+i)<8 && (b-i)>=0 && (b-i)<8)
            {
                if(brd[a+i][b-i].gPiece()==null)
                {
                    c=Cnates(x:a+i,y:b-i);
                    moves.add(c);
                }
                else
                {
                    if(brd[a+i][b-i].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                    {
                        c=new Cnates(x:a+i,y:b-i);
                        moves.add(c);
                    }
                    break;
                }
            }
        }

        for(i=1;i<8;i++)
        {
            if((a-i)>=0 && (a-i)<8 && (b+i)>=0 && (b+i)<8)
            {
                if(brd[a-i][b+i].gPiece()==null)
                {
                    c=Cnates(x:a-i,y:b+i);
                    moves.add(c);
                }
                else
                {
                    if(brd[a-i][b+i].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                    {
                        c=new Cnates(x:a-i,y:b+i);
                        moves.add(c);
                    }
                    break;
                }
            }
        }

        for(i=1;i<8;i++)
        {
            if((a-i)>=0 && (a-i)<8 && (b-i)>=0 && (b-i)<8)
            {
                if(brd[a-i][b-i].gPiece()==null)
                {
                    c=Cnates(x:a-i,y:b-i);
                    moves.add(c);
                }
                else
                {
                    if(brd[a-i][b-i].gPiece().iwhite()!=brd[a][b].gPiece().iwhite())
                    {
                        c=new Cnates(x:a-i,y:b-i);
                        moves.add(c);
                    }
                    break;
                }
            }
        }
        return moves;
        }
}
