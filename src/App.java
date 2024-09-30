import processing.core.PApplet;

public class App extends PApplet {
    int windowX = 600;
    int windowY = 600;
    
    float sharkX, sharkY;  // Shark's position
    float sharkSize = 50;  // Size of the shark (for now a square or ellipse)
    float speed = 2;       // Movement speed

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(windowX, windowY);
    }

    public void setup() {
        // Initial position of the shark in the middle of the screen
        sharkX = width / 2;
        sharkY = height / 2;
    }

    public void draw() {
        background(0, 100, 255);  // Set background to blue 


    }
}
