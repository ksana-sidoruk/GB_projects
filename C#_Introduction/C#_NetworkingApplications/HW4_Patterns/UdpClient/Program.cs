using System.Net;
using System.Net.Sockets;
using System.Text;

namespace ClientUdp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Press any button to send messages");

            Task.Run(() => SendMessage(new Message() { Text = $"", NameFrom = "Computer1", NameTo = "Server", DateTime = DateTime.Now, Command = Commands.REGISTER }, 12355));
            Task.Run(() => SendMessage(new Message() { Text = $"", NameFrom = "Computer2", NameTo = "Server", DateTime = DateTime.Now, Command = Commands.REGISTER }, 12335));
            Console.ReadLine();
            Task.Run(() => SendMessage(new Message() { Text = $"To computer 2 text", NameFrom = "Computer1", NameTo = "Computer2", DateTime = DateTime.Now, Command = Commands.DEFAULT }, 22355));
            Task.Run(() => SendMessage(new Message() { Text = $"To all Text", NameFrom = "Computer1", NameTo = "", DateTime = DateTime.Now, Command = Commands.DEFAULT }, 32355));
            Console.ReadLine();
        }

        static void SendMessage(Message message, int port, string ipAddress = "127.0.0.1")
        {

            using (var udpClient = new UdpClient(port))
            {
                IPEndPoint ep = new IPEndPoint(IPAddress.Parse(ipAddress), 12345);
                Console.Clear();

                string json = message.SerializeMessageToJson();
                byte[] data = Encoding.UTF8.GetBytes(json);

                udpClient.Send(data, data.Length, ep);

                while (true)
                {
                    var buffer = udpClient.Receive(ref ep);
                    var answer = Encoding.UTF8.GetString(buffer);


                    Console.WriteLine($"Recipient {message.NameFrom}");
                    Console.WriteLine(answer);
                }

            }
        }
    }
}
