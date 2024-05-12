using System.Net.Sockets;
using System.Net;
using System.Text;

namespace HW3_UdpServer
{
    internal class Program
    {
        private static CancellationTokenSource _cts = new CancellationTokenSource();

        static void Main(string[] args)
        {
            CancellationToken ct = _cts.Token;

            var t = Task.Run(()=>UdpServer(ct));
            Task.WaitAll(t);
        }

        public static void ProcessMessage(UdpClient udpClient, CancellationToken cancellationToken)
        {
            while (!cancellationToken.IsCancellationRequested)
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
        public static void UdpServer(CancellationToken cancellationToken)
        {
            using (var udpClient = new UdpClient(12345))
            {
                Console.WriteLine("Sever awaits for a message from the Client...");
                ThreadPool.QueueUserWorkItem(obj =>
                {
                    ProcessMessage(udpClient, cancellationToken);
                });

                while (!cancellationToken.IsCancellationRequested)
                {
                    Console.WriteLine("To close server enter 'CLOSE' command");
                    var command = Console.ReadLine();
                    if(command != null && command.Equals("CLOSE", StringComparison.CurrentCultureIgnoreCase))
                    {
                        _cts.Cancel();
                    }
                    else
                    {
                        Console.WriteLine("Not supported command");
                    }
                }
            }
        }
    }
}


