using AspEfCore.Domain;
using Microsoft.EntityFrameworkCore;

namespace AspEfCore.Data
{
    public class CampDbContext : DbContext
    {
        public CampDbContext(DbContextOptions<CampDbContext> options) : base(options)
        {

        }


        public DbSet<CityCompany> CityCompanies { get; set; }
        public DbSet<Company> Companies { get; set; }
        public DbSet<Province> Provinces { get; set; }
        public DbSet<City> Cities { get; set; }
        public DbSet<Major> Majors { get; set; }

        //protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        //{
        //    optionsBuilder.UseSqlServer("Server=101.132.45.28;Database=Local_Camp_Common;User Id=sa; Password=Yu1252068782?");
        //}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<CityCompany>()
                .HasKey(x => new { x.CityId, x.CompanyId });
            modelBuilder.Entity<CityCompany>()
                .HasOne(x => x.City).WithMany(x => x.CityCompanies).HasForeignKey(x => x.CityId);
            modelBuilder.Entity<CityCompany>()
              .HasOne(x => x.Company).WithMany(x => x.CityCompanies).HasForeignKey(x => x.CompanyId);

            modelBuilder.Entity<Major>()
                .HasOne(x => x.City).WithOne(x => x.Major).HasForeignKey<Major>(x => x.CityId);

            modelBuilder.Entity<City>()
                .HasOne(x => x.Province).WithMany(x => x.Cities).HasForeignKey(x => x.ProvinceId);
        }
    }
}
