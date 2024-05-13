using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW4_Patterns.Interfaces
{
    internal interface IMessage
    {
        public byte[] MessageBody { get; set; }
        public string Sender { get; set; }
    }
}
