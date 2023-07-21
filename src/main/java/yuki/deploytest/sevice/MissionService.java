package yuki.deploytest.sevice;

import yuki.deploytest.dto.response.MissionResponseDto;

import java.util.List;

public interface MissionService {


    MissionResponseDto selectStudentInfo(String studentNumber);

    List<MissionResponseDto> findAll();
}
