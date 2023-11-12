# Signal

Exercise: Modify the code in `io.temporal.exercise3.signalworkflow.initial.MoneyTransferWorkflowImpl` to request
approval for all operation which amount is > 1000.

Change the code to:

- wait for the transfer to be authorized if amount > 1000. (``Workflow.await`)
- send a notification (new activity) to the client when the operation is completed.
- send a notification (new activity) to the client if the operation is not authorized.


### Resources
[Define Signal](https://docs.temporal.io/dev-guide/java/features?lang=java#define-signal)

[Signal implementation](https://docs.temporal.io/dev-guide/java/features?lang=java#handle-signals)

[Client implementation](https://docs.temporal.io/application-development/features?lang=java#send-signal-from-client)


### [Code sample](https://github.com/temporalio/samples-java/blob/main/core/src/main/java/io/temporal/samples/hello/HelloSignal.java) 



