package com.ltobar.course.common.vo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SchoolYearVO {

    private Integer id;

    private Integer courseId;

    private String courseName;

    private Integer instructorId;

    private String instructorName;

    private Integer year;
}
