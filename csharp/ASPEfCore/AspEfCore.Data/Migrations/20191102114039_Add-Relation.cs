using System;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace AspEfCore.Data.Migrations
{
    public partial class AddRelation : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_CityCompany_Cities_CityId",
                table: "CityCompany");

            migrationBuilder.DropForeignKey(
                name: "FK_CityCompany_Company_CompanyId",
                table: "CityCompany");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Company",
                table: "Company");

            migrationBuilder.DropPrimaryKey(
                name: "PK_CityCompany",
                table: "CityCompany");

            migrationBuilder.RenameTable(
                name: "Company",
                newName: "Companies");

            migrationBuilder.RenameTable(
                name: "CityCompany",
                newName: "CityCompanies");

            migrationBuilder.RenameIndex(
                name: "IX_CityCompany_CompanyId",
                table: "CityCompanies",
                newName: "IX_CityCompanies_CompanyId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Companies",
                table: "Companies",
                column: "Id");

            migrationBuilder.AddPrimaryKey(
                name: "PK_CityCompanies",
                table: "CityCompanies",
                columns: new[] { "CityId", "CompanyId" });

            migrationBuilder.CreateTable(
                name: "Majors",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    FirstName = table.Column<string>(nullable: true),
                    LastName = table.Column<string>(nullable: true),
                    BirthDay = table.Column<DateTime>(nullable: true),
                    Gender = table.Column<int>(nullable: false),
                    CityId = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Majors", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Majors_Cities_CityId",
                        column: x => x.CityId,
                        principalTable: "Cities",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Majors_CityId",
                table: "Majors",
                column: "CityId",
                unique: true);

            migrationBuilder.AddForeignKey(
                name: "FK_CityCompanies_Cities_CityId",
                table: "CityCompanies",
                column: "CityId",
                principalTable: "Cities",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_CityCompanies_Companies_CompanyId",
                table: "CityCompanies",
                column: "CompanyId",
                principalTable: "Companies",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_CityCompanies_Cities_CityId",
                table: "CityCompanies");

            migrationBuilder.DropForeignKey(
                name: "FK_CityCompanies_Companies_CompanyId",
                table: "CityCompanies");

            migrationBuilder.DropTable(
                name: "Majors");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Companies",
                table: "Companies");

            migrationBuilder.DropPrimaryKey(
                name: "PK_CityCompanies",
                table: "CityCompanies");

            migrationBuilder.RenameTable(
                name: "Companies",
                newName: "Company");

            migrationBuilder.RenameTable(
                name: "CityCompanies",
                newName: "CityCompany");

            migrationBuilder.RenameIndex(
                name: "IX_CityCompanies_CompanyId",
                table: "CityCompany",
                newName: "IX_CityCompany_CompanyId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Company",
                table: "Company",
                column: "Id");

            migrationBuilder.AddPrimaryKey(
                name: "PK_CityCompany",
                table: "CityCompany",
                columns: new[] { "CityId", "CompanyId" });

            migrationBuilder.AddForeignKey(
                name: "FK_CityCompany_Cities_CityId",
                table: "CityCompany",
                column: "CityId",
                principalTable: "Cities",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_CityCompany_Company_CompanyId",
                table: "CityCompany",
                column: "CompanyId",
                principalTable: "Company",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
