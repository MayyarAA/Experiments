//package com.mayyar.springone.SpringOne.aws.config;
//
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Regions;
//import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
//import com.amazonaws.services.sqs.AmazonSQSAsync;
//import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class AWSSQSConfig {
//    @Value("${cloud.aws.region.static}")
//    private String region;
//
//    @Value("${cloud.aws.credentials.access-key}")
//    private String awsAccessKey;
//
//    @Value("${cloud.aws.credentials.secret-key}")
//    private String awsSecretKey;
//
//    @Bean
//    public QueueMessagingTemplate queueMessagingTemplate() {
//        return new QueueMessagingTemplate(amazonSQSAsync());
//    }
//    @Primary
//    @Bean
//    public AmazonSQSAsync amazonSQSAsync() {
//        return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_1)
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
//                .build();
//    }
//}
