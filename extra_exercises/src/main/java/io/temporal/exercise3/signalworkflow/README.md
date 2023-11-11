# Signal

Exercise: Modify the code in `io.temporal.exercise3.signalworkflow.initial.MoneyTransferWorkflowImpl` to require approval for all operation which 
amount is > 1000:
- wait for the transfer to be authorized if amount > 1000.
- send a notification (new activity) to the client when the operation is completed.
- if the operation is not authorized send a notification (new activity) to the client.

[Define Signal](https://docs.temporal.io/dev-guide/java/features?lang=java#define-signal)

[Signal implementation](https://docs.temporal.io/dev-guide/java/features?lang=java#handle-signals)

[Client implementation](https://docs.temporal.io/application-development/features?lang=java#send-signal-from-client)


### [Code sample](https://github.com/temporalio/samples-java/blob/main/core/src/main/java/io/temporal/samples/hello/HelloSignal.java) 



