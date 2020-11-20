package com.example.chess_nxtgen;

import android.os.Bundle;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.chess_nxtgen.C_pieces.p_handler;
import com.example.chess_nxtgen.C_pieces.ghod;
import com.example.chess_nxtgen.C_pieces.Raja;
import com.example.chess_nxtgen.C_pieces.rani;
import com.example.chess_nxtgen.C_pieces.haathi;
import com.example.chess_nxtgen.C_pieces.pyada;
import com.example.chess_nxtgen.C_pieces.vazeer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public boolean FPTurn;
    public ArrayList<Cnates> LoC =new ArrayList<>();
    public jagah[][] brd = new jagah[8][8];
    public jagah[][] brd2 = new jagah[8][8];
    public boolean selec = false;
    public Cnates lastpos = null;
    public Cnates clickedPosition = new Cnates(0,0);
    public TextView game_over;
    public TextView[][] DisplayBoard= new TextView[8][8];
    public TextView[][] DisplayBg = new TextView[8][8];
    public ArrayList<jagah[][]> LastMoves = new ArrayList<>();
    public LinearLayout pawn_choices;
    public int numberofMoves;

    p_handler kingw;
    p_handler kingb;

    p_handler queenw;
    p_handler queenb;

    p_handler bishopw1;
    p_handler bishopw2;
    p_handler bishopb1;
    p_handler bishopb2;

    p_handler knightw1;
    p_handler knightw2;
    p_handler knightb1;
    p_handler knightb2;

    p_handler rookw1;
    p_handler rookw2;
    p_handler rookb1;
    p_handler rookb2;

    p_handler pawnw1;
    p_handler pawnw2;
    p_handler pawnw3;
    p_handler pawnw4;
    p_handler pawnw5;
    p_handler pawnw6;
    p_handler pawnw7;
    p_handler pawnw8;

    p_handler pawnb1;
    p_handler pawnb2;
    p_handler pawnb3;
    p_handler pawnb4;
    p_handler pawnb5;
    p_handler pawnb6;
    p_handler pawnb7;
    p_handler pawnb8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeBoard();

        game_over = (TextView) findViewById(R.id.game_over);
        pawn_choices = (LinearLayout) findViewById(R.id.pawn_choices);

        game_over.setVisibility(View.INVISIBLE);
        pawn_choices.setVisibility(View.INVISIBLE);
    }

        private void initializeBoard(){
            kingb = new Raja(false);
            kingw = new Raja(true);

            queenb= new rani(false);
            queenw= new rani(true);

            bishopb1=new vazeer(false);
            bishopb2=new vazeer(false);
            bishopw1=new vazeer(true);
            bishopw2=new vazeer(true);

            knightb1=new ghod(false);
            knightb2=new ghod(false);
            knightw1=new ghod(true);
            knightw2=new ghod(true);

            rookb1=new haathi(false);
            rookb2=new haathi(false);
            rookw1=new haathi(true);
            rookw2=new haathi(true);

            pawnb1=new pyada(false);
            pawnb2=new pyada(false);
            pawnb3=new pyada(false);
            pawnb4=new pyada(false);
            pawnb5=new pyada(false);
            pawnb6=new pyada(false);
            pawnb7=new pyada(false);
            pawnb8=new pyada(false);

            pawnw1=new pyada(true);
            pawnw2=new pyada(true);
            pawnw3=new pyada(true);
            pawnw4=new pyada(true);
            pawnw5=new pyada(true);
            pawnw6=new pyada(true);
            pawnw7=new pyada(true);
            pawnw8=new pyada(true);

            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    brd[i][j]=new jagah(null);
                    brd2[i][j]=new jagah(null);
                }
            }

            brd[0][7].sPiece(rookw1);
            brd[7][7].sPiece(rookw2);
            brd[1][7].sPiece(knightw1);
            brd[6][7].sPiece(knightw2);
            brd[2][7].sPiece(bishopw1);
            brd[5][7].sPiece(bishopw2);
            brd[3][7].sPiece(queenw);
            brd[4][7].sPiece(kingw);

            brd[0][6].sPiece(pawnw1);
            brd[1][6].sPiece(pawnw2);
            brd[2][6].sPiece(pawnw3);
            brd[3][6].sPiece(pawnw4);
            brd[4][6].sPiece(pawnw5);
            brd[5][6].sPiece(pawnw6);
            brd[6][6].sPiece(pawnw7);
            brd[7][6].sPiece(pawnw8);

            brd[0][0].sPiece(rookb1);
            brd[7][0].sPiece(rookb2);
            brd[1][0].sPiece(knightb1);
            brd[6][0].sPiece(knightb2);
            brd[2][0].sPiece(bishopb1);
            brd[5][0].sPiece(bishopb2);
            brd[3][0].sPiece(queenb);
            brd[4][0].sPiece(kingb);

            brd[0][1].sPiece(pawnb1);
            brd[1][1].sPiece(pawnb2);
            brd[2][1].sPiece(pawnb3);
            brd[3][1].sPiece(pawnb4);
            brd[4][1].sPiece(pawnb5);
            brd[5][1].sPiece(pawnb6);
            brd[6][1].sPiece(pawnb7);
            brd[7][1].sPiece(pawnb8);

            DisplayBoard[0][0]=(TextView)findViewById(R.id.R00);
            DisplayBg[0][0]=(TextView)findViewById(R.id.R000);
            DisplayBoard[1][0]=(TextView)findViewById(R.id.R10);
            DisplayBg[1][0]=(TextView)findViewById(R.id.R010);
            DisplayBoard[2][0]=(TextView)findViewById(R.id.R20);
            DisplayBg[2][0]=(TextView)findViewById(R.id.R020);
            DisplayBoard[3][0]=(TextView)findViewById(R.id.R30);
            DisplayBg[3][0]=(TextView)findViewById(R.id.R030);
            DisplayBoard[4][0]=(TextView)findViewById(R.id.R40);
            DisplayBg[4][0]=(TextView)findViewById(R.id.R040);
            DisplayBoard[5][0]=(TextView)findViewById(R.id.R50);
            DisplayBg[5][0]=(TextView)findViewById(R.id.R050);
            DisplayBoard[6][0]=(TextView)findViewById(R.id.R60);
            DisplayBg[6][0]=(TextView)findViewById(R.id.R060);
            DisplayBoard[7][0]=(TextView)findViewById(R.id.R70);
            DisplayBg[7][0]=(TextView)findViewById(R.id.R070);

            DisplayBoard[0][1]=(TextView)findViewById(R.id.R01);
            DisplayBg[0][1]=(TextView)findViewById(R.id.R001);
            DisplayBoard[1][1]=(TextView)findViewById(R.id.R11);
            DisplayBg[1][1]=(TextView)findViewById(R.id.R011);
            DisplayBoard[2][1]=(TextView)findViewById(R.id.R21);
            DisplayBg[2][1]=(TextView)findViewById(R.id.R021);
            DisplayBoard[3][1]=(TextView)findViewById(R.id.R31);
            DisplayBg[3][1]=(TextView)findViewById(R.id.R031);
            DisplayBoard[4][1]=(TextView)findViewById(R.id.R41);
            DisplayBg[4][1]=(TextView)findViewById(R.id.R041);
            DisplayBoard[5][1]=(TextView)findViewById(R.id.R51);
            DisplayBg[5][1]=(TextView)findViewById(R.id.R051);
            DisplayBoard[6][1]=(TextView)findViewById(R.id.R61);
            DisplayBg[6][1]=(TextView)findViewById(R.id.R061);
            DisplayBoard[7][1]=(TextView)findViewById(R.id.R71);
            DisplayBg[7][1]=(TextView)findViewById(R.id.R071);

            DisplayBoard[0][2]=(TextView)findViewById(R.id.R02);
            DisplayBg[0][2]=(TextView)findViewById(R.id.R002);
            DisplayBoard[1][2]=(TextView)findViewById(R.id.R12);
            DisplayBg[1][2]=(TextView)findViewById(R.id.R012);
            DisplayBoard[2][2]=(TextView)findViewById(R.id.R22);
            DisplayBg[2][2]=(TextView)findViewById(R.id.R022);
            DisplayBoard[3][2]=(TextView)findViewById(R.id.R32);
            DisplayBg[3][2]=(TextView)findViewById(R.id.R032);
            DisplayBoard[4][2]=(TextView)findViewById(R.id.R42);
            DisplayBg[4][2]=(TextView)findViewById(R.id.R042);
            DisplayBoard[5][2]=(TextView)findViewById(R.id.R52);
            DisplayBg[5][2]=(TextView)findViewById(R.id.R052);
            DisplayBoard[6][2]=(TextView)findViewById(R.id.R62);
            DisplayBg[6][2]=(TextView)findViewById(R.id.R062);
            DisplayBoard[7][2]=(TextView)findViewById(R.id.R72);
            DisplayBg[7][2]=(TextView)findViewById(R.id.R072);

            DisplayBoard[0][3]=(TextView)findViewById(R.id.R03);
            DisplayBg[0][3]=(TextView)findViewById(R.id.R003);
            DisplayBoard[1][3]=(TextView)findViewById(R.id.R13);
            DisplayBg[1][3]=(TextView)findViewById(R.id.R013);
            DisplayBoard[2][3]=(TextView)findViewById(R.id.R23);
            DisplayBg[2][3]=(TextView)findViewById(R.id.R023);
            DisplayBoard[3][3]=(TextView)findViewById(R.id.R33);
            DisplayBg[3][3]=(TextView)findViewById(R.id.R033);
            DisplayBoard[4][3]=(TextView)findViewById(R.id.R43);
            DisplayBg[4][3]=(TextView)findViewById(R.id.R043);
            DisplayBoard[5][3]=(TextView)findViewById(R.id.R53);
            DisplayBg[5][3]=(TextView)findViewById(R.id.R053);
            DisplayBoard[6][3]=(TextView)findViewById(R.id.R63);
            DisplayBg[6][3]=(TextView)findViewById(R.id.R063);
            DisplayBoard[7][3]=(TextView)findViewById(R.id.R73);
            DisplayBg[7][3]=(TextView)findViewById(R.id.R073);

            DisplayBoard[0][4]=(TextView)findViewById(R.id.R04);
            DisplayBg[0][4]=(TextView)findViewById(R.id.R004);
            DisplayBoard[1][4]=(TextView)findViewById(R.id.R14);
            DisplayBg[1][4]=(TextView)findViewById(R.id.R014);
            DisplayBoard[2][4]=(TextView)findViewById(R.id.R24);
            DisplayBg[2][4]=(TextView)findViewById(R.id.R024);
            DisplayBoard[3][4]=(TextView)findViewById(R.id.R34);
            DisplayBg[3][4]=(TextView)findViewById(R.id.R034);
            DisplayBoard[4][4]=(TextView)findViewById(R.id.R44);
            DisplayBg[4][4]=(TextView)findViewById(R.id.R044);
            DisplayBoard[5][4]=(TextView)findViewById(R.id.R54);
            DisplayBg[5][4]=(TextView)findViewById(R.id.R054);
            DisplayBoard[6][4]=(TextView)findViewById(R.id.R64);
            DisplayBg[6][4]=(TextView)findViewById(R.id.R064);
            DisplayBoard[7][4]=(TextView)findViewById(R.id.R74);
            DisplayBg[7][4]=(TextView)findViewById(R.id.R074);

            DisplayBoard[0][5]=(TextView)findViewById(R.id.R05);
            DisplayBg[0][5]=(TextView)findViewById(R.id.R005);
            DisplayBoard[1][5]=(TextView)findViewById(R.id.R15);
            DisplayBg[1][5]=(TextView)findViewById(R.id.R015);
            DisplayBoard[2][5]=(TextView)findViewById(R.id.R25);
            DisplayBg[2][5]=(TextView)findViewById(R.id.R025);
            DisplayBoard[3][5]=(TextView)findViewById(R.id.R35);
            DisplayBg[3][5]=(TextView)findViewById(R.id.R035);
            DisplayBoard[4][5]=(TextView)findViewById(R.id.R45);
            DisplayBg[4][5]=(TextView)findViewById(R.id.R045);
            DisplayBoard[5][5]=(TextView)findViewById(R.id.R55);
            DisplayBg[5][5]=(TextView)findViewById(R.id.R055);
            DisplayBoard[6][5]=(TextView)findViewById(R.id.R65);
            DisplayBg[6][5]=(TextView)findViewById(R.id.R065);
            DisplayBoard[7][5]=(TextView)findViewById(R.id.R75);
            DisplayBg[7][5]=(TextView)findViewById(R.id.R075);

            DisplayBoard[0][6]=(TextView)findViewById(R.id.R06);
            DisplayBg[0][6]=(TextView)findViewById(R.id.R006);
            DisplayBoard[1][6]=(TextView)findViewById(R.id.R16);
            DisplayBg[1][6]=(TextView)findViewById(R.id.R016);
            DisplayBoard[2][6]=(TextView)findViewById(R.id.R26);
            DisplayBg[2][6]=(TextView)findViewById(R.id.R026);
            DisplayBoard[3][6]=(TextView)findViewById(R.id.R36);
            DisplayBg[3][6]=(TextView)findViewById(R.id.R036);
            DisplayBoard[4][6]=(TextView)findViewById(R.id.R46);
            DisplayBg[4][6]=(TextView)findViewById(R.id.R046);
            DisplayBoard[5][6]=(TextView)findViewById(R.id.R56);
            DisplayBg[5][6]=(TextView)findViewById(R.id.R056);
            DisplayBoard[6][6]=(TextView)findViewById(R.id.R66);
            DisplayBg[6][6]=(TextView)findViewById(R.id.R066);
            DisplayBoard[7][6]=(TextView)findViewById(R.id.R76);
            DisplayBg[7][6]=(TextView)findViewById(R.id.R076);

            DisplayBoard[0][7]=(TextView)findViewById(R.id.R07);
            DisplayBg[0][7]=(TextView)findViewById(R.id.R007);
            DisplayBoard[1][7]=(TextView)findViewById(R.id.R17);
            DisplayBg[1][7]=(TextView)findViewById(R.id.R017);
            DisplayBoard[2][7]=(TextView)findViewById(R.id.R27);
            DisplayBg[2][7]=(TextView)findViewById(R.id.R027);
            DisplayBoard[3][7]=(TextView)findViewById(R.id.R37);
            DisplayBg[3][7]=(TextView)findViewById(R.id.R037);
            DisplayBoard[4][7]=(TextView)findViewById(R.id.R47);
            DisplayBg[4][7]=(TextView)findViewById(R.id.R047);
            DisplayBoard[5][7]=(TextView)findViewById(R.id.R57);
            DisplayBg[5][7]=(TextView)findViewById(R.id.R057);
            DisplayBoard[6][7]=(TextView)findViewById(R.id.R67);
            DisplayBg[6][7]=(TextView)findViewById(R.id.R067);
            DisplayBoard[7][7]=(TextView)findViewById(R.id.R77);
            DisplayBg[7][7]=(TextView)findViewById(R.id.R077);

            for(int g=0;g<8;g++)
            {
                for(int h=0;h<8;h++)
                {
                    if(brd[g][h].gPiece()==null)
                        brd2[g][h].sPiece(null);
                    else
                        brd2[g][h].sPiece(brd[g][h].gPiece());
                }
            }
            numberofMoves=0;
            selec=false;
            FPTurn=true;
            setBoard();
        }

        private void setBoard() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    p_handler p=brd[i][j].gPiece();
                    int x;
                    if(brd[i][j].gPiece()!=null){
                        if(p instanceof Raja) x=0;
                        else if(p instanceof rani) x=1;
                        else if(p instanceof haathi) x=2;
                        else if(p instanceof vazeer) x=3;
                        else if(p instanceof ghod) x=4;
                        else if(p instanceof pyada) x=5;
                        else x=6;

                        switch(x){
                            case 0:
                                if(p.iwhite())
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.kingw);
                                else
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.kingb);
                                break;
                            case 1:
                                if(p.iwhite())
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.queenw);
                                else
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.queenb);
                                break;
                            case 2:
                                if(p.iwhite())
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.rookw);
                                else
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.rookb);
                                break;
                            case 3:
                                if(p.iwhite())
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.bishopw);
                                else
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.bishopb);
                                break;
                            case 4:
                                if(p.iwhite())
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.knightw);
                                else
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.knightb);
                                break;
                            case 5:
                                if(p.iwhite())
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.pawnw);
                                else
                                    DisplayBoard[i][j].setBackgroundResource(R.drawable.pawnb);
                                break;
                            default:
                        }
                    }
                    else
                        DisplayBoard[i][j].setBackgroundResource(0);
                }
            }
            iskingindanger();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.R00:
                    clickedPosition = new Cnates(0, 0);
                    break;
                case R.id.R10:
                    clickedPosition.setx(1);
                    clickedPosition.sety(0);
                    break;
                case R.id.R20:
                    clickedPosition.setx(2);
                    clickedPosition.sety(0);
                    break;
                case R.id.R30:
                    clickedPosition.setx(3);
                    clickedPosition.sety(0);
                    break;
                case R.id.R40:
                    clickedPosition.setx(4);
                    clickedPosition.sety(0);
                    break;
                case R.id.R50:
                    clickedPosition.setx(5);
                    clickedPosition.sety(0);
                    break;
                case R.id.R60:
                    clickedPosition.setx(6);
                    clickedPosition.sety(0);
                    break;
                case R.id.R70:
                    clickedPosition.setx(7);
                    clickedPosition.sety(0);
                    break;

                case R.id.R01:
                    clickedPosition.setx(0);
                    clickedPosition.sety(1);
                    break;
                case R.id.R11:
                    clickedPosition.setx(1);
                    clickedPosition.sety(1);
                    break;
                case R.id.R21:
                    clickedPosition.setx(2);
                    clickedPosition.sety(1);
                    break;
                case R.id.R31:
                    clickedPosition.setx(3);
                    clickedPosition.sety(1);
                    break;
                case R.id.R41:
                    clickedPosition.setx(4);
                    clickedPosition.sety(1);
                    break;
                case R.id.R51:
                    clickedPosition.setx(5);
                    clickedPosition.sety(1);
                    break;
                case R.id.R61:
                    clickedPosition.setx(6);
                    clickedPosition.sety(1);
                    break;
                case R.id.R71:
                    clickedPosition.setx(7);
                    clickedPosition.sety(1);
                    break;

                case R.id.R02:
                    clickedPosition.setx(0);
                    clickedPosition.sety(2);
                    break;
                case R.id.R12:
                    clickedPosition.setx(1);
                    clickedPosition.sety(2);
                    break;
                case R.id.R22:
                    clickedPosition.setx(2);
                    clickedPosition.sety(2);
                    break;
                case R.id.R32:
                    clickedPosition.setx(3);
                    clickedPosition.sety(2);
                    break;
                case R.id.R42:
                    clickedPosition.setx(4);
                    clickedPosition.sety(2);
                    break;
                case R.id.R52:
                    clickedPosition.setx(5);
                    clickedPosition.sety(2);
                    break;
                case R.id.R62:
                    clickedPosition.setx(6);
                    clickedPosition.sety(2);
                    break;
                case R.id.R72:
                    clickedPosition.setx(7);
                    clickedPosition.sety(2);
                    break;

                case R.id.R03:
                    clickedPosition.setx(0);
                    clickedPosition.sety(3);
                    break;
                case R.id.R13:
                    clickedPosition.setx(1);
                    clickedPosition.sety(3);
                    break;
                case R.id.R23:
                    clickedPosition.setx(2);
                    clickedPosition.sety(3);
                    break;
                case R.id.R33:
                    clickedPosition.setx(3);
                    clickedPosition.sety(3);
                    break;
                case R.id.R43:
                    clickedPosition.setx(4);
                    clickedPosition.sety(3);
                    break;
                case R.id.R53:
                    clickedPosition.setx(5);
                    clickedPosition.sety(3);
                    break;
                case R.id.R63:
                    clickedPosition.setx(6);
                    clickedPosition.sety(3);
                    break;
                case R.id.R73:
                    clickedPosition.setx(7);
                    clickedPosition.sety(3);
                    break;

                case R.id.R04:
                    clickedPosition.setx(0);
                    clickedPosition.sety(4);
                    break;
                case R.id.R14:
                    clickedPosition.setx(1);
                    clickedPosition.sety(4);
                    break;
                case R.id.R24:
                    clickedPosition.setx(2);
                    clickedPosition.sety(4);
                    break;
                case R.id.R34:
                    clickedPosition.setx(3);
                    clickedPosition.sety(4);
                    break;
                case R.id.R44:
                    clickedPosition.setx(4);
                    clickedPosition.sety(4);
                    break;
                case R.id.R54:
                    clickedPosition.setx(5);
                    clickedPosition.sety(4);
                    break;
                case R.id.R64:
                    clickedPosition.setx(6);
                    clickedPosition.sety(4);
                    break;
                case R.id.R74:
                    clickedPosition.setx(7);
                    clickedPosition.sety(4);
                    break;

                case R.id.R05:
                    clickedPosition.setx(0);
                    clickedPosition.sety(5);
                    break;
                case R.id.R15:
                    clickedPosition.setx(1);
                    clickedPosition.sety(5);
                    break;
                case R.id.R25:
                    clickedPosition.setx(2);
                    clickedPosition.sety(5);
                    break;
                case R.id.R35:
                    clickedPosition.setx(3);
                    clickedPosition.sety(5);
                    break;
                case R.id.R45:
                    clickedPosition.setx(4);
                    clickedPosition.sety(5);
                    break;
                case R.id.R55:
                    clickedPosition.setx(5);
                    clickedPosition.sety(5);
                    break;
                case R.id.R65:
                    clickedPosition.setx(6);
                    clickedPosition.sety(5);
                    break;
                case R.id.R75:
                    clickedPosition.setx(7);
                    clickedPosition.sety(5);
                    break;

                case R.id.R06:
                    clickedPosition.setx(0);
                    clickedPosition.sety(6);
                    break;
                case R.id.R16:
                    clickedPosition.setx(1);
                    clickedPosition.sety(6);
                    break;
                case R.id.R26:
                    clickedPosition.setx(2);
                    clickedPosition.sety(6);
                    break;
                case R.id.R36:
                    clickedPosition.setx(3);
                    clickedPosition.sety(6);
                    break;
                case R.id.R46:
                    clickedPosition.setx(4);
                    clickedPosition.sety(6);
                    break;
                case R.id.R56:
                    clickedPosition.setx(5);
                    clickedPosition.sety(6);
                    break;
                case R.id.R66:
                    clickedPosition.setx(6);
                    clickedPosition.sety(6);
                    break;
                case R.id.R76:
                    clickedPosition.setx(7);
                    clickedPosition.sety(6);
                    break;

                case R.id.R07:
                    clickedPosition.setx(0);
                    clickedPosition.sety(7);
                    break;
                case R.id.R17:
                    clickedPosition.setx(1);
                    clickedPosition.sety(7);
                    break;
                case R.id.R27:
                    clickedPosition.setx(2);
                    clickedPosition.sety(7);
                    break;
                case R.id.R37:
                    clickedPosition.setx(3);
                    clickedPosition.sety(7);
                    break;
                case R.id.R47:
                    clickedPosition.setx(4);
                    clickedPosition.sety(7);
                    break;
                case R.id.R57:
                    clickedPosition.setx(5);
                    clickedPosition.sety(7);
                    break;
                case R.id.R67:
                    clickedPosition.setx(6);
                    clickedPosition.sety(7);
                    break;
                case R.id.R77:
                    clickedPosition.setx(7);
                    clickedPosition.sety(7);
                    break;
            }

            if (!selec) {
                if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece() == null) {
                    iskingindanger();
                    return;
                } else {
                    if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece() != FPTurn) {
                        iskingindanger();
                        return;
                    } else {
                        LoC.clear();
                        LoC = brd[clickedPosition.getx()][clickedPosition.gety()].gPiece().A_moves(clickedPosition, brd);
                        DisplayBg[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.color.colorSelected);
                        setColorAtAllowedPosition(LoC);
                        selec = true;
                    }
                }
            } else {
                if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece() == null) {
                    if (moveIsAllowed(LoC, clickedPosition)) {
                        saveBoard();
                        if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece() instanceof Raja) {
                            if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece().iwhite() != FPTurn) {
                                game_over.setVisibility(View.VISIBLE);
                            }
                        }
                        brd[clickedPosition.getx()][clickedPosition.gety()].sPiece();
                        (brd[lastpos.getx()][lastpos.gety()].gPiece());
                        brd[lastpos.getx()][lastpos.gety()].sPiece(null);

                        iskingindanger();
                        resetColorAtAllowedPosition(LoC);
                        DisplayBoard[lastpos.getx()][lastpos.gety()].setBackgroundResource(0);
                        resetColorAtLastPosition(lastpos);
                        selec = false;
                        FPTurn = !FPTurn;
                        checkForPawn();
                    } else {
                        resetColorAtLastPosition(lastpos);
                        resetColorAtAllowedPosition(LoC);
                        selec = false;
                    }
                } else {
                    if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece() == null) {
                        iskingindanger();
                        return;
                    } else {
                        if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece().iwhite() != FPTurn) {
                            if (moveIsAllowed(LoC, clickedPosition)) {
                                saveBoard();
                                if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece() instanceof Raja) {
                                    if (brd[clickedPosition.getx()][clickedPosition.gety()].gPiece().iwhite() != FPTurn) {
                                        game_over.setVisibility(View.VISIBLE);
                                    }
                                }
                                brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(brd[lastpos.getx()][lastpos.gety()].gPiece());
                                brd[lastpos.getx()][lastpos.gety()].sPiece(null);

                                resetColorAtAllowedPosition(LoC);
                                DisplayBoard[lastpos.getx()][lastpos.gety()].setBackgroundResource(0);
                                resetColorAtLastPosition(lastpos);

                                selec = false;
                                FPTurn = !FPTurn;
                                checkForPawn();
                            } else {
                                resetColorAtLastPosition(lastpos);
                                resetColorAtAllowedPosition(LoC);
                                selec = false;
                            }
                        } else {
                            resetColorAtLastPosition(lastpos);
                            resetColorAtAllowedPosition(LoC);

                            LoC.clear();
                            LoC = brd[clickedPosition.getx()][clickedPosition.gety()].gPiece().A_moves(clickedPosition, brd);
                            DisplayBg[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.color.colorSelected);
                            setColorAtAllowedPosition(LoC);
                            selec = true;
                        }

                    }
                }
            }

            iskingindanger();
            lastpos = new Cnates(clickedPosition.getx(), clickedPosition.gety());
            setBoard();
        }

        public void saveBoard(){
            numberofMoves++;
            LastMoves.add(numberofMoves-1,brd2);

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    LastMoves.get(numberofMoves-1)[i][j] = new jagah(null);
                }
            }

            for(int g=0;g<8;g++){
                for(int h=0;h<8;h++){
                    if(brd[g][h].gPiece()==null)
                        LastMoves.get(numberofMoves-1)[g][h].sPiece(null);
                    else
                        LastMoves.get(numberofMoves-1)[g][h].sPiece(brd[g][h].gPiece());
                }
            }
        }

        public void undo(View v){
            if(numberofMoves>0){
                for(int g=0;g<8;g++){
                    for(int h=0;h<8;h++){
                        if(LastMoves.get(numberofMoves-1)[g][h].gPiece()==null){
                            brd[g][h].sPiece(null);
                        }
                        else
                        {
                            brd[g][h].sPiece(LastMoves.get(numberofMoves-1)[g][h].gPiece());
                        }
                    }
                }
                numberofMoves--;

                setBoard();
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            DisplayBg[i][j].setBackgroundResource(R.color.colorBoardDark);
                        }
                        else
                        {
                            DisplayBg[i][j].setBackgroundResource(R.color.colorBoardLight);
                        }
                    }
                }
                iskingindanger();
                FPTurn = !FPTurn;
                game_over.setVisibility(View.INVISIBLE);
            }
        }

    public void pawnChoice(View v){
        int x = v.getId();
        switch (x){
            case R.id.pawn_queen :
                if(clickedPosition.gety() == 0){
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new rani(true));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.wqueen);
                }else{
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new rani(false));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.bqueen);
                }
                break;
            case R.id.pawn_rook :
                if(clickedPosition.gety() == 0){
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new haathi(true));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.wrook);
                }else{
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new haathi(false));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.brook);
                }
                break;
            case R.id.pawn_bishop :
                if(clickedPosition.gety() == 0){
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new vazeer(true));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.wbishop);
                }else{
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new vazeer(false));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.bbishop);
                }
                break;
            case R.id.pawn_knight :
                if(clickedPosition.gety() == 0){
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new ghod(true));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.wknight);
                }else{
                    brd[clickedPosition.getx()][clickedPosition.gety()].sPiece(new ghod(false));
                    DisplayBoard[clickedPosition.getx()][clickedPosition.gety()].setBackgroundResource(R.drawable.bknight);

                }
                break;
        }
        pawn_choices.setVisibility(View.INVISIBLE);
    }

    private void resetColorAtAllowedPosition(ArrayList<Cnates> listOfCoordinates) {
        for(int i=0; i<listOfCoordinates.size(); i++){
            if((listOfCoordinates.get(i).getx() + listOfCoordinates.get(i).gety())%2==0){
                DisplayBg[listOfCoordinates.get(i).getx()][listOfCoordinates.get(i).gety()].setBackgroundResource(R.color.colorBoardDark);
            }else {
                DisplayBg[listOfCoordinates.get(i).getx()][listOfCoordinates.get(i).gety()].setBackgroundResource(R.color.colorBoardLight);
            }
        }
    }

    void setColorAtAllowedPosition(ArrayList<Cnates> list){

        for(int i=0; i<list.size(); i++){
            if(brd[list.get(i).getx()][list.get(i).gety()].gPiece() == null){
                DisplayBg[list.get(i).getx()][list.get(i).gety()].setBackgroundResource(R.color.colorPositionAvailable);
            }else{
                DisplayBg[list.get(i).getx()][list.get(i).gety()].setBackgroundResource(R.color.colorDanger);
            }
        }
    }

    private boolean moveIsAllowed(ArrayList<Cnates> piece, Cnates coordinate) {
        Boolean Allowed = false;
        for(int i =0;i<piece.size();i++){
            if(piece.get(i).getx() == coordinate.getx()  &&  piece.get(i).gety() == coordinate.gety()){
                Allowed = true;
                break;
            }
        }
        return Allowed;
    }

    private void resetColorAtLastPosition(Cnates lastPos){
        if((lastPos.getx() + lastPos.gety())%2==0){
            DisplayBg[lastPos.getx()][lastPos.gety()].setBackgroundResource(R.color.colorBoardDark);
        }else {
            DisplayBg[lastPos.getx()][lastPos.gety()].setBackgroundResource(R.color.colorBoardLight);
        }
    }

    private void iskingindanger(){
        ArrayList<Cnates> List = new ArrayList<>();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(brd[i][j].gPiece() != null){
                    List.clear();
                    Cnates c = new Cnates(i,j);
                    List = brd[i][j].gPiece().A_Moves(c,brd);

                    for (int x=0;x<List.size();x++){
                        if(brd[List.get(x).getx()][List.get(x).gety()].gPiece() instanceof Raja){

                            if((List.get(x).getx()+List.get(x).gety())%2==0){
                                DisplayBg[List.get(x).getx()][List.get(x).gety()].setBackgroundResource(R.color.colorBoardDark);
                            }else{
                                DisplayBg[List.get(x).getx()][List.get(x).gety()].setBackgroundResource(R.color.colorBoardLight);
                            }

                            if(brd[i][j].gPiece().iwhite() != brd[List.get(x).getx()][List.get(x).gety()].gPiece().iwhite()){
                                DisplayBg[List.get(x).getx()][List.get(x).gety()].setBackgroundResource(R.color.colorKingInDanger);
                            }
                        }
                    }
                }
            }
        }
    }

    private void checkForPawn(){
        if(brd[clickedPosition.getx()][clickedPosition.gety()].gPiece() instanceof pyada){
            if(brd[clickedPosition.getx()][clickedPosition.gety()].gPiece().iwhite()){
                if(clickedPosition.gety() == 0){
                    pawn_choices.setVisibility(View.VISIBLE);
                }
            }else{
                if(clickedPosition.gety() == 7){
                    pawn_choices.setVisibility(View.VISIBLE);
                    pawn_choices.setRotation(180);
                }
            }
        }
        iskingindanger();
    }
}
    /*private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}