package extension.extension.activity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ActivityDTO(
        String title,
        String url,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        String creationDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        String endDate
)
{}
