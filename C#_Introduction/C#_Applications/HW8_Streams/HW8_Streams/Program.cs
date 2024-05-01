using System.IO;
using System.Runtime.CompilerServices;

namespace HW8_Streams
{
    internal class Program
    {
        static void FindFile(string path, string extension, string searchText, List<string> result)
        {
            DirectoryInfo dir = new DirectoryInfo(path);

            foreach (var file in dir.EnumerateFiles())
            {
                if (file.Extension.Equals(extension) == true && FindWord(file.FullName, searchText) == true)
                {
                    result.Add(file.FullName);
                }

            }
            if (dir.GetDirectories().Length > 0)
            {
                foreach (var d in dir.GetDirectories())
                {

                    var res = new List<string>();
                    FindFile(d.FullName, extension, searchText, res);
                    if (res.Count > 0)
                    {
                        result.AddRange(res);
                    }
                }
            }
        }

        static bool FindWord(string path, string word)
        {
            using (var d = new FileStream(path, FileMode.Open))
            {
                using (var reading = new StreamReader(d))
                {

                    while (reading.Peek() >= 0)
                    {
                        string line = reading.ReadLine();
                        if (line.Contains(word))
                        {
                            // Console.WriteLine($"Word \"{word}\" is found in line \"{line}\" \n" + path);
                            return true;
                        }
                    }
                    //Console.WriteLine($"Word \"{word}\" is not found");
                    return false;
                }
            }
        }
        static void Main(string[] args)
        {
            //Объедините две предыдущих работы(практические работы 2 и 3):
            //поиск файла и поиск текста в файле написав утилиту,
            //которая ищет файлы определенного расширения с указанным текстом.Рекурсивно
            //Пример вызова утилиты: utility.exe txt текст.

            var result = new List<string>();
            FindFile("C:\\Projects\\GB\\C#", ".txt", "blabla", result);
            foreach (var line in result)
            {
                Console.WriteLine(line);
            }
        }
    }
}
