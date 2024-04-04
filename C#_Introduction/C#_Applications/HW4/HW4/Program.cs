namespace HW4
{
    internal class Program
    {
        static void Main(string[] args)
        {

            int[] numbers = new int[] { 1, 2, 7, 50, 12, 5, 1, 7, 5, 14, 7, 22, 4, 1, 8 };
            int target = 67;

            Array.Sort(numbers);

            for (int i = 0; i < numbers.Length - 2; i++)
            {
                int left = i + 1;
                int right = numbers.Length - 1;

                while (left < right)
                {
                    int sum = numbers[i] + numbers[left] + numbers[right];

                    if (sum == target)
                    {
                        Console.WriteLine($"found: {numbers[i]}, {numbers[left]}, {numbers[right]}");
                        return;
                    }
                    else if (sum < target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }

            Console.WriteLine("not found");
        }
    }
}
