package com.ltobar.course.common.vo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdateSchoolYearReqVO {

    @NotNull(message = "El identificador del perido curso/instructor no puede estar vacío.")
    private Integer id;

    @NotNull(message = "El identificador del curso no puede estar vacío.")
    private Integer courseId;

    @NotNull(message = "El identificador del instructor no puede estar vacío.")
    private Integer instructorId;

    @NotNull(message = "El perido a asignar no puede estar vacío.")
    private Integer year;

}
