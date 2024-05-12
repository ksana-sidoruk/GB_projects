using System.Net.Sockets;
using System.Net;
using System.Text;
using HW3_UdpServer;

namespace HW3_UdpClient
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var t = Task.Run(() => SendMessage("This Computer", "127.0.0.1"));
            Task.WaitAll(t);    
        }

        static void SendMessage(string from, string ipAddress)
        {

            using (var udpClient = new UdpClient())
            {
                IPEndPoint ep = new IPEndPoint(IPAddress.Parse(ipAddress), 12345);

                while (true)
                {

                    Console.Clear();
                    Console.WriteLine("Please insert the message text or print \"EXIT\" to leave chat");
                    string messageText = Console.ReadLine();

                    Message message = new Message() { Text = messageText, NameFrom = from, NameTo = "Server", DateTime = DateTime.Now };

                    string json = message.SerializeMessageToJson();
                    byte[] data = Encoding.UTF8.GetBytes(json);

                    udpClient.Send(data, data.Length, ep);

                    if (messageText.ToUpper() == "EXIT")
                    {

                        Console.WriteLine("The chat closes");
                        Thread.Sleep(1000);
                        udpClient.Close();
                        break;
                    }

                    var serverEp = new IPEndPoint(IPAddress.Any, 0);
                    var replyBuffer = udpClient.Receive(ref serverEp);
                    var answer = Encoding.UTF8.GetString(replyBuffer);

                    Console.WriteLine(answer);
                    Thread.Sleep(5000);
                }
            }
        }

    }
}
