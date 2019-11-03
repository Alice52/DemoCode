using Hangfire;
using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            GlobalConfiguration.Configuration.UseSqlServerStorage("Server=101.132.45.28;Database=HangfireTest;User Id=sa; Password=Yu1252068782?");

            using (var server = new BackgroundJobServer())
            {
                Console.WriteLine("Hangfire Server started. Press any key to exit...");
                Console.ReadKey();
            }
        }
    }
}
