using System.Net.Sockets;
using System.Net;
using System.Text;
using HW1_UdpServer;

namespace HW1_UdpClient
{
    internal class Program
    {
        static void Main(string[] args)
        {
            SendMessage("This Computer", "127.0.0.1");
        }

        static void SendMessage(string from, string ipAddress)
        {

            using (var udpClient = new UdpClient())
            {
                IPEndPoint ep = new IPEndPoint(IPAddress.Parse(ipAddress), 12345);

                while (true)
                {

                    Console.Clear();
                    Console.WriteLine("Please insert the message text");
                    string messageText = Console.ReadLine();

                    Message message = new Message() { Text = messageText, NameFrom = from, NameTo = "Server", DateTime = DateTime.Now };

                    string json = message.SerializeMessageToJson();
                    byte[] data = Encoding.UTF8.GetBytes(json);

                    udpClient.Send(data, data.Length, ep);

                    var serverEp = new IPEndPoint(IPAddress.Any, 0);
                    var replyBuffer = udpClient.Receive(ref serverEp);
                    var answer = Encoding.UTF8.GetString(replyBuffer);

                    Console.WriteLine(answer);

                    Console.WriteLine("print smth to proceed");
                    Console.ReadLine();

                }
            }
        }

    }
}
