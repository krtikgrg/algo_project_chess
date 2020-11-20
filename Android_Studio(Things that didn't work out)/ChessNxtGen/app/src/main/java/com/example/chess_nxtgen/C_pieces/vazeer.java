package com.example.chess_nxtgen.C_pieces;

import com.example.chess_nxtgen.Cnates;
import com.example.chess_nxtgen.jagah;

import java.util.ArrayList;

public class vazeer extends p_handler{
    public vazeer(boolean white){
        super(white);
    }
    @Override
    public ArrayList<Cnates> A_moves(Cnates cnates, jagah[][] brd) {
        ArrayList<Cnates> moves = new ArrayList<>();
        Cnates c;

        for(int i=1 ; i<8 ; i++)
        {
            if(cnates.getx()+i<8 && cnates.gety()+i<8){
                if(brd[cnates.getx()+i][cnates.gety()+i].gPiece()==null)
                {
                    c = new Cnates(x: cnates.getx()+i,y: cnates.gety()+i);
                    moves.add(c);
                }
                else if(brd[cnates.getx()+i][cnates.gety()+i].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite())
                {
                    c = new Cnates(x: cnates.getx()+i,cnates.gety()+i);
                    moves.add(c);
                    break;
                }
            }
        }
        for(int i=1;i<8;i++)
        {
            if(cnates.getx()-i<8 && cnates.gety()-i<8){
                if(brd[cnates.getx()-i][cnates.gety()-i].gPiece()==null)
                {
                    c = new Cnates(x: cnates.getx()-i,y: cnates.gety()-i);
                    moves.add(c);
                }
                else if(brd[cnates.getx()-i][cnates.gety()-i].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite())
                {
                    c = new Cnates(x: cnates.getx()-i,cnates.gety()-i);
                    moves.add(c);
                    break;
                }
            }
        }
        for(int i=1;i<8;i++)
        {
            if(cnates.getx()-i<8 && cnates.gety()+i<8){
                if(brd[cnates.getx()-i][cnates.gety()+i].gPiece()==null)
                {
                    c = new Cnates(x: cnates.getx()-i,y: cnates.gety()+i);
                    moves.add(c);
                }
                else if(brd[cnates.getx()-i][cnates.gety()+i].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite())
                {
                    c = new Cnates(x: cnates.getx()-i,cnates.gety()+i);
                    moves.add(c);
                    break;
                }
            }
        }
        for(int i=1;i<8;i++)
        {
            if(cnates.getx()+i<8 && cnates.gety()-i<8){
                if(brd[cnates.getx()+i][cnates.gety()-i].gPiece()==null)
                {
                    c = new Cnates(x: cnates.getx()+i,y: cnates.gety()-i);
                    moves.add(c);
                }
                else if(brd[cnates.getx()+i][cnates.gety()-i].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite())
                {
                    c = new Cnates(x: cnates.getx()+i,cnates.gety()-i);
                    moves.add(c);
                    break;
                }
            }
        }
        return moves;
    }
}

