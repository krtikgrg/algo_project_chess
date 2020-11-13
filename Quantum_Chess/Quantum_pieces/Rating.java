
public class Rating {
	static int pv[]={4,1,1,1,1};
	static int kv[]={1,4,1,1,1};
	static int bv[]={1,1,4,1,1};
	static int rv[]={1,1,1,4,1};
	static int qv[]={1,1,1,1,4};
	
	static int pawnBoard[][]={//attribute to http://chessprogramming.wikispaces.com/Simplified+evaluation+function
	        { 0,  0,  0,  0,  0,  0,  0,  0},
	        {50, 50, 50, 50, 50, 50, 50, 50},
	        {10, 10, 20, 30, 30, 20, 10, 10},
	        { 5,  5, 10, 25, 25, 10,  5,  5},
	        { 0,  0,  0, 20, 20,  0,  0,  0},
	        { 5, -5,-10,  0,  0,-10, -5,  5},
	        { 5, 10, 10,-20,-20, 10, 10,  5},
	        { 0,  0,  0,  0,  0,  0,  0,  0}};
	    static int rookBoard[][]={
	        { 0,  0,  0,  0,  0,  0,  0,  0},
	        { 5, 10, 10, 10, 10, 10, 10,  5},
	        {-5,  0,  0,  0,  0,  0,  0, -5},
	        {-5,  0,  0,  0,  0,  0,  0, -5},
	        {-5,  0,  0,  0,  0,  0,  0, -5},
	        {-5,  0,  0,  0,  0,  0,  0, -5},
	        {-5,  0,  0,  0,  0,  0,  0, -5},
	        { 0,  0,  0,  5,  5,  0,  0,  0}};
	    static int knightBoard[][]={
	        {-50,-40,-30,-30,-30,-30,-40,-50},
	        {-40,-20,  0,  0,  0,  0,-20,-40},
	        {-30,  0, 10, 15, 15, 10,  0,-30},
	        {-30,  5, 15, 20, 20, 15,  5,-30},
	        {-30,  0, 15, 20, 20, 15,  0,-30},
	        {-30,  5, 10, 15, 15, 10,  5,-30},
	        {-40,-20,  0,  5,  5,  0,-20,-40},
	        {-50,-40,-30,-30,-30,-30,-40,-50}};
	    static int bishopBoard[][]={
	        {-20,-10,-10,-10,-10,-10,-10,-20},
	        {-10,  0,  0,  0,  0,  0,  0,-10},
	        {-10,  0,  5, 10, 10,  5,  0,-10},
	        {-10,  5,  5, 10, 10,  5,  5,-10},
	        {-10,  0, 10, 10, 10, 10,  0,-10},
	        {-10, 10, 10, 10, 10, 10, 10,-10},
	        {-10,  5,  0,  0,  0,  0,  5,-10},
	        {-20,-10,-10,-10,-10,-10,-10,-20}};
	    static int queenBoard[][]={
	        {-20,-10,-10, -5, -5,-10,-10,-20},
	        {-10,  0,  0,  0,  0,  0,  0,-10},
	        {-10,  0,  5,  5,  5,  5,  0,-10},
	        { -5,  0,  5,  5,  5,  5,  0, -5},
	        {  0,  0,  5,  5,  5,  5,  0, -5},
	        {-10,  5,  5,  5,  5,  5,  0,-10},
	        {-10,  0,  5,  0,  0,  0,  0,-10},
	        {-20,-10,-10, -5, -5,-10,-10,-20}};
	    static int kingMidBoard[][]={
	        {-30,-40,-40,-50,-50,-40,-40,-30},
	        {-30,-40,-40,-50,-50,-40,-40,-30},
	        {-30,-40,-40,-50,-50,-40,-40,-30},
	        {-30,-40,-40,-50,-50,-40,-40,-30},
	        {-20,-30,-30,-40,-40,-30,-30,-20},
	        {-10,-20,-20,-20,-20,-20,-20,-10},
	        { 20, 20,  0,  0,  0,  0, 20, 20},
	        { 20, 30, 10,  0,  0, 10, 30, 20}};
	    static int kingEndBoard[][]={
	        {-50,-40,-30,-20,-20,-30,-40,-50},
	        {-30,-20,-10,  0,  0,-10,-20,-30},
	        {-30,-10, 20, 30, 30, 20,-10,-30},
	        {-30,-10, 30, 40, 40, 30,-10,-30},
	        {-30,-10, 30, 40, 40, 30,-10,-30},
	        {-30,-10, 20, 30, 30, 20,-10,-30},
	        {-30,-30,  0,  0,  0,  0,-30,-30},
	        {-50,-30,-30,-30,-30,-30,-30,-50}};

