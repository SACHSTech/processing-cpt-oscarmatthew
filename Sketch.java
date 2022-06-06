import processing.core.PApplet;

public class Sketch extends PApplet {
	  
boolean upPressed = false;
boolean downPressed = false;
boolean leftPressed = false;
boolean rightPressed = false;

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
    background(0);
    

    // create input for player one 
      if (upPressed) {
        fltPlayerOneY -= 2;
      } 
      if (downPressed) {
        fltPlayerOneY += 2;
      } 
      if(leftPressed){
        fltPlayerOneX -= 2;
      }
      if(rightPressed){
      fltPlayerOneX += 2; 
      }
      fill(255, 0, 0);
      rect(fltPlayerOneX, fltPlayerOneY, 40, 40);

    // player two input 
      if (upPressedTwo) {
        fltPlayerTwoY-=2;
      } 
      if (downPressedTwo) {
        fltPlayerTwoY+=2;
      } 
      if(leftPressedTwo) {
        fltPlayerTwoX-=2;
      }
      if(rightPressedTwo) {
        fltPlayerTwoX+=2; 
      }
      fill(0, 255, 0);
      rect(fltPlayerTwoX, fltPlayerTwoY, 40, 40);

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

      // player 1 boundries
      if (fltPlayerOneX < 0) {
        fltPlayerOneX = 0;
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



  // define other methods down here.