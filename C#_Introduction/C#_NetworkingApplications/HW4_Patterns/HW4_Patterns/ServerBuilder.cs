using HW4_Patterns.Interfaces;


namespace HW4_Patterns
{
    internal class ServerBuilder
    {
        private IMessageServerClient _serverClient = null;
        private IMessageHandlerFactory _messageHandlerFactory = null;

        public IMessageServer Create()
        {
            if (this._serverClient != null  && _messageHandlerFactory != null)
            {
                return new MessageServer(this._serverClient, this._messageHandlerFactory);
            }
            throw new Exception("Please, set Client and Message Handler Factory before Create");
        }
    

        public void SetClient(IMessageServerClient messageServerClient)
        {
            _serverClient = messageServerClient;
        }

        public void SetMessageHandlerFactory(IMessageHandlerFactory messageHandlerFactory)
        {
            _messageHandlerFactory = messageHandlerFactory;
        }
    }
}
