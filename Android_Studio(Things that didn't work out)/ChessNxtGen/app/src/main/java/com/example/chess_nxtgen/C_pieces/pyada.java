package com.example.chess_nxtgen.C_pieces;

import com.example.chess_nxtgen.Cnates;
import com.example.chess_nxtgen.jagah;

import java.util.ArrayList;

public class pyada extends p_handler{
    public pyada(boolean white){
        super(white);
    }

    @Override
    public ArrayList<Cnates> A_moves(Cnates cnates, jagah[][] brd) {
        ArrayList<Cnates> moves = new ArrayList<>();
        moves.clear();
        Cnates c;

        if(brd[cnates.getx()][cnates.gety()].gPiece().iwhite())
        {
            if(cnates.getx()<8 && cnates.getx>=0 && (cnates.gety()-1)<8 && (cnates.gety()-1)>=0){
                if(brd[cnates.getx()][cnates.gety()-1].gPiece()==null){
                    c=new Cnates(x:cnates.getx(),y:cnates.gety()-1);
                    moves.add(c);
                    if((cnates.gety()==6) && brd[cnates.getx()][cnates.gety()-2].gPiece()==null)
                    {
                        c=new Cnates(x:cnates.getx(),y:cnates.gety()-2);
                        moves.add(c);
                    }
                }
            }

            if((cnates.getx()+1)<8 && (cnates.getx()+1)>=0 && (cnates.gety()-1)<8 && (cnates.gety()-1)>=0){
                if(brd[cnates.getx()+1][cnates.gety()-1].gPiece()!=null)
                {
                    if(brd[cnates.getx()+1][cnates.gety()-1].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c=new Cnates(x:cnates.getx()+1,y:cnates.gety()-1);
                        moves.add(c);
                    }
                }
            }

            if((cnates.getx()-1)<8 && (cnates.getx()-1)>=0 && (cnates.gety()-1)<8 && (cnates.gety()-1)>=0){
                if(brd[cnates.getx()-1][cnates.gety()-1].gPiece()!=null)
                {
                    if(brd[cnates.getx()-1][cnates.gety()-1].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c=new Cnates(x:cnates.getx()-1,y:cnates.gety()-1);
                        moves.add(c);
                    }
                }
            }
        }
        else
        {
            if(cnates.getx()<8 && cnates.getx>=0 && (cnates.gety()+1)<8 && (cnates.gety()+1)>=0){
                if(brd[cnates.getx()][cnates.gety()+1].gPiece()==null){
                    c=new Cnates(x:cnates.getx(),y:cnates.gety()+1);
                    moves.add(c);
                    if((cnates.gety()==1) && brd[cnates.getx()][cnates.gety()+2].gPiece()==null)
                    {
                        c=new Cnates(x:cnates.getx(),y:cnates.gety()+2);
                        moves.add(c);
                    }
                }
            }

            if((cnates.getx()+1)<8 && (cnates.getx()+1)>=0 && (cnates.gety()+1)<8 && (cnates.gety()+1)>=0){
                if(brd[cnates.getx()+1][cnates.gety()+1].gPiece()!=null)
                {
                    if(brd[cnates.getx()+1][cnates.gety()+1].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c=new Cnates(x:cnates.getx()+1,y:cnates.gety()+1);
                        moves.add(c);
                    }
                }
            }

            if((cnates.getx()-1)<8 && (cnates.getx()-1)>=0 && (cnates.gety()+1)<8 && (cnates.gety()+1)>=0){
                if(brd[cnates.getx()-1][cnates.gety()+1].gPiece()!=null)
                {
                    if(brd[cnates.getx()-1][cnates.gety()+1].gPiece().iwhite()!=brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                        c=new Cnates(x:cnates.getx()-1,y:cnates.gety()+1);
                        moves.add(c);
                    }
                }
            }
        }
        return moves;
    }
}