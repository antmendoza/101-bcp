# Workflow task  failure

This example demostrate the workflow task will retry in presence of errors. 
The workflow code throws runtime error, once we fix the code and redeploy the worker, the worker will continue the workflow execution.

### Make sure Temporal Server is running locally
- https://docs.temporal.io/application-development/foundations#run-a-development-server

### run Starter.java (send request/start workflow)
### run WorkerProcess.java (worker executes our code)

Note runtime exceptions in console. (The worker send WorkflowTaskFailed to the server and the server re-schedule the task,
until it eventually success)

### Fix the code 
- Open, MoneyTransferWorkflowImpl.java,
- Fix the code
- Stop the worker
- Start the worker (redeploy your code)

The workflow execution will continue as if nothing has happened. Note that the 
method `accountService.withdraw` won’t be executed again.




