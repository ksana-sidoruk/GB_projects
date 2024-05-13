using HW4_Patterns.Interfaces;
using HW4_Patterns.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW4_Patterns.Handlers
{
    internal class CommandBaseMessageHandler : IMessageHandler
    {
        private IMessageServerClient _messageServerClient;
        private IMessageSerializer _messageSerializer;

        public CommandBaseMessageHandler(IMessageServerClient messageServerClient, IMessageSerializer messageSerializer)
        {
            _messageServerClient = messageServerClient;
            _messageSerializer = messageSerializer;
        }

        public void Handle(IMessage message)
        {
            MessageBody body = _messageSerializer.Deserialize<MessageBody>(message.MessageBody);

            if (string.IsNullOrEmpty(body.NameTo))
            {
                _messageServerClient.Broadcast(message.MessageBody);
            }
            else
            {
                _messageServerClient.Send(message.MessageBody, body.NameTo);
            }
        }

    }
}
