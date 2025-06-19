package com.example.demo.domain.todo.controller;

import com.example.demo.domain.todo.dto.CreateSchedulRequestDto;
import com.example.demo.domain.todo.dto.GetSchedulInfoResponseDto;
import com.example.demo.domain.todo.dto.GetSchedulResponseDto;
import com.example.demo.domain.todo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 1. 스케줄 생성
    @PostMapping
    public ResponseEntity<Void> createSchedule(@RequestBody CreateSchedulRequestDto dto) {
        scheduleService.writeSchedule(dto);
        return ResponseEntity.ok().build();
    }

    // 2. 전체 스케줄 목록 조회 (요약 정보)
    @GetMapping
    public ResponseEntity<List<GetSchedulInfoResponseDto>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedulList());
    }

    // 3. 단일 스케줄 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<GetSchedulResponseDto> getSchedule(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getSchedule(id));
    }

    // 4. 스케줄 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) throws Exception {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    // 5. 스케줄 수정
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSchedule(@RequestBody CreateSchedulRequestDto dto,
                                               @PathVariable Long id) throws Exception {
        scheduleService.updateSchedule(dto, id);
        return ResponseEntity.ok().build();
    }
}
