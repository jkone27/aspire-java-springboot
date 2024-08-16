var builder = DistributedApplication.CreateBuilder(args);

var apiService = builder.AddProject<Projects.AspireTest_ApiService>("apiservice");

builder.AddProject<Projects.AspireTest_Web>("webfrontend")
    .WithExternalHttpEndpoints()
    .WithReference(apiService);

builder.Build().Run();
