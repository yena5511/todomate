package com.example.demo.domain.todo.service;


import com.example.demo.domain.todo.dto.CreateSchedulRequestDto;
import com.example.demo.domain.todo.dto.GetSchedulInfoResponseDto;
import com.example.demo.domain.todo.dto.GetSchedulResponseDto;
import com.example.demo.domain.todo.entity.Schedule;
import com.example.demo.domain.todo.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    public void writeSchedule(CreateSchedulRequestDto dto) {
        Schedule schedule = Schedule.builder()
                .title(dto.getTitle())
                .document_date(dto.getDocument_date())
                .document_passed(dto.getDocument_passed())
                .written_date(dto.getWritten_date())
                .written_passed(dto.getWritten_passed())
                .interview(dto.getInterview())
                .result(dto.getResult())
                .build();

        scheduleRepository.save(schedule);
    }

    public List<GetSchedulInfoResponseDto> getSchedulList() {
        return scheduleRepository.findAll().stream()
                .map(meeting -> GetSchedulInfoResponseDto.builder()
                        .id(meeting.getId())
                        .title(meeting.getTitle())
                        .build()
                ).toList();
    }

    public GetSchedulResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.getReferenceById(id);

        return GetSchedulResponseDto.builder()
                .title(schedule.getTitle())
                .document_date(schedule.getDocument_date())
                .document_passed(schedule.getDocument_passed())
                .written_date(schedule.getWritten_date())
                .written_passed(schedule.getWritten_passed())
                .interview(schedule.getInterview())
                .result(schedule.getResult())
                .build();
    }

    public void deleteSchedule(Long id) throws Exception {
        scheduleRepository.deleteById(id);
    }

    public void updateSchedule(CreateSchedulRequestDto dto, Long id) throws Exception {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 스케줄이 존재하지 않습니다."));

        schedule.updateSchedule(
                dto.getTitle(),
                dto.getDocument_date(),
                dto.getDocument_passed(),
                dto.getWritten_date(),
                dto.getWritten_passed(),
                dto.getInterview(),
                dto.getResult()
        );

    }


}
