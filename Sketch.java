import processing.core.PApplet;
import processing.core.PImage;
import java.awt.Graphics2D;

public class Sketch extends PApplet {

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

// variables for player location 
float fltPlayerOneX = 150;
float fltPlayerOneY = 150;
float fltPlayerTwoX = 500;
float fltPlayerTwoY = 500;
float fltTankSpeedX = 2;
float fltTankSpeedY = 2;
float freeze = 0;

float fltTankWidth = 75;
float fltTankHeight = 85;

boolean gameStatus = false;

// imaged variables 
PImage imgTankOne;
PImage imgMissile;
PImage imgTankTwo;
PImage imgBackground;

float angleOne = 0;
float agnleTwo = 0;

public void settings() {
	// put your size call here
    size(1000, 700);
  }

  public void setup() {
    background(210, 255, 173);

    PImage spritsheet = loadImage("spritesheet.png");
    PImage desertBackground = loadImage("desert.jpeg");
    PImage missle = loadImage("missle.png");

    imgBackground = desertBackground.get(0,0,1000,700);

    imgTankOne = spritsheet.get(350, 119, 100, 140);
    imgTankOne.resize(100, 125);
    imgMissile = missle.get(375, 150, 100, 300);
    imgMissile.resize(15, 40);

    imgTankTwo = spritsheet.get(120, 110, 100, 140);
    imgTankTwo.resize(100, 125);
    imgMissile = missle.get(375, 150, 100, 300);
    imgMissile.resize(15, 40);
  }

  public void draw() {
    // load background 

    image(imgBackground, 0, 0);


    //if (gameStatus == true) {    
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
        fltTankSpeedX = 2;
        fltPlayerOneX += fltTankSpeedX; 
      }
      if (fireOne) {
        for (int i = 0; i < 1; i++) {
        image(imgMissile, fltPlayerOneX + 42, fltPlayerOneY + 100);
        }
      }
      image(imgTankOne, fltPlayerOneX, fltPlayerOneY);

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
      image(imgMissile, fltPlayerTwoX + 27, fltPlayerTwoY + 100);
      }
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
      if (fltPlayerOneX < -10) {
        fltTankSpeedX = 0;
        fltPlayerOneX = fltTankSpeedX;
      }
      else if (fltPlayerOneX > 920) {
        fltTankSpeedX = 0;
        fltPlayerOneX = 900;
      }
      if (fltPlayerOneY < -10) {
        fltPlayerOneY = 0;
      }
      else if (fltPlayerOneY > 610) {
        fltPlayerOneY = 580;
      }
      // player 2 boundries
      if (fltPlayerTwoX < -10) {
        fltPlayerTwoX = -9;
      }
      else if (fltPlayerTwoX > 940) {
        fltPlayerTwoX = 930;
      }
      if (fltPlayerTwoY < 0) {
        fltPlayerTwoY = 0;
      }
      else if (fltPlayerTwoY > 610) {
        fltPlayerTwoY = 580;
      }
      // tank collision 
      if (fltPlayerOneX == fltPlayerTwoX) {
        fltTankSpeedX = 0;
        fltPlayerOneX += fltTankSpeedX;
      }
      else {
        fltTankSpeedX = 2;
      }
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
      
      public void tankCollision() {
        
      }
    }

  // define other methods down here.