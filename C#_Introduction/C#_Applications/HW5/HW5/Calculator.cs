using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW5
{
    internal class Calculator : ICalculator
    {
        public double Result { get; set; } = 0D;
        private Stack<double> LastResult { get; set; } = new Stack<double>();
        public event EventHandler<EventArgs> MyEventHandler;
        private void PrintResult()
        {
            MyEventHandler?.Invoke(this, new EventArgs());
        }


        public double Dif(int x)
        {
            Result -= x;
            PrintResult();
            LastResult.Push(Result);
            return Result;
        }

        public double Div(int x)
        {
            Result /= x;
            PrintResult();
            LastResult.Push(Result);
            return Result;

        }

        public double Multiply(int x)
        {
            Result *= x;
            PrintResult();
            LastResult.Push(Result);
            return Result;

        }

        public double Sum(int x)
        {
            Result += x;
            PrintResult();
            LastResult.Push(Result);
            return Result;
        }

        public void CancelLast()
        {
            if (LastResult.Count > 1)
            {
                LastResult.Pop(); 
                Result = LastResult.Peek(); 
                Console.WriteLine("Last action is canceled, the result is equal to:");
                PrintResult();
            }
            else
            {
                Console.WriteLine("Nothing to cancel");
            }
        }
    }
}
