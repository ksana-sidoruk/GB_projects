using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW1
{
    public enum Gender
    {
        Male,
        Female
    }

    public class FamilyMember
    {

        /*
        // то же самое, что делается { get; set; }
        private string _name;
        
        public string GetValueName()
        {
            return _name;
        }

        public void SetValueName(string value)
        {
            _name = value;
        }
        */

        public string Name { get; set; }
        public Gender Gender { get; set; }
        public uint Age { get; set; }
        public FamilyMember Mother { get; set; }
        public FamilyMember Father { get; set; }
        public FamilyMember[] Siblings { get; set; }
        public List<FamilyMember> WholeFamily { get; set; }
        public FamilyMember Spouse { get; set; }


        public override string ToString()
        {
            return $"Name: {Name} (age: {Age}, gender {Gender})";
        }

        //выводит информацию о родителях
        public void ShowParents()
        {
            if (Father != null)
            {
                Console.WriteLine($"Father: {Father.Name} ");
            }
            else
            {
                Console.WriteLine("No info on the father");
            }

            if (Mother != null)
            {
                Console.WriteLine($"Mother: {Mother.Name} ");
            }
            else
            {
                Console.WriteLine("No info on the mother");
            }
        }

        //два следующих метода для вывода информации о предках рекурсивно, вариант не учитывает сиблингов
        public void PrintAllFamily()
        {
            PrintFamilyMember(this);
        }
        public void PrintFamilyMember(FamilyMember familyMember)
        {
            Console.WriteLine(familyMember);
            if (familyMember.Father != null)
            {
                PrintFamilyMember(familyMember.Father);
            }
            if (familyMember.Mother != null)
            {
                PrintFamilyMember(familyMember.Mother);
            }
        }

        //сортирует всех родственников по убыванию возраста (для того, чтоб вывести информацию обо всех родственниках this
        public void SortFamilyByAge()
        {
            WholeFamily = WholeFamily.OrderByDescending(member => member.Age).ToList();
        }

        //метод, чтобы проверить, состоит ли объект в браке
        private bool IsMarried()
        {
            if (this.Spouse != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //_________________________________________________________________________
        // ДОМАШНЕЕ ЗАДАНИЕ:
        public void PrintFamilies()
        {
            SortFamilyByAge();
            Console.WriteLine($"Here are family members of {this.Name} sorted by descending by age");
            foreach (var member in this.WholeFamily)
            {
                Console.WriteLine($"Name: {member.Name}, age: {member.Age}");
            }
            if (this.IsMarried())
            {
                Spouse.SortFamilyByAge();
                Console.WriteLine($"\nAnd here are family members of {Spouse.Name}, {this.Name}' spouse, sorted by descending by age");
                foreach (var member in Spouse.WholeFamily)
                {
                    Console.WriteLine($"Name: {member.Name}, age: {member.Age}");
                }
            }
        }
    }
}
