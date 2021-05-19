class Kernel
{
  float[][] kernel;
  Kernel(float[][] init)
  {
    kernel = new float[3][3];
    for (int i = 0; i < init.length; i++)
    {
      for (int j = 0; j < init[i].length; j++)
      {
        kernel[i][j] = init[i][j];
      }
    }
  }
  color calcNewColor(PImage img, int x, int y)
  {
    return color(0);
  }
  void apply(PImage source, PImage destination)
  {
    for (int i = 0; i <= source.width; i++)
    {
      for (int j = 0; j <= source.height; j++)
      {
        color newOne = calcNewColor(source, i, j);
        destination.set(i,j,newOne);
      }
    }
  }
}
