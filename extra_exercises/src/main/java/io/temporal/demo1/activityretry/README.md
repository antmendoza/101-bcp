# Introduction

This example demostrate how Temporal retry activity execution in presence of errors. 

The activity code contains logic to simulate 4 consecutive failures and will success after the 
forth attend.

See activity implementation [AccountServiceImplRetry.java](workflow/AccountServiceImplRetry.java)

```
  private void simulateServiceIsDownAndSuccessAfterNumIteractions(int numIterationsBeforeSuccess) {

    int attend = Activity.getExecutionContext().getInfo().getAttempt();
    if (attend <= numIterationsBeforeSuccess) {
      String message = "Error: Can not reach service...attend " + attend;
      throw new RuntimeException(message);
    }
  }

```

## Running the code

### Start Temporal Cluster locally 
- https://docs.temporal.io/application-development/foundations#run-a-development-server


### Start Starter.java
This program send a request to the server to schedule the workflow execution
`./mvnw compile exec:java -Dexec.mainClass="io.temporal.demo1.activityretry.Starter"`

### Start WorkerProcess.java
This program, worker, start listening in a specific taskqueue and accepting task from the server.
`./mvnw compile exec:java -Dexec.mainClass="io.temporal.demo1.activityretry.WorkerProcess"`


### Expected output
The activity will fail four times, and will success after the forth attend.

