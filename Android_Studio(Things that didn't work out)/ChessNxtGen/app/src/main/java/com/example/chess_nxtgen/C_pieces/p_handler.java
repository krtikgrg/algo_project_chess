package com.example.chess_nxtgen.C_pieces;
import com.example.chess_nxtgen.Cnates;
import com.example.chess_nxtgen.jagah;
import java.util.ArrayList;
public class p_handler {
    private boolean white;
    p_handler(boolean white){
        this.white = white;
    }

    public ArrayList<Cnates> A_moves(Cnates cnates , jagah[][] brd){
        ArrayList<Cnates> Moves = new ArrayList<>();
        Cnates a;
        for(int i=0;i<8;i++) {
            for (j = 0; j < 8; j++) {
                a = new Cnates(j, i);
                Moves.add(a);
            }
        }
        return Moves;
    }
    public boolean iwhite(){
        return white;
    }
}
