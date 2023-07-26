package yuki.deploytest.persist.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    private String studentNumber;

    @NotBlank
    private String studentName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String Track;

    @Builder
    public Student(Long id, String studentNumber, String studentName, String email, String track) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.email = email;
        Track = track;
    }
}
