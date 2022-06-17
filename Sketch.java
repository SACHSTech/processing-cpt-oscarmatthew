import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

public class Sketch extends PApplet {

  // load font
  PFont font;

  // booleans for keyboard input 
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  boolean upPressedTwo = false;
  boolean downPressedTwo = false;
  boolean leftPressedTwo = false;
  boolean rightPressedTwo = false;

  boolean fireOne = false;
  boolean fireTwo = false;

  boolean[] hideMissle = new boolean[25];

  // variables for player location 
  float fltPlayerOneX = 105;
  float fltPlayerOneY = 105;
  float fltPlayerTwoX = 750;
  float fltPlayerTwoY = 560;
  float fltTankSpeedX = 2;
  float fltTankSpeedY = 2;
  float fltPlayerOneLives = 3;
  float fltPlayerTwoLives = 3;

  // missle coordinates
  float missleXOne = fltPlayerOneX;
  float missleYOne = fltPlayerOneY;
  float missleXTwo = fltPlayerTwoX;
  float missleYTwo = fltPlayerTwoY;

  // tank and missle sizes 
  float fltTankOneWidth = 85;
  float fltTankeOneHeight = 72;
  float fltTankTwoWidth = 85;
  float fltTankeTWoHeight = 72;
  float fltMissleHeight = 25;
  float fltMissleWidth = 75;

  boolean gameStatus = true;

  // imaged variables 
  PImage imgTankOne;
  PImage imgMissileLeft;
  PImage imgMissileRight;
  PImage imgTankTwo;
  PImage imgBackground;

  public void settings() {
	  // put your size call here
      size(1000, 750);
  }

  /**call images and get their sizes */
  public void setup() {
    background(210, 255, 173);

    PImage spritsheet = loadImage("spritesheet.png");
    PImage desertBackground = loadImage("desert.jpeg");
    PImage missleRight = loadImage("missleOne.png");
    PImage missleLeft = loadImage("missletwo.png");

    imgBackground = desertBackground.get(0,0,1000,750);
    imgTankOne = spritsheet.get(360, 30, 100, 110);
    imgTankOne.resize(100, 125);
    imgMissileRight = missleRight.get(0, 100, 700, 300);
    imgMissileRight.resize(150, 75);
    imgTankTwo = spritsheet.get(7, 115, 100, 110);
    imgTankTwo.resize(100, 125);
    imgMissileLeft = missleLeft.get(0, 385, 700, 300);
    imgMissileLeft.resize(150, 75);

    // load font style
    //font = createFont("pixel.ttf", 10); // comment this out if font is not able to load (worked for my MacOS but did not work for my Windows 10 PC)
    //textFont(font); // comment this out if font is not able to load 
  }

