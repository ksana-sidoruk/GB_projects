using System;

namespace HW2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[,] testArray = { { 7, 3, 2 }, { 4, 9, 6 }, { 1, 8, 5 } }; ;
            PrintArray(SortArray(testArray));
        }

        private static int[,] SortArray(int[,] arr)
        {
            int[] newArray = new int[arr.GetLength(0) * arr.GetLength(1)];
            int index = 0;
            for (int i = 0; i < arr.GetLength(0); i++)
            {
                for (int j = 0; j < arr.GetLength(1); j++)
                {
                    newArray[j + index] = arr[i, j];
                }
                index += arr.GetLength(1);
            }
            Array.Sort(newArray);
            index = 0;
            for (int i = 0; i < arr.GetLength(0); i++)
            {
                
                for (int j = 0; j < arr.GetLength(1); j++)
                {
                    arr[i, j] = newArray[j+index];
                }
                index += arr.GetLength(1);
            }

            return arr;
        }

        private static void PrintArray(int[,] arr)
        {
            for (int i = 0; i < arr.GetLength(0); i++)
            {
                for (int j = 0; j < arr.GetLength(1); j++)
                {
                    Console.Write(arr[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}
