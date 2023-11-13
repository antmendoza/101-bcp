# Workflow Query

We can add queries to our workflows to retreive internal state. 


## Exercise: 

Modify the code in [MoneyTransferWorkflowImpl](./initial/workflow/MoneyTransferWorkflowImpl.java) to expose a way to retrieve
transfer status 


### Steps:
- change the workflow code in [MoneyTransferWorkflowImpl](./initial/workflow/MoneyTransferWorkflowImpl.java) to
add a query that return the transfer status
- transfer status can be any of `INITIATED, WAITING_APPROVAL, APPROVED, COMPLETED, DENIED`.
- add a query handler (new method) to your workflow (`@WorkflowQuery`) that returns the status. 
- you can store transfer status in a workflow variable, and modify the value as the workflow is making progress. 

E.g:
    ```
        transferStatus = TRANSFER_STATUS.INITIATED;
    ```

### Resources:
- [Query](https://docs.temporal.io/application-development/features?lang=java#queries)
- [Workflow implementation](https://docs.temporal.io/application-development/features?lang=java#handle-query)
- [Client implementation](https://docs.temporal.io/application-development/features?lang=java#send-query)
- [Code sample](https://github.com/temporalio/samples-java/blob/main/core/src/main/java/io/temporal/samples/hello/HelloQuery.java) 

### Solution in package `solution`:
