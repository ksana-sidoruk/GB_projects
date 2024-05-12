using System.Net.Sockets;
using System.Net;
using System.Text;

namespace HW3_UdpServer
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var t = Task.Run(()=>UdpServer());
            Task.WaitAll(t);
        }

        public static void ProcessMessage(UdpClient udpClient)
        {
            while (true)
            {
                IPEndPoint ep = new IPEndPoint(IPAddress.Any, 0);
                var buffer = udpClient.Receive(ref ep);

                var messageText = Encoding.UTF8.GetString(buffer);

                Task.Run(() =>
                {
                    Message message = Message.DeserializeMessageFromJson(messageText);
                    message.Print();

                    byte[] reply = Encoding.UTF8.GetBytes("\t\t\tMessage received at " + DateTime.Now);
                    udpClient.Send(reply, ep);

                });
            }
        }
        public static void UdpServer()
        {
            using (var udpClient = new UdpClient(12345))
            {
                Console.WriteLine("Sever awaits for a message from the Client...");
                ThreadPool.QueueUserWorkItem(obj =>
                {
                    ProcessMessage(udpClient);
                });

                Console.WriteLine("To close server press any key");
                Console.ReadLine();

            }
        }
    }
}


