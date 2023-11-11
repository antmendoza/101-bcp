# Introduction

This example demostrate how Temporal retry activity execution in presence of errors. 

The activity code contains logic to simulate 4 consecutive failures and will success after the 
forth attend.

```
  private void simulateServiceIsDownAndSuccessAfterNumIteractions(int numIterationsBeforeSuccess) {

    int attend = Activity.getExecutionContext().getInfo().getAttempt();
    if (attend <= numIterationsBeforeSuccess) {
      String message = "Error: Can not reach service...attend " + attend;
      throw new RuntimeException(message);
    }
  }

```

### Make sure Temporal Server is running locally 
- https://docs.temporal.io/application-development/foundations#run-a-development-server


### run Starter.java (send request/start workflow)
### run WorkerProcess.java (worker executes our code)

The activity will fail four times, after forth attend will success. 
By default, activity execution will retry until it eventually success. You can customize this behaviour.


