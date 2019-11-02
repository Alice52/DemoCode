using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Swashbuckle.AspNetCore.Swagger;
using Microsoft.Extensions.Logging;
using AspEfCore.Common.Configurations;
using AspEfCore.Data;
using Microsoft.EntityFrameworkCore;
using System.IO;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Serialization;
using Newtonsoft.Json;

namespace ASPEfCore.Web
{
    public class Startup
    {
        private readonly ILogger<Startup> _logger;
        public IConfiguration Configuration { get; }
        public SwaggerConfig SwaggerConfig { get; set; }

        public Startup(IConfiguration configuration, ILogger<Startup> logger)
        {
            Configuration = configuration;
            _logger = logger;

            SwaggerConfig = new SwaggerConfig();
            Configuration.GetSection("SwaggerConfig").Bind(SwaggerConfig);

        }
        public void ConfigureServices(IServiceCollection services)
        {
            // register Mvc
            services.AddMvc()
           .SetCompatibilityVersion(CompatibilityVersion.Version_2_2).AddJsonOptions(options =>
           {
               options.SerializerSettings.ContractResolver =
                   new CamelCasePropertyNamesContractResolver();
               options.SerializerSettings.ReferenceLoopHandling = ReferenceLoopHandling.Serialize;
           });

            // Register DbContext
            services.AddDbContext<CampDbContext>(
                options =>
                {
                    options.UseSqlServer(Configuration.GetConnectionString("CampCommon"), option => option.CommandTimeout(30));
                });

            // Register Swagger
            InjectSwagger(services);

           
        }

       
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseStaticFiles();

            if (SwaggerConfig.IsEnabled)
            {
                app.UseSwaggerUI(c =>
                {
                    c.SwaggerEndpoint("/swagger/v1/swagger.json", "Casino Data Service V1");
                    c.RoutePrefix = "swagger";
                });

                app.UseSwagger();
            }

            app.UseMvc();

            //app.Run(async (context) =>
            //{
            //    await context.Response.WriteAsync("Hello World!");
            //});
        }

        private void InjectSwagger(IServiceCollection services)
        {
            services.AddSwaggerGen(options =>
            {
                options.SwaggerDoc("v1", new Info { Title = "Casino Data Service Api", Version = "v1" });

                var filePath = Path.Combine(System.AppContext.BaseDirectory, "AspEfCore.Web.xml");
                options.IncludeXmlComments(filePath);
            });
        }
    }
}
