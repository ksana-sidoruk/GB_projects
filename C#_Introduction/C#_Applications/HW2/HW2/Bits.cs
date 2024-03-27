using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace HW2
{
    internal class Bits : IBits
    {
        public Bits(byte b)
        {
            this.Value = b;
            SizeOfValue = sizeof(byte) * 8;

        }
        public Bits(short b)
        {
            this.Value = b;
            SizeOfValue = sizeof(short) * 8;

        }
        public Bits(int b)
        {
            this.Value = b;
            SizeOfValue = sizeof(int) * 8;

        }
        public Bits(long b)
        {
            this.Value = b;
            SizeOfValue = sizeof(long) * 8;

        }
        public long Value { get; set; } = 0;
        private int SizeOfValue;


        //HOMEWORK 2
        public static implicit operator long(Bits b) => b.Value;
        public static implicit operator Bits(long b) => new Bits(b);
        public static implicit operator Bits(int b) => new Bits(b);
        public static implicit operator Bits(short b) => new Bits(b);
        public static implicit operator Bits(byte b) => new Bits(b);
        public bool GetBit(int number)
        {
            if (number > SizeOfValue || number < 0)
            {
                throw new IndexException("Значение бита должно быть в пределах от 0 до 64");
            }
            return ((Value >> number) & 1) == 1;
        }

        public void SetBit(int index, bool value)
        {
            if (index > SizeOfValue || index < 0) return;
            if (value == true)
            {
                Value = (byte)(Value | (1 << index));
            }
            else
            {
                var mask = (byte)(1 << index);
                mask = (byte)(0xff ^ mask);
                Value &= (byte)(Value & mask);
            }
        }
    }

    [Serializable]
    internal class IndexException : Exception
    {
        public IndexException() { }
        public IndexException(string? message) : base(message) { }
        public IndexException(string? message, Exception? innerException) : base(message, innerException) { }
        protected IndexException(SerializationInfo info, StreamingContext context) : base(info, context) { }
    }
}
