import processing.core.PApplet;
import processing.core.PImage;

public class App extends PApplet {
    int windowX = 600;
    int windowY = 600;

    float sharkX, sharkY; // Shark's position
    float sharkSize = 100; // Size of the shark
    float speed = 2; // Movement speed
    PImage shark;

    float angle = 0; // Angle for rotation

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(windowX, windowY);
    }

    public void setup() {
        // set sharks to the middle of the screen
        sharkX = width / 2 - sharkSize / 2;
        sharkY = height / 2 - sharkSize / 2;

        // shark image
        shark = loadImage("shark.png");
    }

    public void draw() {
        background(0, 100, 255); // Set background to blue

        // Move the shark based on arrow key input and adjust the angle for rotation
        if (keyPressed) {
            if (keyCode == UP) {
                sharkY -= speed; // Move up
                angle = PI * 1.5f; // rotation 270 degrees
            }
            if (keyCode == DOWN) {
                sharkY += speed; // Move down
                angle = PI / 2; // rotation 90 degrees
            }
            if (keyCode == LEFT) {
                sharkX -= speed; // Move left
                angle = PI; // rotation 180 degrees
            }
            if (keyCode == RIGHT) {
                sharkX += speed; // Move right
                angle = 0; //
            }
        }

        // Draw the shark with rotation
        pushMatrix(); // Save the current transformation state
        translate(sharkX + sharkSize / 2, sharkY + sharkSize / 2); // Move the origin to the center of the shark
        rotate(angle); // Rotate the shark to face the direction
        imageMode(CENTER); // Ensure the image is drawn from its center
        image(shark, 0, 0, sharkSize, sharkSize); // Draw the shark at the translated position
        popMatrix(); // Restore the previous transformation state
    }
}
