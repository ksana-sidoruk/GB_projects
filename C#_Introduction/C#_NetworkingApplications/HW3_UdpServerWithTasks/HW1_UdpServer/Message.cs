using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace HW3_UdpServer
{
    public class Message
    {
        public string Text { get; set; }
        public DateTime DateTime { get; set; }
        public string NameFrom { get; set; }
        public string NameTo { get; set; }

        public override string ToString()
        {
            return $"Message from {NameFrom} received on {DateTime}. \n Message text: \"{Text}\"";
        }

        //два метода класса json сериализация и десериализация + тест

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
