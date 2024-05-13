namespace HW4_Patterns
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var serverBuilder = new ServerBuilder();
            var udpProxy = new ClientUdpProxy(12345);
            var jsonSerializer = new JsonMessageSerializer();

            serverBuilder.SetClient(udpProxy);
            serverBuilder.SetMessageHandlerFactory(new SimpleMessageHandlerFactory(udpProxy, jsonSerializer));

            using (var server = serverBuilder.Create())
            {
                var t = Task.Run(() => server.StartServer());
                Task.WaitAll(t);
            }

        }
    }
}
