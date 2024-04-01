using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW3
{
    internal class Sem3Task3
    {

        public bool HasExit(int startI, int startJ, int[,] l)
        {
            //найти алгоритм, определяющий наличие выхода из лабиринта и выводящий на экран координаты точки выхода, если таковые имеются
            //условие выхода - двойка

            if (l[startI, startJ] == 1)
            {
                Console.WriteLine("You died, whilst starting in the wall of the labyrinth");
                return false;
            }
            else if (l[startI, startJ] == 2)
            {
                Console.WriteLine("You've successully started at exit");
                return true;
            }

            var stack = new Stack<Tuple<int, int>>();
            stack.Push(new(startI, startJ));

            while (stack.Count > 0)
            {
                var temp = stack.Pop();
                int i = temp.Item1;
                int j = temp.Item2;

                if (l[i, j] == 2)
                {
                    Console.WriteLine("You've successully saved yourself");
                    return true;
                }

                l[i, j] = 1;// чтобы больше сюда не возвращаться

                if (i - 1 >= 0 && l[i - 1, j] != 1)
                    stack.Push(new(i - 1, j));//вверх

                if (i + 1 < l.GetLength(0) && l[i + 1, j] != 1)
                    stack.Push(new(i + 1, j)); //вниз

                if (j - 1 >= 0 && l[i, j - 1] != 1)
                    stack.Push(new(i, j - 1));//влево

                if (j + 1 < l.GetLength(0) && l[i, j + 1] != 1)
                    stack.Push(new(i, j + 1)); //вправо 
            }
            return false;
        }

        //ДОМАШНЕЕ ЗАДАНИЕ
       
        public int GetExits(int startI, int startJ, int[,] l)
        {
            var exits = new Stack<Tuple<int, int>>();
            if (l[startI, startJ] == 1)
            {
                Console.WriteLine("You died, whilst starting in the wall of the labyrinth");
                return exits.Count;
            }

            var stack = new Stack<Tuple<int, int>>();
            stack.Push(new(startI, startJ));

            while (stack.Count > 0)
            {
                var temp = stack.Pop();
                int i = temp.Item1;
                int j = temp.Item2;

                //Console.WriteLine($"{i}-{j}: {l[i, j]}");
                if (l[i, j] == 2)
                {
                    exits.Push(new(i, j));
                    l[i, j] = 1;
                    continue;
                }

                l[i, j] = 1; // чтобы больше сюда не возвращаться

                if (i - 1 >= 0 && l[i - 1, j] != 1)
                    stack.Push(new(i - 1, j)); //вверх

                if (i + 1 < l.GetLength(0) && l[i + 1, j] != 1)
                    stack.Push(new(i + 1, j)); //вниз

                if (j - 1 >= 0 && l[i, j - 1] != 1)
                    stack.Push(new(i, j - 1)); //влево

                if (j + 1 < l.GetLength(0) && l[i, j + 1] != 1)
                    stack.Push(new(i, j + 1)); //вправо 
            }

            return exits.Count;
        }
    }
}
