// import java.util.*;
// public class BurnTrees{
//   private int[][]map;
//   private int ticks;
//   private static int TREE = 2;
//   private static int FIRE = 1;
//   private static int ASH = 3;
//   private static int SPACE = 0;
//   private static int FRESH_FIRE = -1;
//   private static Frontier frontier;
//   /*DO NOT UPDATE THIS
//    *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
//    */
//   public int run(){
//                   // while(!done()){
//                   //   tick();
//                   // }
//     while (!done())
//     {
//       tick();
//     }
//     return getTicks();
//   }
// 
//   /*Initialize the simulation.
//    *If you add more instance variables you can add more here,
//    *otherwise it is complete
//    */
//   public BurnTrees(int width,int height, double density){
//     map = new int[height][width];
//     frontier = new Frontier();
//     for(int r=0; r<map.length; r++ )
//       for(int c=0; c<map[r].length; c++ )
//         if(Math.random() < density)
//            map[r][c]=2;
//     start();//set the left column on fire.
//   }
// 
//   /*Determine if the simulation is still burning
//    *@return false if any fires are still burning, true otherwise
//    */
//   public boolean done(){
//     //YOU MUST IMPLEMENT THIS
//     for (int row = 0; row < this.map.length; row++)
//     {
//       for (int col = 0; col < this.map[row].length; col++)
//       {
//         if (this.map[row][col] == FIRE)
//         {
//           return false;
//         }
//       }
//     }
//     return true;
//     //return frontier.size() == 0;
//   }
// 
// 
//   /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
//    *All existing fires spread new fires, and turn to ash
//    *new fires should remain fire, and not spread.
//    */
//   public void tick(){
//     //YOU MUST IMPLEMENT THIS
//               // for (int row = 0; row < this.map.length; row++)
//               // {
//               //   for (int col = 0; col < this.map[row].length; col++)
//               //   {
//               //     if (this.map[row][col] == FIRE)
//               //     {
//               //       spreadFire(row, col); //spread current fires around
//               //       this.map[row][col] = ASH; //current fires extinguish
//               //     }
//               //   }
//               // }
//               // for (int row = 0; row < this.map.length; row++)
//               // {
//               //   for (int col = 0; col < this.map[row].length; col++)
//               //   {
//               //     if (this.map[row][col] == FRESH_FIRE)
//               //     {
//               //       this.map[row][col] = FIRE; //converting the fresh fires to standard fires
//               //     }
//               //   }
//               // }
//     int[] originalFire;
//     int row;
//     int col;
//     while (frontier.size() != 0)
//     {
//       ticks++;
//       int numOfTimesToSpreadFire = frontier.size();
//       int iter = 0;
//       while (iter < numOfTimesToSpreadFire)
//       {
//         originalFire = frontier.remove();
//         row = originalFire[0];
//         col = originalFire[1];
//         spreadFire(row, col);
//         this.map[row][col] = ASH;
//         iter++;
//       }
//     }
//   }
// 
//   public void spreadFire(int r, int c)
//   {
//     //burn right
//     if (c+1 != this.map[r].length && this.map[r][c+1] == TREE)
//     {
//                   // this.map[r][c+1] = FRESH_FIRE;
//       this.map[r][c+1] = FIRE;
//       frontier.add(new int[] {r, c+1});
//     }
//     //burn left
//     if (c-1 != -1 && this.map[r][c-1] == TREE)
//     {
//                 // this.map[r][c-1] = FRESH_FIRE;
//       this.map[r][c-1] = FIRE;
//       frontier.add(new int[] {r, c-1});
//     }
//     //burn up
//     if (r-1 != -1 && this.map[r-1][c] == TREE)
//     {
//             // this.map[r-1][c] = FRESH_FIRE;
//       this.map[r-1][c] = FIRE;
//       frontier.add(new int[] {r-1, c});
//     }
//     //burn down
//     if (r+1 != this.map.length && this.map[r+1][c] == TREE)
//     {
//             // this.map[r+1][c] = FRESH_FIRE;
//       this.map[r+1][c] = FIRE;
//       frontier.add(new int[] {r+1, c});
//     }
//   }
// 
//   /*
//    *Sets the trees in the left column of the forest on fire
//    */
//   public void start(){
//     //If you add more instance variables you can add more here,
//     //otherwise it is complete.
//     for(int i = 0; i < map.length; i++){
//       if(map[i][0]==TREE){
//         map[i][0]=FIRE;
//         frontier.add(new int[] {i, 0});
//       }
//     }
//   }
// 
// 
// 
// 
// 
//   /*DO NOT UPDATE THIS*/
//   public int getTicks(){
//     return ticks;
//   }
// 
//   /*DO NOT UPDATE THIS*/
//   public String toString(){
//     StringBuilder builder = new StringBuilder();
//     for (int i = 0; i < map.length; i++) {
//       for (int c = 0; c < map[i].length; c++) {
//         if(map[i][c]==SPACE)
//           builder.append(" ");
//         else if(map[i][c]==TREE)
//           builder.append("@");
//         else if(map[i][c]==FIRE)
//           builder.append("w");
//         else if(map[i][c]==ASH)
//           builder.append(".");
//       }
//       builder.append("\n");
//     }
//     return builder.toString();
//   }
//   /*DO NOT UPDATE THIS*/
//   public String toStringColor(){
//     StringBuilder builder = new StringBuilder();
//     for (int i = 0; i < map.length; i++) {
//       for (int c = 0; c < map[i].length; c++) {
//         if(map[i][c]==0)
//           builder.append(" ");
//         else if(map[i][c]==2)
//           builder.append(Text.color(Text.GREEN)+"@");
//         else if(map[i][c]==1)
//           builder.append(Text.color(Text.RED)+"w");
//         else if(map[i][c]==3)
//           builder.append(Text.color(Text.DARK)+".");
//       }
//       builder.append("\n"+Text.RESET);
//     }
//     return builder.toString()+ticks+"\n";
//   }
// 
// 
//   /*DO NOT UPDATE THIS*/
//   public int animate(int delay) {
//     System.out.print(Text.CLEAR_SCREEN);
//     System.out.println(Text.go(1,1)+toStringColor());
//     Text.wait(delay);
//     while(!done()){
//       tick();
//       System.out.println(Text.go(1,1)+toStringColor());
//       Text.wait(delay);
//     }
//     return getTicks();
//   }
// 
//   /*DO NOT UPDATE THIS*/
//   public int outputAll(){
//     System.out.println(toString());
//     while(!done()){
//       tick();
//       System.out.println(toString());
//     }
//     return getTicks();
//   }
// 
// 
//   public static void main(String[]args)  throws InterruptedException{
//     int WIDTH = 20;
//     int HEIGHT = 20;
//     int DELAY = 200;
//     double DENSITY = .7;
//     if(args.length > 1){
//       WIDTH = Integer.parseInt(args[0]);
//       HEIGHT = Integer.parseInt(args[1]);
//       DENSITY = Double.parseDouble(args[2]);
//     }
//     if(args.length > 3){
//       DELAY = Integer.parseInt(args[3]);
//     }
//     BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
// 
//     System.out.println(b.animate(DELAY));//animate all screens and print the final answer
//     //System.out.println(b.outputAll());//print all screens and the final answer
//   }
// 
// 
// }
import java.util.*;
public class BurnTrees{
private int[][]map;
private int ticks;
private static int TREE = 2;
private static int FIRE = 1;
private static int ASH = 3;
private static int SPACE = 0;
private static Frontier frontier;
/*DO NOT UPDATE THIS
 *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
 */
public int run(){
  while(!done()){
    tick();
  }
  return getTicks();
}

/*Initialize the simulation.
 *If you add more instance variables you can add more here,
 *otherwise it is complete
 */
public BurnTrees(int width,int height, double density){
  map = new int[height][width];
  frontier = new Frontier();
  for(int r=0; r<map.length; r++ )
    for(int c=0; c<map[r].length; c++ )
      if(Math.random() < density)
         map[r][c]=2;
  start();//set the left column on fire.
}

/*Determine if the simulation is still burning
 *@return false if any fires are still burning, true otherwise
 */
public boolean done(){
  //YOU MUST IMPLEMENT THIS
  // for (int row = 0; row < this.map.length; row++)
  // {
  //   for (int col = 0; col < this.map[row].length; col++)
  //   {
  //     if (this.map[row][col] == FIRE)
  //     {
  //       return false;
  //     }
  //   }
  // }
  // return true;
  return frontier.size() == 0;
}


/*This is the core of the simulation. All of the logic for advancing to the next round goes here.
 *All existing fires spread new fires, and turn to ash
 *new fires should remain fire, and not spread.
 */
public void tick(){
  // ticks++;
  // //YOU MUST IMPLEMENT THIS
  // for (int row = 0; row < this.map.length; row++)
  // {
  //   for (int col = 0; col < this.map[row].length; col++)
  //   {
  //     if (this.map[row][col] == FIRE)
  //     {
  //       spreadFire(row, col); //spread current fires around
  //       this.map[row][col] = ASH; //current fires extinguish
  //     }
  //   }
  // }
  // for (int row = 0; row < this.map.length; row++)
  // {
  //   for (int col = 0; col < this.map[row].length; col++)
  //   {
  //     if (this.map[row][col] == FRESH_FIRE)
  //     {
  //       this.map[row][col] = FIRE; //converting the fresh fires to standard fires
  //     }
  //   }
  // }
          // while (frontier.size() != 0)
          // {
          //   ticks++;
          //   int[] originalFire;
          //   int row;
          //   int col;
          //   int numOfTimesToSpreadFire = frontier.size();
          //   int iter = 0;
          //   while (iter < numOfTimesToSpreadFire)
          //   {
          //     originalFire = frontier.remove();
          //     row = originalFire[0];
          //     col = originalFire[1];
          //     spreadFire(row, col);
          //     this.map[row][col] = ASH;
          //     iter++;
          //   }
          // }
  ticks++;
  int iter = 0;
  int numOfTimesToSpreadFire = frontier.size();
  if (numOfTimesToSpreadFire != 0)
  {
    while (iter < numOfTimesToSpreadFire && numOfTimesToSpreadFire != 0)
    {
      if (iter == numOfTimesToSpreadFire)
      {
        numOfTimesToSpreadFire = frontier.size();
        iter = 0;
      }
      else
      {
        int[] originalFire = frontier.remove();
        int row = originalFire[0];
        int col = originalFire[1];
        spreadFire(row, col);
        this.map[row][col] = ASH;
        iter++;
      }
    }
  }
}

public void spreadFire(int r, int c)
{
  //burn right
  if (c+1 != this.map[r].length && this.map[r][c+1] == TREE)
  {
                // this.map[r][c+1] = FRESH_FIRE;
    this.map[r][c+1] = FIRE;
    frontier.add(new int[] {r, c+1});
  }
  //burn left
  if (c-1 != -1 && this.map[r][c-1] == TREE)
  {
              // this.map[r][c-1] = FRESH_FIRE;
    this.map[r][c-1] = FIRE;
    frontier.add(new int[] {r, c-1});
  }
  //burn up
  if (r-1 != -1 && this.map[r-1][c] == TREE)
  {
          // this.map[r-1][c] = FRESH_FIRE;
    this.map[r-1][c] = FIRE;
    frontier.add(new int[] {r-1, c});
  }
  //burn down
  if (r+1 != this.map.length && this.map[r+1][c] == TREE)
  {
          // this.map[r+1][c] = FRESH_FIRE;
    this.map[r+1][c] = FIRE;
    frontier.add(new int[] {r+1, c});
  }
}

/*
 *Sets the trees in the left column of the forest on fire
 */
public void start(){
  //If you add more instance variables you can add more here,
  //otherwise it is complete.
  for(int i = 0; i < map.length; i++){
    if(map[i][0]==TREE){
      map[i][0]=FIRE;
      frontier.add(new int[] {i, 0});
    }
  }
}





/*DO NOT UPDATE THIS*/
public int getTicks(){
  return ticks;
}

/*DO NOT UPDATE THIS*/
public String toString(){
  StringBuilder builder = new StringBuilder();
  for (int i = 0; i < map.length; i++) {
    for (int c = 0; c < map[i].length; c++) {
      if(map[i][c]==SPACE)
        builder.append(" ");
      else if(map[i][c]==TREE)
        builder.append("@");
      else if(map[i][c]==FIRE)
        builder.append("w");
      else if(map[i][c]==ASH)
        builder.append(".");
    }
    builder.append("\n");
  }
  return builder.toString();
}
/*DO NOT UPDATE THIS*/
public String toStringColor(){
  StringBuilder builder = new StringBuilder();
  for (int i = 0; i < map.length; i++) {
    for (int c = 0; c < map[i].length; c++) {
      if(map[i][c]==0)
        builder.append(" ");
      else if(map[i][c]==2)
        builder.append(Text.color(Text.GREEN)+"@");
      else if(map[i][c]==1)
        builder.append(Text.color(Text.RED)+"w");
      else if(map[i][c]==3)
        builder.append(Text.color(Text.DARK)+".");
    }
    builder.append("\n"+Text.RESET);
  }
  return builder.toString()+ticks+"\n";
}


/*DO NOT UPDATE THIS*/
public int animate(int delay) {
  System.out.print(Text.CLEAR_SCREEN);
  System.out.println(Text.go(1,1)+toStringColor());
  Text.wait(delay);
  while(!done()){
    tick();
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
  }
  return getTicks();
}

/*DO NOT UPDATE THIS*/
public int outputAll(){
  System.out.println(toString());
  while(!done()){
    tick();
    System.out.println(toString());
  }
  return getTicks();
}


public static void main(String[]args)  throws InterruptedException{
  int WIDTH = 20;
  int HEIGHT = 20;
  int DELAY = 200;
  double DENSITY = .7;
  if(args.length > 1){
    WIDTH = Integer.parseInt(args[0]);
    HEIGHT = Integer.parseInt(args[1]);
    DENSITY = Double.parseDouble(args[2]);
  }
  if(args.length > 3){
    DELAY = Integer.parseInt(args[3]);
  }
  BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
  long start = System.currentTimeMillis();
  long totalSteps = b.run();
  long totalTime = System.currentTimeMillis()-start;
  System.out.println(totalTime);
  //System.out.println(b.animate(DELAY));//animate all screens and print the final answer
  //System.out.println(b.outputAll());//print all screens and the final answer
}


}
              
              