using HW4_Patterns.Interfaces;
using HW4_Patterns.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW4_Patterns.Handlers
{
    internal class RegisterMessageHandler : IMessageHandler
    {
        private IMessageServerClient _messageServerClient;
        private IMessageSerializer _messageSerializer;

        public RegisterMessageHandler(IMessageServerClient messageServerClient, IMessageSerializer messageSerializer)
        {
            _messageServerClient = messageServerClient;
            _messageSerializer = messageSerializer;
        }

        public void Handle(IMessage message)
        {
            MessageBody body = _messageSerializer.Deserialize<MessageBody>(message.MessageBody);
            _messageServerClient.Register(body.NameFrom, message.Sender);
        }
    }
}
