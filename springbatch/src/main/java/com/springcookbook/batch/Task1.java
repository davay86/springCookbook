package com.springcookbook.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Created by davidronaldson on 13/01/2017.
 */
public class Task1 implements Tasklet {

    @StepScope
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Starting job..");

        String test = (String)chunkContext.getStepContext().getJobParameters().get("test");
        System.out.println(test);
        // ... your code

        System.out.println("Job done..");
        return RepeatStatus.FINISHED;
    }
}
