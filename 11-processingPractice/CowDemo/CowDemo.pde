ArrayList<Cow> particles;
void setup() {
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.display();
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   if (mouseButton == RIGHT)
   {
     particles.add(new Cow(20+(int)(Math.random()*30), mouseX, mouseY, random(6)-3, random(6)-3));
   }
   if (mouseButton == LEFT)
   {
     for (Cow c : particles)
     {
       c.click();
     }
   }
}

void keyPressed() {
  if (keyCode == 32)
  {
    particles.clear();
  }
}
