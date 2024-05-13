namespace HW4_Patterns.Interfaces
{
    internal interface IMessageServerClient
    {
        void Dispose();
        IMessage Receive();
        void Send(byte[] message, string name);
        void Register(string name, string address);
        void Unregister(string name);
        void Broadcast(byte[] message);
    }
}
