# Child workflows

The transfer method takes a list of TransferRequest (instead of only one request)
The code iterate over each TransferRequest and execute `withdraw` and `deposit`.

## Exercise 
Modify the code in [MoneyTransferWorkflowImpl](./initial/workflow/MoneyTransferWorkflowImpl.java) to create and execute 
one child workflow for each TransferRequest element in the list.

You can choose between running child workflows sequentially or in parallel.


### Documentation
- [Child workflow](https://docs.temporal.io/workflows#child-workflow)
- [Child workflow in java](https://docs.temporal.io/application-development/features?lang=java#child-workflows)
- Code sample
  - [Sync execution child workflow](https://github.com/temporalio/samples-java/blob/main/core/src/main/java/io/temporal/samples/hello/HelloChild.java#L98)
  - [Async execution child workflow](https://github.com/temporalio/samples-java/blob/main/core/src/main/java/io/temporal/samples/hello/HelloChild.java#L89)
  - [Parallel execution of activities (same applies to child workflows)](https://github.com/temporalio/samples-java/blob/main/core/src/main/java/io/temporal/samples/hello/HelloParallelActivity.java)

### Solution in packages `parallel` and `sequential`