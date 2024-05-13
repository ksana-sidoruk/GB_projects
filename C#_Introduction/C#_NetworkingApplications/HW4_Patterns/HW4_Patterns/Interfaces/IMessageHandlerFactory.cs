namespace HW4_Patterns.Interfaces
{
    internal interface IMessageHandlerFactory
    {
        IMessageHandler CreateMessageHandler(IMessage message);
    }
}
