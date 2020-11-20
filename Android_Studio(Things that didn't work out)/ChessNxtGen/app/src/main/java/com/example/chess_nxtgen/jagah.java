package com.example.chess_nxtgen;
import com.example.chess_nxtgen.C_pieces.p_handler;
public class jagah {
    private p_handler samp;
    jagah(p_handler samp){
        this.samp = samp;
    }
    public p_handler gPiece() {
        return samp;
    }
    void sPiece(p_handler try){
        this.samp = try;
    }
}
