# Workflow Signal

Temporal allows sent messages to running workflows through signals. 


## Exercise (step 1)
This project contains two folders, `initial` and `solution`.

Modify the code in [MoneyTransferWorkflowImpl](./initial/workflow/MoneyTransferWorkflowImpl.java) to wait for an 
approval if amount is > 1000.


### Steps:
- change the workflow code in [MoneyTransferWorkflowImpl](./initial/workflow/MoneyTransferWorkflowImpl.java) to 
wait for an authorization if `amount` > 1000. (`Workflow.await`)
- add a signal handler (new method) to your workflow. The method need to be declared inside the
workflow interface, and annotated with `@WorkflowSignal`


### Resources

- [Define Signal](https://docs.temporal.io/dev-guide/java/features?lang=java#define-signal)

- [Signal implementation](https://docs.temporal.io/dev-guide/java/features?lang=java#handle-signals)

- [Client implementation](https://docs.temporal.io/application-development/features?lang=java#send-signal-from-client)

- [Code sample](https://github.com/temporalio/samples-java/blob/main/core/src/main/java/io/temporal/samples/hello/HelloSignal.java) 


### Solution in package `solution1`:


## Exercise (step 2)

Modify the solution in the `step 1` in a way that the workflow:
- send a notification (new activity) to the client when the operation is completed.
- send a notification (new activity) to the client if the operation is not authorized.

These can be achieved creating a new activity interface (@ActivityInterface) with two new methods, then modify the
workflow code to invoke the new methods



### Resources

- //TODO add activity


### Solution in package `solution2`:
