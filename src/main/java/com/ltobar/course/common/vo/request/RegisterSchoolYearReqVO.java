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
public class RegisterSchoolYearReqVO {

    @NotNull(message = "El identificador del curso no puede ser nulo.")
    private Integer courseId;

    @NotNull(message = "El identificador del instructor no puede ser nulo.")
    private Integer instructorId;

    @NotNull(message = "El perido a asignar no puede ser nulo.")
    private Integer year;

}
