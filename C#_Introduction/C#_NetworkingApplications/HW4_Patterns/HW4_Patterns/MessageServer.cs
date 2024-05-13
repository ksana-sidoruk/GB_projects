using HW4_Patterns.Interfaces;

namespace HW4_Patterns
{
    internal class MessageServer : IMessageServer
    {
        private readonly IMessageServerClient _messageServerClient;
        private readonly IMessageHandlerFactory _messageHandlerFactory;

        public MessageServer(IMessageServerClient messageServerClient, IMessageHandlerFactory messageHandlerFactory) 
        {
            _messageServerClient = messageServerClient;
            _messageHandlerFactory = messageHandlerFactory;
        }

        public void Dispose() => _messageServerClient.Dispose();

        public void StartServer()
        {
            Console.WriteLine("Sever awaits for a message from the Client...");
            ThreadPool.QueueUserWorkItem(obj =>
            {
                ProcessMessage();
            });

            Console.WriteLine("To close server press any key");
            Console.ReadLine();
        }
        private void ProcessMessage()
        {
            while (true)
            {
                var message = _messageServerClient.Receive();
               
                IMessageHandler messageHandler = _messageHandlerFactory.CreateMessageHandler(message);
               
                Task.Run(() =>
                {
                    messageHandler.Handle(message);
                });
            }
        }
    }
}
