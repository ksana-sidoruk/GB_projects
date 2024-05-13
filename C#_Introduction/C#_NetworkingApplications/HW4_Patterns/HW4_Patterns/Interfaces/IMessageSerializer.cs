namespace HW4_Patterns.Interfaces
{
    internal interface IMessageSerializer
    {
        T Deserialize<T>(byte[] messageBody);
    }
}
