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

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1000, 700);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(111);
    
    PImage spritsheet = loadImage("spritesheet.png");
    PImage missle = loadImage("missle.png");

    // create input for player one 
      if (upPressed) {
        fltPlayerOneY -= 1.5;
      } 
      if (downPressed) {
        fltPlayerOneY += 1.5;
      } 
      if (leftPressed){
        fltPlayerOneX -= 1.5;
      }
      if (rightPressed){
      fltPlayerOneX += 1.5; 
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
        fltPlayerTwoY -= 1.5;
      } 
      if (downPressedTwo) {
        fltPlayerTwoY += 1.5;
      } 
      if(leftPressedTwo) {
        fltPlayerTwoX -= 1.5;
      }
      if(rightPressedTwo) {
        fltPlayerTwoX += 1.5; 
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
      else if (keyCode == ENTER) {
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
      else if (key == ' ') {
        fireTwo = true;
      }

      // player 1 boundries
      if (fltPlayerOneX < 40) {
        fltPlayerOneX += 10;
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
      if (fltPlayerTwoX < 0) {
        fltPlayerTwoX = 0;
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
        else if (key == ' ') {
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
        else if (keyCode == ENTER) {
          fireOne = false;
        }
      }
    }



  // define other methods down here.