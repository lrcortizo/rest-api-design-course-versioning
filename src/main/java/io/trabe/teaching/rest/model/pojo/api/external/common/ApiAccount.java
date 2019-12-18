package io.trabe.teaching.rest.model.pojo.api.external.common;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiAccount {
    private Long id;
    private String code;
    private String description;
    private Double balance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar creationDate;
    private ApiAccountKind kind;

}
