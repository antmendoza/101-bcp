package farewellworkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

public class Starter {
    public static void main(String[] args) throws Exception {

        WorkflowServiceStubs service = WorkflowServiceStubs.newServiceStubs(io.temporal.serviceclient.WorkflowServiceStubsOptions.newBuilder()
                .setTarget("127.0.0.1:7233") // Default values, can be omitted
                .build());

        WorkflowClient client = WorkflowClient.newInstance(service, io.temporal.client.WorkflowClientOptions.newBuilder()
                .setNamespace("default") //// Default value, can be omitted
                .build());

        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setWorkflowId("greeting-workflow")
                .setTaskQueue("greeting-tasks")
                .build();

        GreetingWorkflow workflow = client.newWorkflowStub(GreetingWorkflow.class, options);

        String greeting = workflow.greetSomeone(args[0]);

        String workflowId = WorkflowStub.fromTyped(workflow).getExecution().getWorkflowId();

        System.out.println(workflowId + " " + greeting);
        System.exit(0);
    }
}
