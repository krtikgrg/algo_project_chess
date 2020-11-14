import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class UserInterface extends JPanel implements MouseListener, MouseMotionListener{

	static int oldMouseX,oldMouseY,newMouseX, newMouseY , isdice=0 , isroll = 0;

	static int menu = 0;
	static int squareSize=63;
	public void paintComponent(Graphics g) {

		if(menu==1)
		{
		super.paintComponent(g);
		this.addMouseListener(this);
        this.addMouseMotionListener(this);
		for(int i=0;i<64;i+=2){
			g.setColor(new Color(255,200,100));
			g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
			g.setColor(new Color(150,50,30));
			g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
		}
		Image chessPiecesImage;
    		chessPiecesImage=new ImageIcon("ChessPieces.png").getImage();
        int x,y,x1=-1,y1=-1;
    		if(isdice == 1)
    		{
    			g.setColor(new Color(255,255,0));
    			g.fillRect(0*squareSize , 8*squareSize , squareSize,squareSize);
    			g.setColor(new Color(255,0,0));
    			g.drawString("ROLL" , 12, 530);
    		    g.setColor(new Color(128,0,0));
    			g.fillRect(3*squareSize , 8*squareSize , squareSize,squareSize);
    			g.setColor(new Color(0,128,0));
    			g.fillRect(4*squareSize , 8*squareSize , squareSize,squareSize);
    			g.setColor(new Color(0,0,128));
    			g.fillRect(5*squareSize , 8*squareSize , squareSize,squareSize);
    			for(int i=0;i<3;i++){
        	x=-1;
        	y=-1;
	    	 switch (AlphaBetaChess.die[i]) {
	    	 case "P": x=5; y=0;
             	 break;
	         case "p": x=5; y=1;
	             break;
	         case "R": x=2; y=0;
	             break;
	         case "r": x=2; y=1;
	             break;
	         case "K": x=4; y=0;
	             break;
	         case "k": x=4; y=1;
	             break;
	         case "B": x=3; y=0;
	             break;
	         case "b": x=3; y=1;
	             break;
	         case "Q": x=1; y=0;
	             break;
	         case "q": x=1; y=1;
	             break;
	         case "A": x=0; y=0;
	             break;
	         case "a": x=0; y=1;
	             break;
	    	}
	    if(x!=-1 && y!=-1)
	    	g.drawImage(chessPiecesImage, (i+3)*squareSize, (8)*squareSize, (i+4)*squareSize, (9)*squareSize, x*64, y*64, (x+1)*64, (y+1)*64, this);	    	
        }
    		
    		
        
      /*  switch (AlphaBetaChess.chessBoard[oldMouseX][oldMouseY]) {
   	 	case "P": x1=5; y1=0;
        	 break;
        case "p": x1=5; y1=1;
            break;
        case "R": x1=2; y1=0;
            break;
        case "r": x1=2; y1=1;
            break;
        case "K": x1=4; y1=0;
            break;
        case "k": x1=4; y1=1;
            break;
        case "B": x1=3; y1=0;
            break;
        case "b": x1=3; y1=1;
            break;
        case "Q": x1=1; y1=0;
            break;
        case "q": x1=1; y1=1;
            break;
        case "A": x1=0; y1=0;
            break;
        case "a": x1=0; y1=1;
            break;
   	}
        g.drawImage(chessPiecesImage, (newMouseX-15), (newMouseY-15), (newMouseX+64), (newMouseY+64), x1*64, y1*64, (x1+1)*64, (y1+1)*64, this);*/
        for(int i=0;i<64;i++){
        	x=-1;
        	y=-1;
	    	 switch (AlphaBetaChess.chessBoard[i/8][i%8]) {
	    	 case "P": x=5; y=0;
             	 break;
	         case "p": x=5; y=1;
	             break;
	         case "R": x=2; y=0;
	             break;
	         case "r": x=2; y=1;
	             break;
	         case "K": x=4; y=0;
	             break;
	         case "k": x=4; y=1;
	             break;
	         case "B": x=3; y=0;
	             break;
	         case "b": x=3; y=1;
	             break;
	         case "Q": x=1; y=0;
	             break;
	         case "q": x=1; y=1;
	             break;
	         case "A": x=0; y=0;
	             break;
	         case "a": x=0; y=1;
	             break;
	    	}
	    if(x!=-1 && y!=-1)
	    	g.drawImage(chessPiecesImage, (i%8)*squareSize, (i/8)*squareSize, (i%8+1)*squareSize, (i/8+1)*squareSize, x*64, y*64, (x+1)*64, (y+1)*64, this);	    	
        }
    	}
	}
    	
    	else
    	{
    		super.paintComponent(g);
			this.addMouseListener(this);
        	this.addMouseMotionListener(this);
    		g.setColor(new Color(255,200,100));
			g.fillRect(0*squareSize, 0*squareSize, 8*squareSize, 9*squareSize);
			g.setColor(new Color(0,0,0));
			g.fillRect(1*squareSize, 0*squareSize, 6*squareSize, 2*squareSize);
			g.setColor(new Color(255,0,0));
			g.drawString("Make your own puzzle!",2*squareSize,1*squareSize);
			g.setColor(new Color(0,0,0));
			g.fillRect(1*squareSize, 3*squareSize, 6*squareSize, 2*squareSize);
    		g.setColor(new Color(255,0,0));
    		g.drawString("Play given puzzles!",2*squareSize,4*squareSize);
    		g.setColor(new Color(0,0,0));
    		g.fillRect(1*squareSize, 6*squareSize, 6*squareSize, 2*squareSize);
    		g.setColor(new Color(255,0,0));
    		g.drawString("Play dice chess!",2*squareSize,7*squareSize);
    		
	}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getX()<8*squareSize && e.getY()<8*squareSize){//if mouse is dragged inside the chess board
			newMouseX=e.getX();
			newMouseY=e.getY();
			repaint();
		}			
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(menu==1)
		{
		if(e.getX()<8*squareSize && e.getY()<8*squareSize){//if mouse is pressed inside the chess board
			oldMouseX=e.getX()/squareSize;
			oldMouseY=e.getY()/squareSize;
		}
		else if(isroll ==0 && e.getX()<8*squareSize && e.getY()>=8*squareSize && e.getY()<9*squareSize)
		{
			String yo="";

			AlphaBetaChess.diceroll();
			yo = AlphaBetaChess.possibleMoves2();
		
			repaint();
			if(yo.length()==0)
				isroll=0;
			else
				isroll = 1;
		}
		}
		else
		{
			if(e.getY()>=0*squareSize && e.getY()<2*squareSize)
			{
				Scanner str = new Scanner(System.in);
				System.out.println("Enter the number of total pieces");
				int k = str.nextInt();
				for(int i=0;i<8;i++)
				{
					for(int j=0;j<8;j++)
						AlphaBetaChess.chessBoard[i][j]=" ";
				}
				for(int i=0;i<k;i++)
				{
					System.out.println("Enter the piece and it's position (first row then coloumn)!");
					String pi = str.next();
					int row = str.nextInt();
					int col = str.nextInt();
					AlphaBetaChess.chessBoard[row][col] = pi;
						//take input of chessboard
				}
				AlphaBetaChess.kingPositionA = 0;
				AlphaBetaChess.kingPositiona = 0;
				menu = 1;
				while(!"A".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionA/8][AlphaBetaChess.kingPositionA%8]))	AlphaBetaChess.kingPositionA++;
				while(!"a".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositiona/8][AlphaBetaChess.kingPositiona%8]))	AlphaBetaChess.kingPositiona++;
				repaint();
			}
			else if(e.getY()>=3*squareSize && e.getY()<5*squareSize)
			{
				//give puzzles default;
				menu = 1;
				repaint();
			}
			else if(e.getY()>=6*squareSize && e.getY()<8*squareSize)
			{
				menu=1;
				isdice=1;
				repaint();
			AlphaBetaChess.globalDepth=0;	
		AlphaBetaChess.playerColor = JOptionPane.showOptionDialog(null, "Do you want to play the first move?", 
				"Choose an option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_OPTION);
		if(AlphaBetaChess.playerColor==JOptionPane.NO_OPTION){
			long startTime=System.currentTimeMillis();
			AlphaBetaChess.makeMove(AlphaBetaChess.alphaBeta2(AlphaBetaChess.globalDepth, Integer.MAX_VALUE, Integer.MIN_VALUE, "", 0));
			long endTime=System.currentTimeMillis();
			System.out.println("that took "+((endTime-startTime)/1000.0)+" seconds");
			AlphaBetaChess.flipBoard();
			
				repaint();
				
			}
		}		
	}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getX()<8*squareSize && e.getY()<8*squareSize){
		//if mouse is released inside the chess board
			if(isdice==0)
			{
			newMouseX=e.getX()/squareSize;
			newMouseY=e.getY()/squareSize;
			String move;
			if(e.getButton()==MouseEvent.BUTTON1){
				if(newMouseY==0 && oldMouseY==1 && "P".equals(AlphaBetaChess.chessBoard[oldMouseY][oldMouseX])){
					//if pawn promotion
					move=""+oldMouseX+newMouseX+AlphaBetaChess.chessBoard[newMouseY][newMouseX]+"QP";
				}	
				else{	//if a regular move
					move=""+oldMouseY+oldMouseX+newMouseY+newMouseX+AlphaBetaChess.chessBoard[newMouseY][newMouseX];
				}							
				String userPossibleMoves=AlphaBetaChess.possibleMoves();
				if(userPossibleMoves.replaceAll(move, "").length()<userPossibleMoves.length()){
					AlphaBetaChess.makeMove(move);
					AlphaBetaChess.flipBoard();
					AlphaBetaChess.makeMove(AlphaBetaChess.alphaBeta(AlphaBetaChess.globalDepth, Integer.MAX_VALUE, Integer.MIN_VALUE, "", 0));
					AlphaBetaChess.flipBoard();
					repaint();
				}
			}
			}
			else
			{
				if(isroll==1)
				{
					newMouseX=e.getX()/squareSize;
			newMouseY=e.getY()/squareSize;
			String move;
			if(e.getButton()==MouseEvent.BUTTON1){
				if(newMouseY==0 && oldMouseY==1 && "P".equals(AlphaBetaChess.chessBoard[oldMouseY][oldMouseX])){
					//if pawn promotion
					move=""+oldMouseX+newMouseX+AlphaBetaChess.chessBoard[newMouseY][newMouseX]+"QP";
				}	
				else{	//if a regular move
					move=""+oldMouseY+oldMouseX+newMouseY+newMouseX+AlphaBetaChess.chessBoard[newMouseY][newMouseX];
				}							
				String userPossibleMoves=AlphaBetaChess.possibleMoves2();
				if(userPossibleMoves.replaceAll(move, "").length()<userPossibleMoves.length()){
					AlphaBetaChess.makeMove(move);
					AlphaBetaChess.flipBoard();
					AlphaBetaChess.makeMove(AlphaBetaChess.alphaBeta2(AlphaBetaChess.globalDepth, Integer.MAX_VALUE, Integer.MIN_VALUE, "", 0));
					AlphaBetaChess.flipBoard();
					repaint();
					isroll = 0;
				}
			}
				}
			}
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}