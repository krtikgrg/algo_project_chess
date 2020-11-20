package com.example.chess_nxtgen.C_pieces;

import com.example.chess_nxtgen.Cnates;
import com.example.chess_nxtgen.jagah;

import java.util.ArrayList;

public class Raja extends p_handler{
    public Raja(boolean white){
        super(white);
    }

    @Override
    public ArrayList<Cnates> A_moves(Cnates cnates, jagah[][] brd) {
        ArrayList<Cnates> moves =new ArrayList<>();
        Cnates c;
        moves.clear();
        for(int i=cnates.getx()-1;i<=cnates.getx()+1;i++)
        {
            for(int j=cnates.gety()-1;i<=cnates.gety()+1;i++)
            {
                if(brd[i][j].gPiece()==null)
                {
                    c=new Cnates(x:i,y:j);
                    moves.add(c);
                }
                else
                {
                    if(brd[i][j].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite())
                    {
                        c=new Cnates(x:i,y;j);
                        moves.add(c);
                    }
                }
            }
        }
        return moves;
    }
}
