import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class UserInterface extends JPanel implements MouseListener, MouseMotionListener{

	static int oldMouseX=-1,oldMouseY=-1,newMouseX=-1, newMouseY=-1;
	static String moveList = "";
	static int classicX=-1,  classicY=-1;
	static int squareSize=63;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cA = 0,ca=0;
		for(int i=0;i<64;i++)
		{
			switch(AlphaBetaChess.chessBoard[i/8][i%8])
			{
				case "A":
					cA=1;
					break;
				case "a":
					ca=1;
					break;
			}
		}
		if(ca==1 && cA==1)
		{
		this.addMouseListener(this);
        this.addMouseMotionListener(this);
		for(int i=0;i<64;i+=2){
			g.setColor(new Color(255,200,100));
			g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
			g.setColor(new Color(150,50,30));
			g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
		}
		if(classicX!=-1)
		{
			g.setColor(new Color(128,0,0));
			g.fillRect(classicX*squareSize, (classicY)*squareSize, squareSize, squareSize);
		}
		Image chessPiecesImage;
        chessPiecesImage=new ImageIcon("ChessPieces.png").getImage();
        int x,y,x1=-1,y1=-1;
        
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
    	else
    	{
    		g.setColor(new Color(0,128,0));
			g.fillRect(0*squareSize, 0*squareSize, 8*squareSize, 8*squareSize);
			g.setColor(new Color(0,0,0));
			if(ca==0)
				g.drawString("White has won!",2*squareSize,2*squareSize);
			else
				g.drawString("Black has won!",2*squareSize,2*squareSize);
    	}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print(AlphaBetaChess.chessBoard[e.getY()/squareSize][e.getX()/squareSize]+" , " + e.getY()/squareSize+" , "+ e.getX()/squareSize+"\n");
		if(e.getX()<8*squareSize && e.getY()<8*squareSize && classicX==-1)
		{
			classicX = e.getX()/squareSize;
			classicY = e.getY()/squareSize;
			
			int z;
				
			int tomove = 5;
			Random rand = new Random();
			switch (AlphaBetaChess.chessBoard[classicY][classicX]){
				case "P":
						z = rand.nextInt(Rating.pv[0]+Rating.pv[1]+Rating.pv[2]+Rating.pv[3]+Rating.pv[4])+1;
						//System.out.print(z+"\n");	
						if(z <= Rating.pv[0])
						{
							tomove = 0;
							Rating.pv[0]++;
						}
						else if(z <= Rating.pv[0]+Rating.pv[1])
						{
							tomove = 1;
							Rating.pv[0]++;
							Rating.pv[1]++;
						}
						else if(z <= Rating.pv[0]+Rating.pv[1]+Rating.pv[2])
						{
							tomove = 2;
							Rating.pv[0]++;
							Rating.pv[2]++;
						}
						else if(z <= Rating.pv[0]+Rating.pv[1]+Rating.pv[2]+Rating.pv[3])
						{
							tomove = 3;
							Rating.pv[0]++;
							Rating.pv[3]++;
						}
						else
						{
							tomove = 4;
							Rating.pv[0]++;
							Rating.pv[4]++;
						}
						//System.out.print(tomove+"\n");
						break;
				case "K":
						z = rand.nextInt(Rating.kv[0]+Rating.kv[1]+Rating.kv[2]+Rating.kv[3]+Rating.kv[4])+1;
						if(z <= Rating.kv[0])
						{
							tomove = 0;
							Rating.kv[0]++;
							Rating.kv[1]++;
						}
						else if(z <= Rating.kv[0]+Rating.kv[1])
						{
							tomove = 1;
							Rating.kv[1]++;
						}
						else if(z <= Rating.kv[0]+Rating.kv[1]+Rating.kv[2])
						{
							tomove = 2;
							Rating.kv[1]++;
							Rating.kv[2]++;
						}
						else if(z <= Rating.kv[0]+Rating.kv[1]+Rating.kv[2]+Rating.kv[3])
						{
							tomove = 3;
							Rating.kv[1]++;
							Rating.kv[3]++;
						}
						else
						{
							tomove = 4;
							Rating.kv[1]++;
							Rating.kv[4]++;
						}
						break;
				case "B":
						z = rand.nextInt(Rating.bv[0]+Rating.bv[1]+Rating.bv[2]+Rating.bv[3]+Rating.bv[4])+1;
						if(z <= Rating.bv[0])
						{
							tomove = 0;
							Rating.bv[0]++;
							Rating.bv[2]++;
						}
						else if(z <= Rating.bv[0]+Rating.bv[1])
						{
							tomove = 1;
							Rating.bv[2]++;
							Rating.bv[1]++;
						}
						else if(z <= Rating.bv[0]+Rating.bv[1]+Rating.bv[2])
						{
							tomove = 2;
							Rating.bv[2]++;
						}
						else if(z <= Rating.bv[0]+Rating.bv[1]+Rating.bv[2]+Rating.bv[3])
						{
							tomove = 3;
							Rating.bv[2]++;
							Rating.bv[3]++;
						}
						else
						{
							tomove = 4;
							Rating.bv[2]++;
							Rating.bv[4]++;
						}
						break;
				case "R":
						z = rand.nextInt(Rating.rv[0]+Rating.rv[1]+Rating.rv[2]+Rating.rv[3]+Rating.rv[4])+1;
						if(z <= Rating.rv[0])
						{
							tomove = 0;
							Rating.rv[0]++;
							Rating.rv[3]++;
						}
						else if(z <= Rating.rv[0]+Rating.rv[1])
						{
							tomove = 1;
							Rating.rv[3]++;
							Rating.rv[1]++;
						}
						else if(z <= Rating.rv[0]+Rating.rv[1]+Rating.rv[2])
						{
							tomove = 2;
							Rating.rv[3]++;
							Rating.rv[2]++;
						}
						else if(z <= Rating.rv[0]+Rating.rv[1]+Rating.rv[2]+Rating.rv[3])
						{
							tomove = 3;
							//rv[0]++;
							Rating.rv[3]++;
						}
						else
						{
							tomove = 4;
							Rating.rv[3]++;
							Rating.rv[4]++;
						}
						break;
				case "Q":
						z = rand.nextInt(Rating.qv[0]+Rating.qv[1]+Rating.qv[2]+Rating.qv[3]+Rating.qv[4])+1;
						if(z <= Rating.qv[0])
						{
							tomove = 0;
							Rating.qv[0]++;
							Rating.qv[4]++;
						}
						else if(z <= Rating.qv[0]+Rating.qv[1])
						{
							tomove = 1;
							Rating.qv[4]++;
							Rating.qv[1]++;
						}
						else if(z <= Rating.qv[0]+Rating.qv[1]+Rating.qv[2])
						{
							tomove = 2;
							Rating.qv[4]++;
							Rating.qv[2]++;
						}
						else if(z <= Rating.qv[0]+Rating.qv[1]+Rating.qv[2]+Rating.qv[3])
						{
							tomove = 3;
							Rating.qv[4]++;
							Rating.qv[3]++;
						}
						else
						{
							tomove = 4;
							//qv[0]++;
							Rating.qv[4]++;
						}
						break;
				case "A":
						break;
				default:
						classicX =-1;
						classicY =-1;
						tomove = -1;
						return ;
			}
			switch (tomove){
				case 0: moveList = AlphaBetaChess.possibleP(classicY*8+classicX);
						break;
				case 1: moveList = AlphaBetaChess.possibleK(classicY*8+classicX);
						break;
				case 2: moveList = AlphaBetaChess.possibleB(classicY*8+classicX);
						break;
				case 3: moveList = AlphaBetaChess.possibleR(classicY*8+classicX);
						break;
				case 4: moveList = AlphaBetaChess.possibleQ(classicY*8+classicX);
						break;
				case 5: moveList = AlphaBetaChess.possibleA(classicY*8+classicX);
						break;
			}
			//System.out.print(AlphaBetaChess.chessBoard[classicY][classicX]+"\n");
			repaint();
			if(moveList.length()==0)
			{
				System.out.print("Your turn is skipped due to no legal moves possible\n");
				AlphaBetaChess.flipBoard();
				AlphaBetaChess.makeMove(AlphaBetaChess.alphaBeta(AlphaBetaChess.globalDepth, Integer.MAX_VALUE, Integer.MIN_VALUE, "", 0));
				AlphaBetaChess.flipBoard();
				repaint();
				
				classicX = -1; classicY = -1;
			}
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//for(int i=0;i<8;i++)
		//	System.out.print(AlphaBetaChess.chessBoard[6][i]);
		//System.out.print("\n");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getX()<8*squareSize && e.getY()<8*squareSize && classicX!=-1)
		{
			newMouseX = e.getX()/squareSize;
			newMouseY = e.getY()/squareSize;
			//System.out.print(newMouse+" , "+y2+"\n");
			int k = moveList.length();
			System.out.print(k+"\n");
			int check=-1;
			for(int i=2;i<k;i+=5)
			{
				int x2=Character.getNumericValue(moveList.charAt(i));
				int y2=Character.getNumericValue(moveList.charAt(i+1));
			//	System.out.print(x2+" , "+y2+"\n");
				if(x2==newMouseY && y2==newMouseX)
				{
					check = i-2;
				}
			}
			if(check!=-1)
			{
				String move = moveList.substring(check,check+5);
				
				AlphaBetaChess.makeMove(move);
			
			
				AlphaBetaChess.flipBoard();
				AlphaBetaChess.makeMove(AlphaBetaChess.alphaBeta(AlphaBetaChess.globalDepth, Integer.MAX_VALUE, Integer.MIN_VALUE, "", 0));
				AlphaBetaChess.flipBoard();
				repaint();

				classicX = -1; classicY = -1;
				moveList="";
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