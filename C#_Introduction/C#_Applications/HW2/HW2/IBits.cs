using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW2
{
    internal interface IBits
    {
        void SetBit(int index, bool value);
        bool GetBit(int number);
    }
}
