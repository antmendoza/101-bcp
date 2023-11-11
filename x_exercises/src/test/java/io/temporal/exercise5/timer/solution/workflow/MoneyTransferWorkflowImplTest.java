/*
 *  Copyright (c) 2020 Temporal Technologies, Inc. All Rights Reserved
 *
 *  Copyright 2012-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *  Modifications copyright (C) 2017 Uber Technologies, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"). You may not
 *  use this file except in compliance with the License. A copy of the License is
 *  located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 *  or in the "license" file accompanying this file. This file is distributed on
 *  an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */

package io.temporal.exercise5.timer.solution.workflow;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.temporal.DescribeWorkflowExecution;
import io.temporal.api.enums.v1.WorkflowExecutionStatus;
import io.temporal.api.workflowservice.v1.DescribeWorkflowExecutionResponse;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.model.TransferRequest;
import io.temporal.service.AccountService;
import io.temporal.service.AccountServiceImpl;
import io.temporal.testing.TestWorkflowRule;
import io.temporal.worker.Worker;
import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

public class MoneyTransferWorkflowImplTest {

  private final String myWorkflowId = "myWorkflow";

  @Rule
  public TestWorkflowRule testWorkflowRule =
      TestWorkflowRule.newBuilder().setDoNotStart(true).build();

  @After
  public void shutdown() {
    testWorkflowRule.getTestEnvironment().shutdown();
  }

  @Test
  public void testTransfer() {

    AccountService accountService = Mockito.mock(AccountServiceImpl.class);

    Worker worker = testWorkflowRule.getWorker();
    worker.registerWorkflowImplementationTypes(MoneyTransferWorkflowImpl.class);
    worker.registerActivitiesImplementations(accountService);

    // Start server
    testWorkflowRule.getTestEnvironment().start();

    final WorkflowOptions options =
        WorkflowOptions.newBuilder()
            .setWorkflowId(myWorkflowId)
            .setTaskQueue(testWorkflowRule.getTaskQueue())
            .build();

    final WorkflowClient workflowClient = testWorkflowRule.getWorkflowClient();

    ///////////

    final MoneyTransferWorkflow workflow =
        workflowClient.newWorkflowStub(MoneyTransferWorkflow.class, options);

    TransferRequest transferRequest =
        new TransferRequest("fromAccount", "toAccount", "reference1", 1.23);

    // Start async
    WorkflowClient.start(workflow::transfer, transferRequest);

    testWorkflowRule.getTestEnvironment().sleep(Duration.ofSeconds(5));

    verify(accountService, times(1)).withdraw(any());
    verify(accountService, times(0)).deposit(any());

    testWorkflowRule.getTestEnvironment().sleep(Duration.ofMinutes(1));

    verify(accountService, times(1)).deposit(any());

    // Wait workflow to complete
    workflowClient.newUntypedWorkflowStub(myWorkflowId).getResult(Void.class);

    DescribeWorkflowExecutionResponse describeResponse =
        new DescribeWorkflowExecution(myWorkflowId, testWorkflowRule).get();

    Assert.assertEquals(
        describeResponse.getWorkflowExecutionInfo().getStatus(),
        WorkflowExecutionStatus.WORKFLOW_EXECUTION_STATUS_COMPLETED);

    /////////////

  }
}
