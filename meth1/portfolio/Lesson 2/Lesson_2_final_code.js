let ball; // variable to store our Ball object
let ball2; // variable for 2nd ball object

function setup() {
  createCanvas(400, 400);
  ball = new Ball(100, 100, 50, "#ff0000"); // assign the Ball object to the variable
  ball2 = new Ball(200, 200, 100, "#0000ff"); // assign the Ball object to 2nd variable
}

function draw() {
  background(220);
  ball.display(); // calls display method of Ball object
  ball2.display(); // calls display method for 2nd Ball object
  ball.move(); // calls move method of Ball object
  ball2.move(); // calls moves method of 2nd Ball object
}

// here is the code to make your own class
class Ball {
  // here is where we put all the attributes of our class
  constructor(x, y, size, c) {
    // What attributes will our ball have?
    // refer back to original sketch

    //x and y position
    this.x = x; // instance variable for x position
    this.y = y;
    // size
    this.size = size;
    // color
    this.color = c;
    // speed that it will move
    this.speed = 2;
  }

  // We also need methods.
  //What is our ball going to do?

  // subgoals
  // Ball will move across the canvas - x++
  // Ball will change direction when it hits side of canvas
  //. -  if (x > width || x < 0)  , speed = -speed
  // method name = move()
  // variables used - this.x, this.speed
  // write method in Class code
  // call method on Ball objects in draw function
  move() { // method for moving ball
     if(this.x > width || this.x < 0) { // if x position of ball object
                                        // is more than width or less than 0
      this.speed = -this.speed; // change the value of speed variable from
    }                           // negative to positive or vice versa
    this.x = this.x + this.speed;  // add value of speed variable to x
                                  //position
  }

  // we also need to display our ball on the canvas
  // which will also be a method
  display() {
    fill(this.color);
    ellipse(this.x, this.y, this.size);
  }
}
