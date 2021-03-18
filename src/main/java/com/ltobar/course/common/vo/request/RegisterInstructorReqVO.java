package com.ltobar.course.common.vo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RegisterInstructorReqVO {

    @NotBlank(message = "La identificación del instructor no puede estar vacía.")
    private String identification;

    @NotBlank(message = "El nombre del instructor no puede estar vacío.")
    private String name;

}
