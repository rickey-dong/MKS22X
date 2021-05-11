public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected = false;

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
    if (selected && colliding)
    {
      x += dx + dx;
      y += dy + dy;
    }
    else
    {
      x += dx;
      y += dy;
    }
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    noStroke();
    if (colliding)
    {
      fill(255,0,0,30);
    }
    else
    {
      fill(c);
    }
    ellipse(x, y, radius*2, radius*2);
    if (selected)
    {
      fill(255);
      stroke(255);
      circle(this.x + (this.radius/2), this.y - (this.radius/2), this.radius/3);
      circle(this.x - (this.radius/2), this.y - (this.radius/2), this.radius/3);
      fill(0);
      textSize(16);
      text("dx: "+this.dx+"\n"+"dy: "+this.dy, this.x+this.radius, this.y);
    }
  }

  void click(){
    if (dist(mouseX, mouseY, this.x, this.y) <= this.radius)
    {
      selected = !selected;
    }
  }
  
  void collide(ArrayList<Cow> others)
  {
    colliding = false;
    for (Cow c : others)
    {
      if (!this.equals(c))
      {
        if (dist(this.x, this.y, c.x, c.y) <= this.radius + c.radius)
        {
          colliding = true;
        }
      }
    }
  }
  void turn(float angle)
  {
    float velocity = (float) Math.sqrt((dx*dx)+(dy*dy));
    float ang = degrees(atan2(dy,dx));
    ang -= angle;
    dx = velocity * cos(radians(ang));
    dy = velocity * sin(radians(ang));
  }
  void changeSpeed(float dv)
  {
    float velocity = (float) Math.sqrt((dx*dx)+(dy*dy));
    float ang = degrees(atan2(dy,dx));
    velocity += dv;
    dx = velocity * cos(radians(ang));
    dy = velocity * sin(radians(ang));
  }
}
