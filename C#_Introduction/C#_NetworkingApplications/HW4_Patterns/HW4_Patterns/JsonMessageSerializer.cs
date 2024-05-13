using HW4_Patterns.Interfaces;
using System.Text.Json;

namespace HW4_Patterns
{
    internal class JsonMessageSerializer : IMessageSerializer
    {

        public T Deserialize<T>(byte[] messageBody)
        {
            return JsonSerializer.Deserialize<T>(messageBody);
        }
    }
}
