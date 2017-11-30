import javax.swing.*;

        import java.awt.*;

        import java.awt.event.*;

        import java.util.Random;

public class test extends JFrame {
    public static void main(String[] args) {

        boardSetUp newBoard = new boardSetUp();

        int Xaxis=0, boardsize;









        boardsize = Integer.parseInt(JOptionPane.showInputDialog("Please enter how many squares youd like on your board"));

        while (boardsize > 100 || boardsize < 20) {

            if (boardsize > 100) {

                JOptionPane.showMessageDialog(null, "im sorry but you cannot enter that many squares the max is 100", "error", JOptionPane.ERROR_MESSAGE);

                boardsize = Integer.parseInt(JOptionPane.showInputDialog("Please enter how many squares youd like on your board"));

            }//if boardsize

            if (boardsize < 40) {

                JOptionPane.showMessageDialog(null, "im sorry but you have to enter more squares the minimum amount is 40", "error", JOptionPane.ERROR_MESSAGE);

                boardsize = Integer.parseInt(JOptionPane.showInputDialog("Please enter how many squares youd like on your board"));

            }//if boardsize

        }//boardsize validation loop
        newBoard.setSpaces(SnL.retrivenewBoardsize(boardsize));

        newBoard.setXaxis(SnL.retriveXaxis(boardsize, Xaxis));

        newBoard.setYaxis(newBoard.getSpaces()/newBoard.getXaxis());


        int amount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of players"));

        while  (amount > 4 || amount < 2) {

            amount=Integer.parseInt(JOptionPane.showInputDialog(null,"im sorry but at least two and only four players can play", "error", JOptionPane.ERROR_MESSAGE));

        }


        player[] playerArray= new player[amount];
        String name, colourChoice;
        for (int x = 0; x < amount; x++) {
            name = JOptionPane.showInputDialog("Enter Name");

            colourChoice = JOptionPane.showInputDialog("Enter colour 'B' blue, 'R' red, 'Y' yellow, 'G' green ").toUpperCase();


            if (x==0) { colourChoice=SnL.colourValidation1(colourChoice);}
            if (x==1) { colourChoice=SnL.colourValidation2(colourChoice,playerArray[0].getColour());}
            if (x==2) { colourChoice=SnL.colourValidation3(colourChoice,playerArray[0].getColour(), playerArray[1].getColour());}
            if (x==3) { colourChoice=SnL.colourValidation4(colourChoice,playerArray[0].getColour(), playerArray[1].getColour(), playerArray[2].getColour());}


            if (x>=2)

                //validation for colour

                if (colourChoice.equals("B")) {
                    colourChoice = "B";
                }

            if (colourChoice.equals("R")) {
                colourChoice = "R";
            }

            if (colourChoice.equals("Y")) {
                colourChoice = "Y";
            }

            if (colourChoice.equals("G")) {
                colourChoice = "G";
            }


            playerArray[x]= new player(name, colourChoice, newBoard.getSpaces());



        }







        displayBoard d = new displayBoard(newBoard);











        boolean win = false;
        Random rand = new Random();

        ImageIcon one =new ImageIcon("src\\images\\one.png");
        ImageIcon two =new ImageIcon("src\\images\\two.png");
        ImageIcon three =new ImageIcon("src\\images\\three.png");
        ImageIcon four =new ImageIcon("src\\images\\four.png");
        ImageIcon five =new ImageIcon("src\\images\\five.png");
        ImageIcon six =new ImageIcon("src\\images\\six.png");
        ImageIcon winner =new ImageIcon("src\\images\\win.png");

        while (!win) {
            int turn=0;


            for (int y = 0; y < amount; y++) {







                int dice = rand.nextInt(6) + 1,pos=playerArray[y].getPosition();
                pos=pos-dice;
                if (pos==0){ JOptionPane.showMessageDialog((Component)null, "You got "+dice+" Congratulations you have won "+playerArray[y].getName(),"winner",JOptionPane.PLAIN_MESSAGE,winner);
                    System.exit(0);}

                else if (pos > 0) {

                    if (dice == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Your go " + playerArray[y].getName() + " you got " + dice + " your new score is " + (newBoard.getSpaces() - playerArray[y].getPosition() + dice),
                                "Dice", JOptionPane.INFORMATION_MESSAGE,
                                one);
                    }//https://stackoverflow.com/questions/13963392/add-image-to-joptionpane
                    if (dice == 2) {
                        JOptionPane.showMessageDialog(null,
                                "Your go " + playerArray[y].getName() + " you got " + dice + " your new score is " + (newBoard.getSpaces() - playerArray[y].getPosition() + dice),
                                "Dice", JOptionPane.INFORMATION_MESSAGE,
                                two);
                    }
                    if (dice == 3) {
                        JOptionPane.showMessageDialog(null,
                                "Your go " + playerArray[y].getName() + " you got " + dice + " your new score is " + (newBoard.getSpaces() - playerArray[y].getPosition() + dice),
                                "Dice", JOptionPane.INFORMATION_MESSAGE,
                                three);
                    }
                    if (dice == 4) {
                        JOptionPane.showMessageDialog(null,
                                "Your go " + playerArray[y].getName() + " you got " + dice + " your new score is " + (newBoard.getSpaces() - playerArray[y].getPosition() + dice),
                                "Dice", JOptionPane.INFORMATION_MESSAGE,
                                four);
                    }
                    if (dice == 5) {
                        JOptionPane.showMessageDialog(null,
                                "Your go " + playerArray[y].getName() + " you got " + dice + " your new score is " + (newBoard.getSpaces() - playerArray[y].getPosition() + dice),
                                "Dice", JOptionPane.INFORMATION_MESSAGE,
                                five);
                    }
                    if (dice == 6) {
                        JOptionPane.showMessageDialog(null,
                                "Your go " + playerArray[y].getName() + " you got " + dice + " your new score is " + (newBoard.getSpaces() - playerArray[y].getPosition() + dice),
                                "Dice", JOptionPane.INFORMATION_MESSAGE,
                                six);
                    }

                }
                else if (pos < 0){
                    JOptionPane.showMessageDialog((Component)null, "you got "+dice+" your score is greater than the boardsize "+newBoard.getSpaces()+" you have been sent back");
                    displayBoard.playerPanelArray[pos+dice].setBackground(Color.cyan);
                    pos= (pos)*(-1); }



                if (playerArray[y].getPosition()< newBoard.getSpaces()){displayBoard.playerPanelArray[pos+dice].setBackground(Color.cyan);}









                if (playerArray[y].getColour().equals("Y")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.yellow);

                }
                else if (playerArray[y].getColour().equals("G")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.green);

                }
                else if (playerArray[y].getColour().equals("B")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.blue);

                }

                else if (playerArray[y].getColour().equals("R")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.red);
                }
