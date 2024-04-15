using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW5
{
    internal interface ICalculator
    {
        double Result { get; set; }
        double Sum(int x);
        double Dif(int x);
        double Multiply(int x);
        double Div(int x);
        event EventHandler<EventArgs> MyEventHandler;
    }
}