	public static int rating(int movesAvailableCount,int depth){
		int rating=0;
		int pieceAvailability=ratePieceAvailability();
		
		rating+=rateAttack()+pieceAvailability+rateMovability(movesAvailableCount,depth)+ratePositional(pieceAvailability);
		AlphaBetaChess.flipBoard();
		rating-=rateAttack()-pieceAvailability-rateMovability(movesAvailableCount,depth)-ratePositional(pieceAvailability);
		AlphaBetaChess.flipBoard();
		return -(rating+depth*50);
	}
	
	public static int rateAttack(){
		int rating=0;
		int tempKingPos=AlphaBetaChess.kingPositionA;
		
        for (int i=0;i<64;i++) {
            switch (AlphaBetaChess.chessBoard[i/8][i%8]) {
                case "P": AlphaBetaChess.kingPositionA=i;             
	                	if(!AlphaBetaChess.kingSafe())
	                		rating-=64;
	                    break;
                case "R": AlphaBetaChess.kingPositionA=i;             
		            	if(!AlphaBetaChess.kingSafe())
		            		rating-=500;
		                break;                    
                case "K": AlphaBetaChess.kingPositionA=i;             
		            	if(!AlphaBetaChess.kingSafe())
		            		rating-=300;
                    break;
                case "B": AlphaBetaChess.kingPositionA=i;             
		            	if(!AlphaBetaChess.kingSafe())
		            		rating-=300;
                    break;
                case "Q": AlphaBetaChess.kingPositionA=i;             
		            	if(!AlphaBetaChess.kingSafe())
		            		rating-=900;
                    break;
            }
        }
        AlphaBetaChess.kingPositionA=tempKingPos;
        if(!AlphaBetaChess.kingSafe())
        	rating-=200;
        return rating/2;
	}
	
	//rates according to the chess pieces availability on the board 
	public static int ratePieceAvailability(){
		int rating=0, bishopCount=0;
        for (int i=0;i<64;i++) {
            switch (AlphaBetaChess.chessBoard[i/8][i%8]) {
                case "P": rating+=(100*pv[0]+300*(pv[1]+pv[2])+500*pv[3]+900*pv[4])/(pv[0]+pv[1]+pv[2]+pv[3]+pv[4]);
                    break;
                case "R": rating+=(100*rv[0]+300*(rv[1]+rv[2])+500*rv[3]+900*rv[4])/(rv[0]+rv[1]+rv[2]+rv[3]+rv[4]);
                    break;
                case "K": rating+=(100*kv[0]+300*(kv[1]+kv[2])+500*kv[3]+900*kv[4])/(kv[0]+kv[1]+kv[2]+kv[3]+kv[4]);
                    break;
                case "B": rating+=(100*bv[0]+300*(bv[1]+bv[2])+500*bv[3]+900*bv[4])/(bv[0]+bv[1]+bv[2]+bv[3]+bv[4]);
                    break;
                case "Q": rating+=(100*qv[0]+300*(qv[1]+qv[2])+500*qv[3]+900*qv[4])/(qv[0]+qv[1]+qv[2]+qv[3]+qv[4]);
                    break;
            }
        }
        
        return rating;
	}
	
	//rates according to the flexibilty in possible moves
	public static int rateMovability(int movesAvailableCount,int depth){
		int rating=0;
		rating+=movesAvailableCount;	//5 points for each possible move
		if(movesAvailableCount==0){	//checkmate or stalemate condition
			if(!AlphaBetaChess.kingSafe()){	//checkmate
				rating+=-200000*depth;
			}else {	//stalemate
				rating+=-150000*depth;
			}
		}
		return rating;
	}
	
	public static int ratePositional(int material) {
        int rating=0;
        for (int i=0;i<64;i++) {
            switch (AlphaBetaChess.chessBoard[i/8][i%8]) {
                case "P": rating+=pawnBoard[i/8][i%8];
                    break;
                case "R": rating+=rookBoard[i/8][i%8];
                    break;
                case "K": rating+=knightBoard[i/8][i%8];
                    break;
                case "B": rating+=bishopBoard[i/8][i%8];
                    break;
                case "Q": rating+=queenBoard[i/8][i%8];
                    break;
                case "A": if (material>=1750) {rating+=kingMidBoard[i/8][i%8]; rating+=AlphaBetaChess.possibleA(AlphaBetaChess.kingPositionA).length()*10;} else
                {rating+=kingEndBoard[i/8][i%8]; rating+=AlphaBetaChess.possibleA(AlphaBetaChess.kingPositionA).length()*30;}
                    break;
            }
        }
        return rating;
    }
}
