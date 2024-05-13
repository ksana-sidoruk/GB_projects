using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HW4_Patterns.Interfaces;

namespace HW4_Patterns.Models
{
    internal class Message : IMessage
    {
        public byte[] MessageBody { get; set; }
        public string Sender { get; set; }
    }
}
