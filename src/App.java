import processing.core.PApplet;
import processing.core.PImage;

public class App extends PApplet {
    int windowX = 600;
    int windowY = 600;
    
    float sharkX, sharkY;  // Shark's position
    float sharkSize = 100;  // Size of the shark
    float speed = 3;        // Movement speed
    PImage shark;
    
    float circleX, circleY;  // Circle's position
    float circleSize = 15;   // Circle's size

    float angle = 0;  // Angle for rotation
    
    // Variables to store shark's direction of movement
    float sharkXDirection = 0;
    float sharkYDirection = 0;

    int score = 0;  // Variable to track the score

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(windowX, windowY);
    }

    public void setup() {
        // Initial position of the shark in the middle of the screen
        sharkX = width / 2 - sharkSize / 2;  // Adjusted to center the shark correctly
        sharkY = height / 2 - sharkSize / 2;
        
        // Load the shark image
        shark = loadImage("shark.png");

        // Set initial random position for the circle
        respawnCircle();
                
        // Set up text size for score display
        textSize(32);
        fill(255);  // White text for the score
    }

    public void draw() {
        background(0, 100, 255);  // Set background to blue 

        // Move the shark automatically in the direction it is currently facing
        sharkX += sharkXDirection * speed;
        sharkY += sharkYDirection * speed;

        // keep shark to move angles
        if (keyPressed) {
            if (keyCode == UP) {
                sharkXDirection = 0;
                sharkYDirection = -1;  // Move up
                angle = PI * 1.5f;  // Set angle to 270 degrees
            }
            if (keyCode == DOWN) {
                sharkXDirection = 0;
                sharkYDirection = 1;  // Move down
                angle = PI / 2;  // Set angle to 90 degrees
            }
            if (keyCode == LEFT) {
                sharkXDirection = -1;
                sharkYDirection = 0;  // Move left
                angle = PI;  // Set angle to 180 degrees
            }
            if (keyCode == RIGHT) {
                sharkXDirection = 1;
                sharkYDirection = 0;  // Move right
                angle = 0;  // Set angle to 0 degrees
            }
        }

        // Check if shark catches the circle
        if (dist(sharkX + sharkSize / 2, sharkY + sharkSize / 2, circleX, circleY) < sharkSize / 2 + circleSize / 2) {
            // If shark catches the circle, respawn the circle
            respawnCircle();
            score++;  // Increase score when circle is caught
        }

        // Draw the circle
        fill(255, 0, 0);  // red circle
        ellipse(circleX, circleY, circleSize, circleSize);

        // Draw the shark with rotation
        pushMatrix();  // Save the current transformation state
        translate(sharkX + sharkSize / 2, sharkY + sharkSize / 2);  // Move the origin to the center of the shark
        rotate(angle);  // Rotate the shark to face the direction
        imageMode(CENTER);  // Ensure the image is drawn from its center
        image(shark, 0, 0, sharkSize, sharkSize);  // Draw the shark at the translated position
        popMatrix();  // Restore the previous transformation state
    }
// Display the score
      { fill(255);  // Set text color to white
        text("Score: " + score, 10, 40);  // Draw score at top-left corner
    }

    // respawn the circle at a random position
    void respawnCircle() {
        circleX = random(circleSize / 2, width - circleSize / 2);  // Random x-position
        circleY = random(circleSize / 2, height - circleSize / 2); // Random y-position
    }
}
