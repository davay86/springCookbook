package com.springcookbook.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;
import java.util.Date;


/**
 * Created by davidronaldson on 13/01/2017.
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfig {


    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    JobLauncher jobLauncher;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("user1");
        dataSource.setPassword("pass1");

        return dataSource;
    }

    @Bean
    public Step step1(){
        return steps.get("step1")
                .tasklet(new Task1())
                .build();
    }

    @Bean
    public Job job1(){
        return jobs.get("job1")
                .start(step1())
                .build();
    }

    @Scheduled(fixedDelay = 10000)
    public void runJob1() throws Exception{
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addDate("d", new Date());
        jobLauncher.run(job1(), jobParametersBuilder.toJobParameters());
    }
}