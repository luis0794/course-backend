package com.ltobar.course.common.vo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdateInstructorReqVO {

    @NotNull(message = "El identificador del instructor no puede estar vacío.")
    private Integer id;

    @NotBlank(message = "La identificación del instructor no puede estar vacía.")
    private String identification;

    @NotBlank(message = "El nombre del instructor no puede estar vacío.")
    private String name;

}
