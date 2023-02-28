package it.philmark.gestione_personale.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import java.util.Date;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class InterviewDto extends BaseDto {
    @Nullable
    private Long id;
    private Byte[] cv;
    private Date date;
    private Boolean passed;
    private ResourceDto resource;
    private TaskDto task;
}
