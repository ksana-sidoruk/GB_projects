using HW4_Patterns.Models;

namespace HW4_Patterns.Interfaces
{
    internal interface IMessageBody
    {
        Commands Command { get; set; }
    }
}
