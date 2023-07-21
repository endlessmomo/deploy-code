package yuki.deploytest.sevice;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yuki.deploytest.dto.response.MissionResponseDto;
import yuki.deploytest.entity.Student;
import yuki.deploytest.repository.MissionRepository;

import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final ModelMapper modelMapper;
    @Override
    public MissionResponseDto selectStudentInfo(String studentNumber) {
        return missionRepository
                .findByStudentNumber(studentNumber)
                .map(student -> modelMapper.map(student, MissionResponseDto.class))
                .orElseThrow(() -> new NoSuchElementException("해당 학생은 존재하지 않습니다."));
    }
}
