public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    stroke(0);
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    
  }

  void click(){
    if (dist(mouseX, mouseY, this.x, this.y) <= this.radius)
    {
      this.c = 0;
      selected = true;
    }
  }
  
  void collide(ArrayList<Cow> others)
  {
    colliding = false;
    for (Cow c : others)
    {
      if (dist(this.x, this.y, c.x, c.y) <= this.radius + c.radius)
      {
        colliding = true;
      }
    }
  }

}
