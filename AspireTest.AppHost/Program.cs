var builder = DistributedApplication.CreateBuilder(args);

var apiService = builder.AddProject<Projects.AspireTest_ApiService>("apiservice");

builder.AddProject<Projects.AspireTest_Web>("webfrontend")
    .WithExternalHttpEndpoints()
    .WithReference(apiService);

// Add the Spring Boot Docker container
// docker run -it -p 9099:8888 aspirejava:0.0.1-SNAPSHOT
builder.AddContainer("my-springboot-app", "aspirejava", "0.0.1-SNAPSHOT")
    .WithEndpoint(
        port: 9099,
        targetPort: 8080, 
        scheme: "http")
    .WithOtlpExporter();

builder.Build().Run();
