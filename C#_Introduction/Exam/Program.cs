string[] FilterArrayByStringLength(string[] inputArray, int lgth)
{
    int size = 0;
    for (int i = 0; i < inputArray.Length; i++)
    {
        if (inputArray[i].Length <= lgth) size++;
    }
    string[] result = new string[size];

    int index = 0;
    for (int i = 0; i < inputArray.Length; i++)
    {
        if (inputArray[i].Length <= lgth)
        {
            result[index] = inputArray[i];
            index++;
        }
    }
    return result;
}

Console.WriteLine("На сколько элементов желаете задать массив? Введите, пожалуйста соответствующее число: ");
int arrayLength = Convert.ToInt32(Console.ReadLine());
string[] array = new string[arrayLength];

Console.WriteLine($"Последовательно введите {arrayLength} комбинации(й) букв, цифр или символов любой длины \n(но лучше, конечно, оставаться в пределах разумного):");
for (int i = 0; i < array.Length; i++)
{
    array[i] = Console.ReadLine();
}

Console.Write($"[ {string.Join(", ", array)} ] => ");
string[] newArray = FilterArrayByStringLength(array, 3);
Console.Write($"[ {string.Join(", ", newArray)} ]");
