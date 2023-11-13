# Workflow task failure

This example demostrate that, for Temporal, exceptions thrown in workflow code are intermmitent, and will retry in presence of these errors.

The code is written to throw an error on porpouse. Once the code is fixed the workflow execution will continue from where it left off 

## Running the code

### Start Temporal Cluster locally
- https://docs.temporal.io/application-development/foundations#run-a-development-server


### Start Starter.java
This program send a request to the server to schedule the workflow execution
`./mvnw compile exec:java -Dexec.mainClass="io.temporal.exercise2.activityretry.Starter"`

### Start WorkerProcess.java
This program, worker, start listening in a specific taskqueue and accepting task from the server.
`./mvnw compile exec:java -Dexec.mainClass="io.temporal.exercise2.activityretry.WorkerProcess"`


### Expected output
The worker will start running the workflow code, and at some point it will throw a runtime exceptions. 


## Exercise
Fixing the code will unblock the workflow and the execution will continue as if nothing had happened


#### Fix the code 
- Open [MoneyTransferWorkflowImpl.java](./workflow/MoneyTransferWorkflowImpl.java) 
- Fix the code
- Stop the worker
- Start the worker (redeploy your code)


### Expected output
After some time, the worker will start procesing the code again and will complete the execution.
Note that the activity `withdraw` won’t be executed again.




