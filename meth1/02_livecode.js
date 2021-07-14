//Aim: How to animate a bouncing ball?
// project link: https://editor.p5js.org/mrbombmusic/sketches/QXtFx1x-h

//3.
let x = 100;

//8.
let speed = 1;

//setup & createCanvas already included
function setup() {
  createCanvas(400, 400);
}

//draw & background already included
function draw() {
  background(220);

  //1. make an ellipse
  // start with hardcoding parameters
  //ellipse(100, 200, 30);

  //2. If I want the ellipse to move from the left side of the canvas to the right, which parameter do I need to change?

  // If I need a value that is going to change, what do I need to make? (variable) Say the value will "vary" if students have trouble answering.

  //3. declare and initialize variable for x axis parameter

  //4. replace x parameter with variable
  ellipse(x, 200, 50);

  //5. What can we do to increase the value of x
  //x = x + 1; // remember to comment out or remove after step 7

  // review how draw function works (as a loop);
  // predictions about what will happen.....
  // circle moves towards left side of screen but disappears
  // Who can explain what happened?

  //6. What do we want to happen? (ball changes direction when it gets to the right side)
  // Restate as a conditional statement
  if(x > width || x < 0) { //10. add || x < 10
    // x = x -1; // 6. 1st solution
    speed = -speed; // 9.
  }

  //7. Why does ball get stuck once it reaches the right side?
  // Allow time to discuss. talk through code. provide specific number values of x while iterating through code.

  // 8. declare and initialize new variable called speed

  // 9. provide solution for how to use speed variable
  // ask student to explain what is now happening
  x = x + speed;

  // get predictions
  // student may predict ball disappearing off left side. Ask for additional conditional
  // if no prediction, run code and discuss what we need when ball disappears off left side.

  //10. review compund conditional 'or' operator
  // add to conditional statement

  //extensions - how can we keep the whole ball on the canvas when it reaches a wall?
  // How can we also make it bounce off the top and bottom of the screen?

}
