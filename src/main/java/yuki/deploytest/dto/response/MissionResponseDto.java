package yuki.deploytest.dto.response;

import lombok.*;
import yuki.deploytest.entity.Student;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionResponseDto {
    private String studentName;
    private String studentNumber;
    private String email;
    private String track;

    public static MissionResponseDto of(Student student) {
        return MissionResponseDto.builder()
                .studentName(student.getStudentName())
                .studentNumber(student.getStudentNumber())
                .email(student.getEmail())
                .track(student.getTrack())
                .build();
    }
}