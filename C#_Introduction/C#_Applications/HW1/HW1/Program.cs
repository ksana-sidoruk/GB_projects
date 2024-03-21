namespace HW1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            FamilyMember mother = new() { Name = "Helen", Age = 64, Gender = Gender.Female };
            FamilyMember father = new() { Name = "Wes", Age = 62, Gender = Gender.Male };
            FamilyMember zeroMember = new()
            {
                Name = "Ksana",
                Age = 36,
                Gender = Gender.Female,
                Father = father,
                Mother = mother
            };

            FamilyMember granny = new() { Name = "Pavel", Age = 95, Gender = Gender.Male };
            zeroMember.Mother.Father = granny;

            FamilyMember meemaw = new() { Name = "Zina", Age = 85, Gender = Gender.Female, Spouse = granny };
            zeroMember.Mother.Mother = meemaw;
            meemaw.Spouse = granny;

            FamilyMember babushkaValya = new() { Name = "Valua", Age = 87, Gender = Gender.Female };
            zeroMember.Father.Mother = babushkaValya;

            FamilyMember aunt = new() { Name = "Oxana", Age = 70, Gender = Gender.Female, Father = granny, Mother = meemaw };
            FamilyMember brother = new() { Name = "Roma", Age = 25, Gender = Gender.Female, Father = new FamilyMember { Name = "Gena" } };

            zeroMember.Siblings = [brother];
            mother.Siblings = [aunt];

            zeroMember.WholeFamily = new List<FamilyMember> { zeroMember, mother, father, meemaw, granny, babushkaValya, brother, aunt };
            brother.WholeFamily = new List<FamilyMember> { zeroMember, mother, father, meemaw, granny, babushkaValya, brother, aunt };

            /*
            zeroMember.SortFamilyByAge();

            Console.WriteLine($"The oldest family member of {zeroMember.Name} is {zeroMember.WholeFamily[0]} \n" +
                $"the whole family members ordered by age can be found below");
            foreach (var member in zeroMember.WholeFamily)
            {
                Console.WriteLine($"Name: {member.Name}, age: {member.Age}");
            }
            */
            //zeroMember.PrintAllFamily();
            //mother.ShowParents();

            FamilyMember olga = new() { Name = "Olga", Age = 20, Gender = Gender.Female, Spouse = brother };
            brother.Spouse = olga;
            FamilyMember nik = new() { Name = "Nikita", Age = 15, Gender = Gender.Male };
            FamilyMember marina = new() { Name = "Marina", Age = 40, Gender = Gender.Female };
            olga.Siblings = [nik];
            olga.WholeFamily = new List<FamilyMember> { marina, olga, nik };

            //_____________________________________________________________________________
            //Код для проверки выполнения ДЗ:

            brother.PrintFamilies();
        }
    }
}
