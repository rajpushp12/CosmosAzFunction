# CosmosAzFunction
Azure Function to fetch response from CosmosDB Containers

Since Azure Functions does't support creation of Java Project through Azure Portal, it should be done using VS Code or Intellij Idea.
Install Azure Functions extension in VS Code or Idea IDE and login using the promt.
Once logged in, select the subscription and create an Azure Function through the IDE and select HttpTrigger template and Java with all other settings as default.


To Connect the Function to CosmosDB edit the settings.json file to add the connection string.

```
{
  "IsEncrypted": false,
  "Values": {
    "AzureWebJobsStorage": "UseDevelopmentStorage=true",
    "AzureCosmosDBConnection": "YOUR CONNECTION STRING",
    "FUNCTIONS_WORKER_RUNTIME": "java"
  }
}
```

Once done, then edit the Function.java file and replace the content.



