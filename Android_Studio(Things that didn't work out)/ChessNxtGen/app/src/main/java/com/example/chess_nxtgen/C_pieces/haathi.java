package com.example.chess_nxtgen.C_pieces;

import com.example.chess_nxtgen.Cnates;
import com.example.chess_nxtgen.jagah;

import java.util.ArrayList;

public class haathi extends p_handler{
    public haathi(boolean white){
        super(white);
    }

    @Override
    public ArrayList<Cnates> A_moves(Cnates cnates, jagah[][] brd) {
        ArrayList<Cnates> moves = new ArrayList<>();
        Cnates c;
        moves.clear();

        for(int i=cnates.getx()-1;i>=0;i--)
        {
                if(brd[i][cnates.gety()].gPiece()==null)
                {
                    c=new Cnates(x:i,y:cnates.gety());
                    moves.add(c);
                }
                else
                {
                    if(brd[i][cnates.gety()].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c= new Cnates(x:i,y:cnates.gety())
                        moves.add(c);
                    }
                    break;
                }
        }

        for(int i=cnates.getx()+1;i<8;i++)
        {
                if(brd[i][cnates.gety()].gPiece()==null)
                {
                    c=new Cnates(x:i,y:cnates.gety());
                    moves.add(c);
                }
                else
                {
                    if(brd[i][cnates.gety()].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c= new Cnates(x:i,y:cnates.gety())
                        moves.add(c);
                    }
                    break;
                }
        }

        for(int i=cnates.gety()-1;i>=0;i--)
        {
                if(brd[cnates.getx()][i].gPiece()==null)
                {
                    c=new Cnates(x:cnates.getx(),y:i);
                    moves.add(c);
                }
                else
                {
                    if(brd[cnates.getx()][i].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c= new Cnates(x:cnates.getx(),y:i)
                        moves.add(c);
                    }
                    break;
                }
        }

        for(int i=cnates.gety()+1;i<8;i++)
        {
                if(brd[cnates.getx()][i].gPiece()==null)
                {
                    c=new Cnates(x:cnates.getx(),y:i);
                    moves.add(c);
                }
                else
                {
                    if(brd[cnates.getx()][i].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c= new Cnates(x:cnates.getx(),y:i)
                        moves.add(c);
                    }
                    break;
                }
        }
        return moves;
    }
}
