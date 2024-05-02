namespace HW9_JSON_XML
{
    using System.Text;
    using System.Text.Json;
    using System.Xml;
    using System.Xml.Serialization;
    using static HW9_JSON_XML.Program;


    public class Weather
    {
        public DateTime Time { get; set; }
        public int Temperature { get; set; }
        public int Weathercode { get; set; }
        public double Windspeed { get; set; }

    }
    public class WeatherInfo
    {
        public Weather Current { get; set; }
        public Weather[]? History { get; set; }

    }

    internal class Program
    {


        static void Main(string[] args)
        {


            Weather weather = new Weather()
            {
                Time = DateTime.Now,
                Temperature = 29,
                Weathercode = 1,
                Windspeed = 2.1,
            };

            Weather weather1 = new Weather()
            {
                Time = DateTime.Parse("10.04.2024"),
                Temperature = 20,
                Weathercode = 2,
                Windspeed = 1.1,
            };

            Weather weather2 = new Weather()
            {
                Time = DateTime.Parse("12.04.2024"),
                Temperature = 25,
                Weathercode = 2,
                Windspeed = 1.7,
            };

            var info = new WeatherInfo() { Current = weather, History = new Weather[] { weather1, weather2 } };


            var jsonString = "{\"Current\":{\"Time\":\"2024-05-01T16:51:13.7175479+02:00\",\"Temperature\":29,\"Weathercode\":1,\"Windspeed\":2.1},\"History\":[{\"Time\":\"2024-10-04T00:00:00\",\"Temperature\":20,\"Weathercode\":2,\"Windspeed\":1.1}, {\"Time\":\"2024-12-04T00:00:00\", \"Temperature\":25,\"Weathercode\":2,\"Windspeed\":1.7}]}";

            var xmlDocument = new XmlDocument();
            XmlDeclaration xmlDeclaration = xmlDocument.CreateXmlDeclaration("1.0", "UTF-8", null);
            XmlElement root = xmlDocument.CreateElement("Root");

            using (JsonDocument document = JsonDocument.Parse(jsonString))
            {
                root = BuildXmlNodeFromJson(root, document.RootElement, xmlDocument);
            }

            xmlDocument.AppendChild(root);
            Console.WriteLine(xmlDocument.OuterXml);
        }

        private static XmlElement BuildXmlNodeFromJson(XmlElement currentElement, JsonElement currentJsonElement, XmlDocument document)
        {

            if (currentJsonElement.ValueKind != JsonValueKind.Object && currentJsonElement.ValueKind != JsonValueKind.Array)
            {
                currentElement.InnerText = currentJsonElement.GetRawText().Replace("\"", "");
                return currentElement;
            }

            if (currentJsonElement.ValueKind == JsonValueKind.Object)
            {
                foreach (var item in currentJsonElement.EnumerateObject())
                {
                    var newNode = document.CreateElement(item.Name);
                    newNode = BuildXmlNodeFromJson(newNode, item.Value, document);
                    currentElement.AppendChild(newNode);
                }
            }

            if (currentJsonElement.ValueKind == JsonValueKind.Array)
            {
                foreach (var item in currentJsonElement.EnumerateArray())
                {
                    var newNode = document.CreateElement("Item");
                    newNode = BuildXmlNodeFromJson(newNode, item, document);
                    currentElement.AppendChild(newNode);
                }
            }
            return currentElement;
        }
    }
}
