using HW4_Patterns.Interfaces;

namespace HW4_Patterns.Models
{
    public enum Commands
    {
        REGISTER,
        DELETE,
        DEFAULT
    }

    public class MessageBody : IMessageBody
    {
        public Commands Command { get; set; }

        public string Text { get; set; }
        public DateTime DateTime { get; set; }
        public string NameFrom { get; set; }
        public string NameTo { get; set; }

        public override string ToString()
        {
            return $"Message from {NameFrom} received on {DateTime}. \n Message text: \"{Text}\"";
        }
    }
}
