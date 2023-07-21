package yuki.deploytest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuki.deploytest.dto.response.MissionResponseDto;
import yuki.deploytest.sevice.MissionService;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mission/api")
public class MissionController {

    private final MissionService missionServiceImpl;

    @GetMapping("/{studentNumber}")
    public ResponseEntity<MissionResponseDto> getStudentInfo(@PathVariable String studentNumber) {
        return ResponseEntity.ok(missionServiceImpl.selectStudentInfo(studentNumber));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> data = new HashMap<>();
        data.put("student", missionServiceImpl.findAll());

        return ResponseEntity.ok(data);
    }
}
