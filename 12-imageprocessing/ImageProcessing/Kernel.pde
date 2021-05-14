class Kernel
{
  float[][] kernel;
  Kernel(float[][] init)
  {
    for (int i = 0; i < init.length; i++)
    {
      for (int j = 0; j < init[i].length; j++)
      {
        kernel[i][j] = init[i][j];
      }
    }
  }
}
