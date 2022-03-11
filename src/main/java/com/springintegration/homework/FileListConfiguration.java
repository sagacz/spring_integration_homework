package com.springintegration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;

import java.io.File;

@Configuration
public class FileListConfiguration {

    @Bean
    IntegrationFlow fileIntegrationFlow(FileReadingMessageSource fileAdapter,
                                        FileTransformer transformer,
                                        FileWritingMessageHandler outputFileHandler){
        return IntegrationFlows.from(fileAdapter, config -> config.poller(Pollers.fixedDelay(1000)))
                .transform(transformer, "fileNameList")
                .handle(outputFileHandler)
                .get();
    }

    @Bean
    FileReadingMessageSource fileAdapter(){
        FileReadingMessageSource fileSource = new FileReadingMessageSource();
        fileSource.setDirectory(new File("data/input"));
        return fileSource;
    }

    @Bean
    FileTransformer transformer(){
        return new FileTransformer();
    }

    @Bean
    FileWritingMessageHandler fileHandler(){
        File directory = new File("data/output");
        FileWritingMessageHandler outputFile = new FileWritingMessageHandler(directory);
        outputFile.setFileExistsMode(FileExistsMode.APPEND);
        outputFile.setExpectReply(false);
        outputFile.setAppendNewLine(true);
        outputFile.setFileNameGenerator(new FileNameGeneratorImpl());
        return outputFile;
    }

}
