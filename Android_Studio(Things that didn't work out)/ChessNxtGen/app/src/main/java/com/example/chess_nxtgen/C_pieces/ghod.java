package com.example.chess_nxtgen.C_pieces;
import com.example.chess_nxtgen.Cnates;
import com.example.chess_nxtgen.jagah;
import java.util.ArrayList;
public class ghod extends p_handler{
    public ghod(boolean white){
        super(white);
    }

    /*now Check for the available places for a knight*/
    /*By checking whether the place i am looking for is either
    empty or have a piece of another color*/
    @Override
    public ArrayList<Cnates> A_moves(Cnates cnates, jagah[][] brd) {
        ArrayList<Cnates> moves = new ArrayList<>();
        moves.clear();
        Cnates a;

        if(cnates.getx()+2<8 && cnates.gety()-1>=0){
            if(brd[cnates.getx()+2][cnates.gety()-1].gPiece() == null){
                c= new Cnates(x:cnates.getx()+2 ,y:cnates.gety()-1);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()+2][cnates.gety()-1].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()+2 ,y:cnates.gety()-1);
                    moves.add(c);
                }
            }
        }

        if(cnates.getx()+2<8 && cnates.gety()+1>=0){
            if(brd[cnates.getx()+2][cnates.gety()+1].gPiece() == null){
                c= new Cnates(x:cnates.getx()+2 ,y:cnates.gety()+1);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()+2][cnates.gety()+1].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()+2 ,y:cnates.gety()+1);
                    moves.add(c);
                }
            }
        }

        if(cnates.getx()+1<8 && cnates.gety()+2>=0){
            if(brd[cnates.getx()+1][cnates.gety()+2].gPiece() == null){
                c= new Cnates(x:cnates.getx()+1 ,y:cnates.gety()+2);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()+1][cnates.gety()+2].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()+1 ,y:cnates.gety()+2);
                    moves.add(c);
                }
            }
        }

        if(cnates.getx()-1<8 && cnates.gety()+2>=0){
            if(brd[cnates.getx()-1][cnates.gety()+2].gPiece() == null){
                c= new Cnates(x:cnates.getx()-1 ,y:cnates.gety()+2);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()-1][cnates.gety()+2].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()-1 ,y:cnates.gety()+2);
                    moves.add(c);
                }
            }
        }

        if(cnates.getx()-2<8 && cnates.gety()+1>=0){
            if(brd[cnates.getx()-2][cnates.gety()+1].gPiece() == null){
                c= new Cnates(x:cnates.getx()-2 ,y:cnates.gety()+1);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()-2][cnates.gety()+1].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()-2 ,y:cnates.gety()+1);
                    moves.add(c);
                }
            }
        }

        if(cnates.getx()-2<8 && cnates.gety()-1>=0){
            if(brd[cnates.getx()-2][cnates.gety()-1].gPiece() == null){
                c= new Cnates(x:cnates.getx()-2 ,y:cnates.gety()-1);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()-2][cnates.gety()-1].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()-2 ,y:cnates.gety()-1);
                    moves.add(c);
                }
            }
        }

        if(cnates.getx()-1<8 && cnates.gety()-2>=0){
            if(brd[cnates.getx()-1][cnates.gety()-2].gPiece() == null){
                c= new Cnates(x:cnates.getx()-1 ,y:cnates.gety()-2);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()-1][cnates.gety()-2].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()-1 ,y:cnates.gety()-2);
                    moves.add(c);
                }
            }
        }

        if(cnates.getx()+1<8 && cnates.gety()-2>=0){
            if(brd[cnates.getx()+1][cnates.gety()-2].gPiece() == null){
                c= new Cnates(x:cnates.getx()+1 ,y:cnates.gety()-2);
                moves.add(c);
            }
            else{
                if(brd[cnates.getx()+1][cnates.gety()-2].gPiece().iwhite() != brd[cnates.getx()][cnates.gety()].gPiece().iwhite()){
                    c= new Cnates(x:cnates.getx()+1 ,y:cnates.gety()-2);
                    moves.add(c);
                }
            }
        }
        return moves;
    }
}
