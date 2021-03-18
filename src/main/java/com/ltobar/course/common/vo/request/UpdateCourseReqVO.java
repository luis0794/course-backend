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
public class UpdateCourseReqVO {

    @NotNull(message = "El identificador del curso no puede estar vacío")
    private Integer id;

    @NotBlank(message = "El nombre del curso no puede estar vacío.")
    private String name;

    private String description;

}
