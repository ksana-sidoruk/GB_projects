namespace HW3
{
    internal class Program
    {


        static void Main(string[] args)
        {

            int[,] l = new int[,]
            {
            {1, 1, 1, 1, 1, 1, 1 },
            {1, 0, 0, 0, 0, 0, 1 },
            {1, 0, 1, 1, 1, 0, 1 },
            {0, 0, 0, 0, 1, 0, 2 },
            {1, 1, 0, 0, 1, 1, 1 },
            {1, 1, 2, 1, 1, 1, 1 },
            {1, 1, 1, 1, 1, 1, 1 }
            };

            Console.WriteLine(new Sem3Task3().GetExits(3, 0, l));

        }
    }
}
