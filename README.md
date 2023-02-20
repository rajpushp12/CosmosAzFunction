# CosmosAzFunction
## Azure Function to fetch response from CosmosDB Containers

Since Azure Functions does't support creation of Java Project through Azure Portal, it should be done using VS Code or Intellij Idea.
Install Azure Functions extension in VS Code or Idea IDE and login using the promt.
Once logged in, select the subscription and create an Azure Function through the IDE and select HttpTrigger template and Java with all other settings as default.


### To Connect the Function to CosmosDB edit the settings.json file to add the connection string.

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

### Edit the Function.java file and replace the content.

```
package org.example.functions;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions in Java with Cosmos DB Trigger.
 */
 
public class Function {

    @FunctionName("cosmosDBMonitor")
    public void cosmosDbProcessor(
            @CosmosDBTrigger(name = "items",
            databaseName = "YOUR DB NAME", collectionName = "YOUR CONTAINER NAME",
            createLeaseCollectionIfNotExists = true,
            connectionStringSetting = "AzureCosmosDBConnection") String[] items,
            final ExecutionContext context) {
                for (String string : items) {
                    System.out.println(string);
                }
        context.getLogger().info(items.length + "item(s) is/are changed.");
    }
}
```

Build and Run the Maven Project. The DB has been connected and any change in the DB will logged in the terminal.
