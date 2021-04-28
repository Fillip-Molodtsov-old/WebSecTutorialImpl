package com.mldtsv.amigossecurity.web.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;


@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ErrorBody {
    private String message;
    private String tip;
}
