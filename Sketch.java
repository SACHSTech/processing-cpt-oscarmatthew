import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	  
boolean upPressed = false;
boolean downPressed = false;
boolean leftPressed = false;
boolean rightPressed = false;
boolean fireOne = false;
boolean fireTwo = false;

boolean upPressedTwo = false;
boolean downPressedTwo = false;
boolean leftPressedTwo = false;
boolean rightPressedTwo = false;

float fltPlayerOneX = 150;
float fltPlayerOneY = 150;

float fltPlayerTwoX = 500;
float fltPlayerTwoY = 500;

boolean gameStatus = false;

public void settings() {
	// put your size call here
    size(1000, 700);
  }

  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {
    // load background 
    PImage desertBackground = loadImage("desert.jpeg");
    image(desertBackground, 0, 0);

    PImage spritsheet = loadImage("spritesheet.png");

    PImage missle = loadImage("missle.png");

    //if (gameStatus == true) {    
    // create input for player one 
      if (upPressed) {
        fltPlayerOneY -= 1.75;
      } 
      if (downPressed) {
        fltPlayerOneY += 1.75;
      } 
      if (leftPressed){
        fltPlayerOneX -= 1.75;
      }
      if (rightPressed){
      fltPlayerOneX += 1.75; 
      }
      if (fireOne) {
        PImage imgMissile;
        imgMissile = missle.get(375, 150, 100, 300);
        imgMissile.resize(15, 40);
        image(imgMissile, fltPlayerOneX + 42, fltPlayerOneY + 100);
      }
      PImage imgTankOne;
      imgTankOne = spritsheet.get(350, 119, 100, 140);
      imgTankOne.resize(100, 125);
      image(imgTankOne, fltPlayerOneX, fltPlayerOneY);


    // player two input 
      if (upPressedTwo) {
        fltPlayerTwoY -= 1.75;
      } 
      if (downPressedTwo) {
        fltPlayerTwoY += 1.75;
      } 
      if(leftPressedTwo) {
        fltPlayerTwoX -= 1.75;
      }
      if(rightPressedTwo) {
        fltPlayerTwoX += 1.75; 
      }
      if (fireTwo) {
        PImage imgMissile;
        imgMissile = missle.get(375, 150, 100, 300);
        imgMissile.resize(15, 40);
        image(imgMissile, fltPlayerTwoX + 27, fltPlayerTwoY + 100);
      }
      PImage imgTankTwo;
      imgTankTwo = spritsheet.get(120, 110, 100, 140);
      imgTankTwo.resize(100, 125);
      image(imgTankTwo, fltPlayerTwoX, fltPlayerTwoY);


      // create map boundry 
      fill(222);
      rect(450, 450, 100, 20);
      if (fltPlayerOneX > 410 && fltPlayerOneX < 550 && fltPlayerOneY > 410 && fltPlayerOneY < 470) {
          fltPlayerOneX -= 10;
        
      }
      if (fltPlayerOneX == fltPlayerTwoX - 40 && fltPlayerOneY == fltPlayerTwoY) {
        fltPlayerOneX -= 5;
      }
      }
   // }
  
    public void keyPressed() { 
      PImage spritsheet = loadImage("spritesheet.png");
      PImage missle = loadImage("missle.png");
      PImage imgTankOne;
      PImage imgMissile;

      // player two booleans
      if (keyCode == UP) {
        upPressedTwo = true;
      imgTankOne = spritsheet.get(20, 7, 100, 130);
      imgTankOne.resize(100, 125);
      image(imgTankOne, fltPlayerTwoX, fltPlayerTwoY);
      }
      else if (keyCode == DOWN) {
        downPressedTwo = true;
        imgTankOne = spritsheet.get(120, 110, 100, 140);
        imgTankOne.resize(100, 125);
        image(imgTankOne, fltPlayerTwoX, fltPlayerTwoY);
      }
      else if (keyCode == LEFT) {
        leftPressedTwo = true;
        imgTankOne = spritsheet.get(20, 120, 100, 100);
        imgTankOne.resize(110, 90);
        image(imgTankOne, fltPlayerTwoX - 25, fltPlayerTwoY);
      }
      else if (keyCode == RIGHT) {
        rightPressedTwo = true;
        imgTankOne = spritsheet.get(115, 20, 100, 100);
        imgTankOne.resize(110, 90);
        image(imgTankOne, fltPlayerTwoX - 5, fltPlayerTwoY);
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
      if (fltPlayerOneX < -10) {
        fltPlayerOneX = -9;
      }
      else if (fltPlayerOneX > 1000) {
        fltPlayerOneX = 1000;
      }
      if (fltPlayerOneY < 0) {
        fltPlayerOneY = 0;
      }
      else if (fltPlayerOneY > 700) {
        fltPlayerOneY = 700;
      }
      // player 2 boundries
      if (fltPlayerTwoX < -10) {
        fltPlayerTwoX = -9;
      }
      else if (fltPlayerTwoX > 1000) {
        fltPlayerTwoX = 1000;
      }
      if (fltPlayerTwoY < 0) {
        fltPlayerTwoY = 0;
      }
      else if (fltPlayerTwoY > 700) {
        fltPlayerTwoY = 700;
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
        else if (keyCode == ENTER) {
          fireTwo = false;
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
        else if (key == ' ') {
          fireOne = false;
        }
      }
    }

  // define other methods down here.