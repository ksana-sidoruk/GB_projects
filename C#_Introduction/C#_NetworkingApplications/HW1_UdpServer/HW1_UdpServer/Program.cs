using System.Net.Sockets;
using System.Net;
using System.Text;

namespace HW1_UdpServer
{
    internal class Program
    {
        static void Main(string[] args)
        {
            UdpServer();
        }

        public static void UdpServer()
        {
            using (var udpClient = new UdpClient(12345))
            {
                Console.WriteLine("Sever awaits for a message from the Client...");


                while (true)
                {
                    IPEndPoint ep = new IPEndPoint(IPAddress.Any, 0);
                    var buffer = udpClient.Receive(ref ep);

                    var messageText = Encoding.UTF8.GetString(buffer);
                    Message message = Message.DeserializeMessageFromJson(messageText);
                    message.Print();

                    byte[] reply = Encoding.UTF8.GetBytes("\t\t\tMessage received");
                    udpClient.Send(reply, reply.Length, ep);
                }
            }
        }
    }
}

//ДЗ: только сервер