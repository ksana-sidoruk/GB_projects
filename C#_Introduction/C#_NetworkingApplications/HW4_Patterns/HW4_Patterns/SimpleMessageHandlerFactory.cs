using HW4_Patterns.Handlers;
using HW4_Patterns.Interfaces;
using HW4_Patterns.Models;

namespace HW4_Patterns
{
    internal class SimpleMessageHandlerFactory : IMessageHandlerFactory
    {
        private IMessageSerializer _messageSerializer;
        private IMessageServerClient _messageServerClient;

        public SimpleMessageHandlerFactory(IMessageServerClient messageServerClient, IMessageSerializer messageSerializer)
        {
   
            _messageSerializer = messageSerializer;
            _messageServerClient = messageServerClient;
        }

        public IMessageHandler CreateMessageHandler(IMessage message)
        {
            IMessageBody body = _messageSerializer.Deserialize<MessageBody>(message.MessageBody);
            switch (body.Command)
            {
                case Commands.REGISTER:
                    return new RegisterMessageHandler(_messageServerClient, _messageSerializer);
                   
                case Commands.DELETE:
                    return new DeleteMessageHandler(_messageServerClient, _messageSerializer);
            }

            return new CommandBaseMessageHandler(_messageServerClient, _messageSerializer); ;
        }
    }
}
