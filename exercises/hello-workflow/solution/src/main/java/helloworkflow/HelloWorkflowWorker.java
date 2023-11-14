package helloworkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class HelloWorkflowWorker {
    
    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newServiceStubs(io.temporal.serviceclient.WorkflowServiceStubsOptions.newBuilder()
        .setTarget("127.0.0.1:7233") // Default values, can be omitted
        .build());
        WorkflowClient client = WorkflowClient.newInstance(service, io.temporal.client.WorkflowClientOptions.newBuilder()
        .setNamespace("default") //// Default value, can be omitted
        .build());
        WorkerFactory factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker("greeting-tasks");

        worker.registerWorkflowImplementationTypes(HelloWorkflowWorkflowImpl.class);

        factory.start();

    }
}
