# Workflow sleep

A Workflow can set a durable timer for a fixed time period. This example demostrate the use of `Workflow.sleep()`.

## Exercise: 

Modify the code in [MoneyTransferWorkflowImpl](./initial/workflow/MoneyTransferWorkflowImpl.java) and add a sleep for 
30 seconds in between activity invocations.

### Steps:
- change the workflow code in [MoneyTransferWorkflowImpl](./initial/workflow/MoneyTransferWorkflowImpl.java) and add 
a `Workflow.sleep()` for 30 seconds in between activity invocations.

### Resources:
- 
- [Timer](https://docs.temporal.io/application-development/features?lang=java#timers)

### Solution in package `solution`


## Expected output:

Temporal will add two new events to the workflow history in between activity invocations: TimerStarted and TimerFired.
TimerFired occurs 30 seconds after the timer is started. 



