package yuki.deploytest.sevice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yuki.deploytest.dto.response.MissionResponseDto;
import yuki.deploytest.persist.entity.Student;
import yuki.deploytest.persist.repository.MissionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Slf4j
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

    @Override
    public List<MissionResponseDto> findAll() {
        List<Student> all = missionRepository.findAll();

        all.forEach(i -> log.info("student = {}", i.toString()));

        return all.stream()
                .map(MissionResponseDto::of)
                .collect(Collectors.toList());
    }
}
