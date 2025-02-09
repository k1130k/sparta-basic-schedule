package com.example.schedule.controller;



import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto dto) {
        return ResponseEntity.ok(scheduleService.save(dto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
            return ResponseEntity.ok(scheduleService.findAll());
        }

        @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> fineOne(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.fineById(id));
        }

        @PutMapping("/schedules/{id}")
        public ResponseEntity<ScheduleResponseDto> update(
                @PathVariable Long id,
                @RequestBody ScheduleRequestDto dto
        ) {
            return ResponseEntity.ok(scheduleService.update(id, dto));
        }

        @DeleteMapping("/schedules/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.deleteById(id);
        }
    }
