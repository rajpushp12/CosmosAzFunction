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
            databaseName = "customerDB", collectionName = "logistics",
            createLeaseCollectionIfNotExists = true,
            connectionStringSetting = "AzureCosmosDBConnection") String[] items,
            final ExecutionContext context) {
                for (String string : items) {
                    System.out.println(string);
                }
        context.getLogger().info(items.length + "item(s) is/are changed.");
    }
}