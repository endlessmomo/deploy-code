package yuki.deploytest.sevice;

import yuki.deploytest.dto.response.MissionResponseDto;

import java.util.List;

public interface MissionService {
    public MissionResponseDto selectStudentInfo(String studentNumber);

    public List<MissionResponseDto> findAll();
}
