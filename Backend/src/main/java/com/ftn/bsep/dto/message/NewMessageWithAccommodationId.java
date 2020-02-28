package com.ftn.bsep.dto.message;

import com.ftn.bsep.security.validation.SQLInjectionSafe;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class NewMessageWithAccommodationId {

    @NotNull
    private Long accommodationId;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
    String subject;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String content;
}
