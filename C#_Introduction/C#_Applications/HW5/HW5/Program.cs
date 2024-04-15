
namespace HW5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /* Доработайте программу калькулятор реализовав выбор действий и вывод результатов на экран 
             * в цикле так чтобы калькулятор мог работать до тех пор пока пользователь не нажмет отмена или введёт пустую строку.
            */
            Calculator calculator = new Calculator();
            calculator.MyEventHandler += Calculator_MyEventHandler;
            bool flag = true;

            Console.WriteLine("Please, insert the first number");
            calculator.Result = Convert.ToInt32(Console.ReadLine());



            while (flag)
            {
                Console.WriteLine("to use calculator insert consecutevily an operator and a number. \n" +
                    "if you want to stop - type \"STOP\" or just press \"Enter\"" +
                    "Write \"CANCEL\" to cancel last result");


                string input = Console.ReadLine();
                if (input.ToUpper() == "STOP" || string.IsNullOrWhiteSpace(input))
                {
                    flag = false;
                    continue;
                }

                switch (input)
                {
                    case "+":
                        {
                            int number = Convert.ToInt32(Console.ReadLine());
                            calculator.Sum(number);
                            break;
                        }
                    case "-":
                        {
                            int number = Convert.ToInt32(Console.ReadLine());
                            calculator.Dif(number);
                            break;
                        }
                    case "*":
                        {
                            int number = Convert.ToInt32(Console.ReadLine());
                            calculator.Multiply(number);
                            break;
                        }
                    case "/":
                        {
                            int number = Convert.ToInt32(Console.ReadLine());
                            calculator.Div(number);
                            break;
                        }
                    case "CANCEL":
                        {
                            calculator.CancelLast(); 
                            break; 
                        }
                    default:
                        {
                            Console.WriteLine("you made a mistake");
                            break;
                        }
                }
            }
        }

        private static void Calculator_MyEventHandler(object? sender, EventArgs e)
        {
            if (sender is Calculator)
            {
                Console.WriteLine(((Calculator)sender).Result);
            }
        }
    }
}
