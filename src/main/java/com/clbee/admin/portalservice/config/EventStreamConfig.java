package com.clbee.admin.portalservice.config;

import java.util.function.Consumer;

import com.clbee.admin.common.dto.AttachmentEntityMessage;
import com.clbee.admin.portalservice.api.attachment.dto.AttachmentUploadRequestDto;
import com.clbee.admin.portalservice.service.attachment.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class EventStreamConfig {

	@Autowired
	private AttachmentService attachmentService;

	@Bean
	public Consumer<AttachmentEntityMessage> attachmentEntity() {
		return attachmentEntityMessage -> attachmentService.updateEntity(
			attachmentEntityMessage.getAttachmentCode(),
			AttachmentUploadRequestDto.builder()
				.entityName(attachmentEntityMessage.getEntityName())
				.entityId(attachmentEntityMessage.getEntityId())
				.build());
	}
}
