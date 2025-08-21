package ru.practicum.dto.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {
    String valletId;

    OperationType operationType;

    Integer amount;
}
