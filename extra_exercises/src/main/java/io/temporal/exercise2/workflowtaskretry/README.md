# Workflow task  failure

This example demostrate the workflow task will retry in presence of errors. 
The workflow code throws runtime error, once we fix the code and redeploy the worker, the worker will continue the workflow execution.

### Make sure Temporal Server is running locally
- https://docs.temporal.io/application-development/foundations#run-a-development-server

### run Starter.java (send request/start workflow)
### run WorkerProcess.java (worker executes our code)

note runtime exceptions in console. 
The worker send WorkflowTaskFailed to the server and the server re-schedule
the workflow task (the worker keep retrying the task)

### open, MoneyTransferWorkflowImpl.java,
- fix the code
- stop the worker
- start the worker / redeploy your code 

The workflow execution will continue as is nothing has happened 
(the method `accountService.withdraw` won’t be executed again)




