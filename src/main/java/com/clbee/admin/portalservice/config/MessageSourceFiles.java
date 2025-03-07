package com.clbee.admin.portalservice.config;

import lombok.extern.slf4j.Slf4j;
import com.clbee.admin.portalservice.domain.message.Message;
import com.clbee.admin.portalservice.domain.message.MessageRepository;
import com.clbee.admin.portalservice.utils.StorageUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * com.clbee.admin.portalservice.config.MessageSourceFileCreate
 * <p>
 * 서비스 기동시 호출되어 messages/messages{lang}.properties 를 jar 실행되는 위치에 생성한다.
 * 각 서비스에서 해당 파일을 통해 다국어를 지원하도록 한다.
 *
 * @author seohan jung
 * @version 1.0
 * @since 2025/02/20
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2025/02/20    seohan jung  최초 생성
 * </pre>
 */
@Slf4j
@RefreshScope
@Component
public class MessageSourceFiles {

    private final MessageRepository messageRepository;
    private final Environment environment;
    private final StorageUtils storageUtils;

    public MessageSourceFiles(MessageRepository messageRepository, Environment environment, StorageUtils storageUtils) {
        this.messageRepository = messageRepository;
        this.environment = environment;
        this.storageUtils = storageUtils;
    }

    @PostConstruct
    public int create() {
        // db 에서 messages 를 조회한다.
        List<Message> messages = messageRepository.findAll();
        log.info("messages size = {}", messages.size());
        if (messages.size() == 0) {
            return 0;
        }

        // 기본 properties 파일과 언어별 properties 파일을 생성한다.
        String[] langs = new String[]{"", "_ko", "_en"};
        List<File> files = new ArrayList<>();

        // 메시지 폴더 경로
        final String fileMessagesDirectory = StringUtils.cleanPath(environment.getProperty("file.directory") + "/messages");
        try {
            Files.createDirectory(Paths.get(fileMessagesDirectory).toAbsolutePath().normalize());
        } catch (FileAlreadyExistsException e) {
            log.info("메시지 폴더 경로에 파일이나 디렉토리가 이미 존재");
        } catch (IOException e) {
            log.error("메시지 폴더 생성 오류", e);
        }

        for (String lang : langs) {
            Properties prop = new Properties();

            // Properties 에 조회한 messages set
            if ("_en".equals(lang)) {
                for (Message message : messages) {
                    String name = StringUtils.hasLength(message.getMessageEnName()) ? message.getMessageEnName() : message.getMessageKoName();
                    prop.setProperty(message.getMessageId(), name);
                }
            } else {
                for (Message message : messages) {
                    prop.setProperty(message.getMessageId(), message.getMessageKoName());
                }
            }

            File propFile = new File(StringUtils.cleanPath(fileMessagesDirectory + "/messages" + lang + ".properties"));
            log.info("messages properties path={}", propFile.getPath());
            propFile.setReadable(true);
            propFile.setWritable(true, true);

            try (FileOutputStream out = new FileOutputStream(propFile)) {
                prop.store(out, "messages");
            } catch (IOException e) {
                log.error("Messages FileOutputStream IOException", e);
            }

            // files
            files.add(propFile);
        }

        String ftpEnabled = environment.getProperty("ftp.enabled");
        // files 있는 경우 ftp 서버에 올린다.
        if ((StringUtils.hasLength(ftpEnabled) || "true".equals(ftpEnabled)) && !files.isEmpty()) {
            storageUtils.storeFiles(files, "messages");
        }

        return messages.size();
    }
}
