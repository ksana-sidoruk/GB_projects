using HW4_Patterns.Interfaces;
using HW4_Patterns.Models;

namespace HW4_Patterns.Handlers
{
    internal class DeleteMessageHandler : IMessageHandler
    {
        private IMessageServerClient _messageServerClient;
        private IMessageSerializer _messageSerializer;

        public DeleteMessageHandler(IMessageServerClient messageServerClient, IMessageSerializer messageSerializer)
        {
            _messageServerClient = messageServerClient;
            _messageSerializer = messageSerializer;
        }

        public void Handle(IMessage message)
        {
            MessageBody body = _messageSerializer.Deserialize<MessageBody>(message.MessageBody);
            _messageServerClient.Unregister(body.NameFrom);
        }
    }
}