  public void draw() {

    // set game status to true
    if (gameStatus == true) {

      // load background 
      image(imgBackground, 0, 0);

      // create middle barrier so players do not cross into each other's territory 
      fill(252, 207, 3); 
      rect(490, 0, 10, 750);

      // create input for player one 
      if (upPressed) {
        fltPlayerOneY -= fltTankSpeedY;
      } 
      if (downPressed) {
        fltPlayerOneY += fltTankSpeedY;
      } 
      if (leftPressed){

        fltPlayerOneX -= fltTankSpeedX;
      }
      if (rightPressed){
        fltPlayerOneX += fltTankSpeedX; 
      }
      // shoot missle when "fire" button is pressed
      if (fireOne)  {
        image(imgMissileRight, missleXOne + 40, fltPlayerOneY + 50);
          missleXOne += 20;
          missleYOne = fltPlayerOneY;
          System.out.println("\nx:"+ missleXOne);
          System.out.println("y:"+missleYOne);
          System.out.println("\ntankx:"+ fltPlayerTwoX);
          System.out.println("tanky:"+fltPlayerTwoY);

          // check if missle goes out the map
          if (missleXOne > 1000) {
            fireOne = false;
            missleXOne = fltPlayerOneX;            
          }

          // check if missle hits player 
          if (missleXOne >= fltPlayerTwoX && missleXOne <= fltPlayerTwoX + fltTankTwoWidth && missleYOne >= fltPlayerTwoY - 25 && missleYOne <= fltPlayerTwoY + fltTankeTWoHeight - 20) {
            fltPlayerTwoLives -= 1;
            fireOne = false;
            missleXOne = fltPlayerOneX;
          }
        }
        // draw tank
        image(imgTankOne, fltPlayerOneX, fltPlayerOneY);

      // create player lives and display it
      for (int i = 1; i <= fltPlayerOneLives; i++) {
        fill(233, 66, 245);
        rect(0 + i * 24, 15, 20, 20);   
        textSize(20);
        fill(0);
        text("PLAYER 1", 110, 32);   
      }

      // player two input 
      if (upPressedTwo) {
        fltPlayerTwoY -= fltTankSpeedY;
      } 
      if (downPressedTwo) {
        fltPlayerTwoY += fltTankSpeedY;
      } 
      if(leftPressedTwo) {
        fltPlayerTwoX -= fltTankSpeedX;
      }
      if(rightPressedTwo) {
        fltPlayerTwoX += fltTankSpeedX;
      }
      if (fireTwo) {
        image(imgMissileLeft, missleXTwo - 40, fltPlayerTwoY + 55);
          missleXTwo -= 20;
          missleYTwo = fltPlayerTwoY;
          System.out.println("\nx:"+ missleXTwo);
          System.out.println("y:"+missleYTwo);
          System.out.println("\ntankx:"+ fltPlayerOneX);
          System.out.println("tanky:"+fltPlayerOneY);

          // check if missles goes out the map
          if (missleXTwo < 0) {
            fireTwo = false;
            missleXTwo = fltPlayerTwoX;
          }
          // check if missle hits player
          if (missleXTwo >= fltPlayerOneX && missleXTwo <= fltPlayerOneX + fltTankTwoWidth && missleYTwo >= fltPlayerOneY - 25 && missleYTwo <= fltPlayerOneY + fltTankeTWoHeight - 20) {
            fltPlayerOneLives -= 1;
            fireTwo = false;
            missleXTwo = fltPlayerTwoX;
          }  
        }
        // draw tank        
        image(imgTankTwo, fltPlayerTwoX, fltPlayerTwoY);


      // create lives for player and display it 
      for (int i = 1; i <= fltPlayerTwoLives; i++) {
        fill(66, 224, 245);
        rect(885 + i * 24, 15, 20, 20);
        textSize(20);
        fill(255);
        text("PLAYER 2", 800, 32);
      }
      // end game when player lives run out
      if (fltPlayerOneLives <= 0 || fltPlayerTwoLives <= 0) {
        gameStatus = false;
      }
    }
    // display background according to which player won 
    else {
      background(255, 255, 0);
      textSize(70);
      if (fltPlayerOneLives <= 0) {
        fill(0);
        text("GAME OVER", 275, 350);
        text(" PLAYER 2 WINS", 225, 440);
      }
      else {
        fill(0);
        text("GAME OVER", 275, 350);
        text(" PLAYER 1 WINS", 225, 440);
      }
    }
  }
    /** handling multiple keys 
     * create booleans for player one 
     * create booleans for player two
    */
    public void keyPressed() { 

      // player two booleans
      if (keyCode == UP) {
        upPressedTwo = true;
      }
      else if (keyCode == DOWN) {
        downPressedTwo = true;
      }
      else if (keyCode == LEFT) {
        leftPressedTwo = true;
      }
      else if (keyCode == RIGHT) {
        rightPressedTwo = true;
      }
      else if (key == ' ') {
        fireOne = true;
      }

      // player one booleans 
      if (key == 'w') {
        upPressed = true;
      }
      else if (key == 's') {
        downPressed = true;
      }
      else if (key == 'a') {
        leftPressed = true;
      }
      else if (key == 'd') {
        rightPressed = true;
      }
      else if (keyCode == ENTER) {
        fireTwo = true;
      }

      // player 1 boundries
      if (fltPlayerOneX < 0) {
        fltPlayerOneX = 5; 
      }
      else if (fltPlayerOneX > 395) {
        fltPlayerOneX = 390;
      }
      if (fltPlayerOneY < -15) {
        fltPlayerOneY = -10;
      }
      else if (fltPlayerOneY > 650) {
        fltPlayerOneY = 645;
      }
      // player 2 boundries
      if (fltPlayerTwoX < 498) {
        fltPlayerTwoX = 503;
      }
      else if (fltPlayerTwoX > 900) {
        fltPlayerTwoX = 895;
      }
      if (fltPlayerTwoY < -15) {
        fltPlayerTwoY = -10;
      }
      else if (fltPlayerTwoY > 650) {
        fltPlayerTwoY = 645;
      }
      fill(255);
    }

    public void keyReleased() {
      // player two booleans 
        if (keyCode == UP) {
          upPressedTwo = false; 
        }
        else if (keyCode == DOWN) {
          downPressedTwo = false;
        }
        else if (keyCode == LEFT) {
          leftPressedTwo = false;
        }
        else if (keyCode == RIGHT) {
          rightPressedTwo = false;
        }

        // player one booleans 
        if (key == 'w') {
          upPressed = false;
        }
        else if (key == 's') {
          downPressed = false;
        }
        else if (key == 'a') {
          leftPressed = false;
        }
        else if (key == 'd') {
          rightPressed = false;
        }
      }
    }
