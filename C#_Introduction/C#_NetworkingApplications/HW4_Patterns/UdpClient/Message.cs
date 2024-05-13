using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace ClientUdp
{
    public enum Commands
    {
        REGISTER,
        DELETE,
        DEFAULT
    }

    public class Message
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

        public string SerializeMessageToJson()
        {
            return JsonSerializer.Serialize(this);
        }

        public static Message? DeserializeMessageFromJson(string jsonMessage)
        {
            return JsonSerializer.Deserialize<Message>(jsonMessage);
        }

        public void Print()
        {
            Console.WriteLine(ToString());
        }
    }
}
