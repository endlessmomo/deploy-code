package yuki.deploytest.sevice;

import yuki.deploytest.dto.response.MissionResponseDto;

public interface MissionService {
    public MissionResponseDto selectStudentInfo(String studentNumber);
}
