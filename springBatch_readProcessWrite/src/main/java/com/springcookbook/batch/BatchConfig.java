package com.springcookbook.batch;


import com.springcookbook.domain.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by davidronaldson on 24/01/2017.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Job job1(){
        return jobs.get("job1")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1(){
        return steps.get("step")
                .<User,User>chunk(1)
                .reader(reader(null))
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("user1");
        dataSource.setPassword("pass1");

        return dataSource;
    }

    private LineMapper<User> lineMapper() {
        DefaultLineMapper<User> lineMapper = new DefaultLineMapper<User>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"firstName","age"});
        lineTokenizer.setIncludedFields(new int[]{0,1});
        lineMapper.setLineTokenizer(lineTokenizer);

        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<User>();
        fieldSetMapper.setTargetType(User.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<User> reader(@Value("#{jobParameters[file]}") String csvFilePath) {
        FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
        reader.setLineMapper(lineMapper());
        reader.setResource(new PathResource(csvFilePath));

        reader.setLinesToSkip(1);
        reader.setEncoding("utf-8");

        return reader;
    }

    @Bean
    public ItemProcessor<User,User> processor() {
        return new UserProcessIncrementAge();
    }

    @Bean
    public JdbcBatchItemWriter<User> writer(){
        JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<User>();
        writer.setDataSource(dataSource());
        writer.setSql("INSERT INTO user (first_name, age) " +
                "VALUES ( :firstName, :age)");
        ItemSqlParameterSourceProvider<User> paramProvider = new BeanPropertyItemSqlParameterSourceProvider<User>();
        writer.setItemSqlParameterSourceProvider(paramProvider);
        return writer;
    }
}
