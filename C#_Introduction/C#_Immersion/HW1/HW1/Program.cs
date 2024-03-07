namespace HW1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Calculator(args);
        }

        static public void Calculator(string[] args)
        {
            if (args.Length == 3)
            {
                if (int.TryParse(args[0], out int num1) && int.TryParse(args[2], out int num2))
                {
                    switch (args[1])
                    {
                        case "+":
                            Console.WriteLine($"{num1} {args[1]} {num2} = {num1 + num2}");
                            break;
                        case "-":
                            Console.WriteLine($"{num1} {args[1]} {num2} = {num1 - num2}");
                            break;
                        case "*":
                            Console.WriteLine($"{num1} {args[1]} {num2} = {num1 * num2}");
                            break;
                        case "/":
                            double doubleNum1 = Convert.ToDouble(num1);
                            if (num2 != 0)
                            {
                                Console.WriteLine($"{num1} {args[1]} {num2} = {doubleNum1 / num2}");
                            }
                            else
                            {
                                Console.WriteLine("You cannot divide by zero");
                            }
                            break;
                        default:
                            Console.WriteLine("You have inserted the wrong operator. Please try +, -, / or *");
                            break;
                    }
                }
                else
                {
                    Console.WriteLine("Please insert numbers to use calculator");
                }
            }

            else
            {
                Console.WriteLine("You've inserted the wrong mumber of arguments, please insert the arguments in the following order 'number' space 'operator' space 'number'");
            }
        }
    }
}
