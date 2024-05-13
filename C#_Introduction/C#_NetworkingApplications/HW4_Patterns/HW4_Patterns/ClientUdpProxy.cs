using System.Globalization;
using System.Net;
using System.Net.Sockets;
using HW4_Patterns.Interfaces;
using HW4_Patterns.Models;

namespace HW4_Patterns
{
    internal class ClientUdpProxy : IMessageServerClient
    {
        private UdpClient _udpClient;
        private IPEndPoint _ep = new IPEndPoint(IPAddress.Any, 0);
        private Dictionary<string, IPEndPoint> _recipients = new Dictionary<string, IPEndPoint>();

        private object _lock = new object();

        public ClientUdpProxy(int port)
        {
            _udpClient = new UdpClient(port);
        }

        public void Dispose()
        {
            _udpClient.Close();
            _udpClient.Dispose();
        }

        public IMessage Receive()
        {
            var body = _udpClient.Receive(ref _ep);

            return new Message()
            {
                MessageBody = body,
                Sender = _ep.ToString()
            };
        }

        public void Send(byte[] message, string name)
        {
            if (_recipients.ContainsKey(name))
            {
                _udpClient.Send(message, _recipients[name]);
                return;
            }

            Console.WriteLine($"Recipient with name {name} not found");
        }

        public void Broadcast(byte[] message)
        {
            foreach (var recipient in _recipients.Values)
            {
                _udpClient.Send(message, recipient);
            }
        }

        public static IPEndPoint CreateIPEndPoint(string endPoint)
        {
            string[] ep = endPoint.Split(':');
            if (ep.Length != 2) throw new FormatException("Invalid endpoint format");
            IPAddress ip;
            if (!IPAddress.TryParse(ep[0], out ip))
            {
                throw new FormatException("Invalid ip-adress");
            }
            int port;
            if (!int.TryParse(ep[1], NumberStyles.None, NumberFormatInfo.CurrentInfo, out port))
            {
                throw new FormatException("Invalid port");
            }
            return new IPEndPoint(ip, port);
        }

        public void Register(string name, string address)
        {
            GetRecipients().Add(name, CreateIPEndPoint(address));
        }

        public void Unregister(string name)
        {
            GetRecipients().Remove(name);
        }

        public Dictionary<string, IPEndPoint> GetRecipients()
        {
            lock (_lock)
            {
                return _recipients;
            }
        }
    }
}
