using System.Reflection;
using System.Reflection.Metadata;
using System.Text;

namespace HW7_Reflection
{
    [AttributeUsage(AttributeTargets.Property)]
    public class DontSaveAttribute : Attribute { }

    [AttributeUsage(AttributeTargets.Property)]
    public class ChangeNameAttribute : Attribute
    {
        public string Name { get; set; }

        public ChangeNameAttribute(string name)
        {
            this.Name = name;
        }
    }

    public class MyClass
    {
        [ChangeName("NewName")]
        public string? Name { get; set; }

        public int ID { get; set; }
        [ChangeName("NewDbl")]
        public double Dbl { get; set; }
        public MyClass() { }
        public MyClass(int id) { this.ID = id; }
        public MyClass(string? name, int iD, double dbl)
        {
            Name = name;
            ID = iD;
            this.Dbl = dbl;
        }
    }
    internal class Program
    {
        static string ObjectToString(object obj)
        {
            StringBuilder sb = new StringBuilder();
            sb.Append($"Class name | {obj.GetType().Name} | \n");

            var properties = obj.GetType().GetProperties();
            foreach (var property in properties)
            {
                //if (property.GetCustomAttribute<DontSaveAttribute>() != null) { continue; }

                ChangeNameAttribute? customAttribute = property.GetCustomAttribute<ChangeNameAttribute>(); //вынести в отдельную переменную, чтоб не обращаться к методу дважды
                var propertyName = property.Name;

                if (customAttribute != null) //чтобы не повторять кусок кода с Append
                {
                    propertyName = customAttribute.Name;
                }

                sb.Append($" Property type| {property.PropertyType} | " +
                    $"Property name | {propertyName}  | " +
                    $"Value | {property.GetValue(obj)} | \n");

            }
            string result = sb.ToString();
            return result;
        }

        static object StringToObject(string s)
        {
            var parser = s.Replace(" ", "").Replace("\n", "").Split("|");
            string className = parser[1];
            var result = Activator.CreateInstance(null, $"HW7_Reflection.{parser[1]}").Unwrap();
            var properties = result.GetType().GetProperties();

            var propertyNames = new Dictionary<string, string>();
            foreach (var property in properties)//заполняем словарь парами: <кастомное имя, базовое имя>
            {
                var attribute = property.GetCustomAttribute<ChangeNameAttribute>();
                if (attribute != null)
                {
                    propertyNames[attribute.Name] = property.Name;
                }
            }

            for (int i = 5; i < parser.Length - 2; i += 6)
            {
                var property = result.GetType().GetProperty(parser[i]);

                if(property == null)
                {
                    property = result.GetType().GetProperty(propertyNames[parser[i]]);
                }

                Console.WriteLine("A small check for myself: " + parser[i]);
                if (property.PropertyType == typeof(string))
                {
                    property.SetValue(result, parser[i + 2]);
                }
                if (property.PropertyType == typeof(int))
                {
                    property.SetValue(result, int.Parse(parser[i + 2]));
                }
                if (property.PropertyType == typeof(double))
                {
                    property.SetValue(result, double.Parse(parser[i + 2]));
                }
            }
            return result;
        }

        static void Main(string[] args)
        {
            MyClass test = new MyClass("testName", 1, 1.3);
            string try1 = ObjectToString(test);
            Console.WriteLine(try1);
            Console.WriteLine();
            var try2 = StringToObject(try1);
            Console.WriteLine("\ncheking if string to object was successful");
            Console.WriteLine(ObjectToString(try2));
        }
    }
}