//my attempt to deal with two players landing on the same spot
               /* for (int c=0; c<amount; c++){
                    if(playerArray[c].getPosition()==playerArray[y].getPosition()&& y!=c && playerArray[y].getPosition()!=newBoard.getSpaces()) {
                        playerArray[c].setPosition(playerArray[c].getPosition()+dice);
                        if (playerArray[c].getColour().equals("Y")){
                            playerPanelArray[pos+dice].setBackground(Color.yellow);
                            JOptionPane.showMessageDialog((Component)null, "you've landed on the same spot as " +playerArray[c].getName()+ "\n"+playerArray[c].getName()+
                                    " you have to go to space "+(newBoard.getSpaces()-playerArray[c].getPosition()));
                        }
                        else if (playerArray[c].getColour().equals("G") ){
                            playerPanelArray[pos+dice].setBackground(Color.green);
                            JOptionPane.showMessageDialog((Component)null, "you've landed on the same spot as " +playerArray[c].getName()+ "\n"+playerArray[c].getName()+
                                    " you have to go to space "+(newBoard.getSpaces()-playerArray[c].getPosition()));
                        }
                        else if (playerArray[c].getColour().equals("B")){
                            playerPanelArray[pos+dice].setBackground(Color.blue);
                            JOptionPane.showMessageDialog((Component)null, "you've landed on the same spot as " +playerArray[c].getName()+ "\n"+playerArray[c].getName()+
                                    " you have to go to space "+(newBoard.getSpaces()-playerArray[c].getPosition()));
                        }
                        else if (playerArray[c].getColour().equals("R")){
                            playerPanelArray[pos+dice].setBackground(Color.red);
                            JOptionPane.showMessageDialog((Component)null, "you've landed on the same spot as " +playerArray[c].getName()+ "\n"+playerArray[c].getName()+
                                    " you have to go to space "+(newBoard.getSpaces()-playerArray[c].getPosition()));
                        }
                    }
                }*/



                playerArray[y].setPosition(pos);



                if (pos == (int)(newBoard.getSpaces()*.7)) {

                    pos=SnL.ladder1(pos,newBoard.getSpaces());
                    displayBoard.playerPanelArray[playerArray[y].getPosition()].setBackground(Color.cyan);
                    playerArray[y].setPosition(pos);
                }//changes the players position to they're position after the ladder

                if (pos == (int)(newBoard.getSpaces()*.38)) {

                    pos=SnL.snake1(pos,newBoard.getSpaces());
                    displayBoard.playerPanelArray[playerArray[y].getPosition()].setBackground(Color.cyan);
                    playerArray[y].setPosition(pos);
                }//changes the players position to they're position after the snake

                if (newBoard.getYaxis()>=4&&(pos == (int)(newBoard.getSpaces()*.33))){

                    pos=SnL.ladder2(pos,newBoard.getSpaces());
                    displayBoard.playerPanelArray[playerArray[y].getPosition()].setBackground(Color.cyan);
                    playerArray[y].setPosition(pos);
                }//changes the players position to they're position after the ladder

                if (newBoard.getYaxis()>=5&&(pos == (int)(newBoard.getSpaces()*.63))){

                    pos=SnL.snake2(pos,newBoard.getSpaces());
                    displayBoard.playerPanelArray[playerArray[y].getPosition()].setBackground(Color.cyan);
                    playerArray[y].setPosition(pos);
                }//changes the players position to they're position after the snake

                if (newBoard.getYaxis()>=6&&(pos == (int)(newBoard.getSpaces()*.44))){

                    pos=SnL.ladder3(pos,newBoard.getSpaces());
                    displayBoard.playerPanelArray[playerArray[y].getPosition()].setBackground(Color.cyan);
                    playerArray[y].setPosition(pos);
                }//changes the players position to they're position after the ladder

                if (newBoard.getYaxis()>=7&&(pos == (int)(newBoard.getSpaces()*.09))){

                    pos=SnL.snake3(pos,newBoard.getSpaces());
                    displayBoard.playerPanelArray[playerArray[y].getPosition()].setBackground(Color.cyan);
                    playerArray[y].setPosition(pos);
                }//changes the players position to they're position after the snake

                if (newBoard.getYaxis()>=8&&(pos == (int)(newBoard.getSpaces()*.83))){

                    pos=SnL.ladder4(pos,newBoard.getSpaces());
                    displayBoard.playerPanelArray[playerArray[y].getPosition()].setBackground(Color.cyan);
                    playerArray[y].setPosition(pos);

                }//changes the players position to they're position after the ladder



                if (playerArray[y].getColour().equals("Y")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.yellow);

                }//changes the space that the player is on to the colour of the player
                else if (playerArray[y].getColour().equals("G")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.green);

                }//changes the space that the player is on to the colour of the player
                else if (playerArray[y].getColour().equals("B")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.blue);

                }//changes the space that the player is on to the colour of the player

                else if (playerArray[y].getColour().equals("R")&&pos<newBoard.getSpaces()){

                    displayBoard.playerPanelArray[pos].setBackground(Color.red);

                }//changes the space that the player is on to the colour of the player





                turn++;
            }//end of for loop that goes through the turns of all the players
        }//end of while loop that loops every turn


    }//end of main
}//end of class

