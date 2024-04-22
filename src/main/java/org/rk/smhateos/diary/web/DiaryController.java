package org.rk.smhateos.diary.web;

import lombok.RequiredArgsConstructor;
import org.rk.smhateos.diary.BloodPressure;
import org.rk.smhateos.diary.DiaryEntry;
import org.rk.smhateos.diary.DiaryManagement;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryManagement diaryManagement;

    @GetMapping("/diary")
    public ResponseEntity<?> diary(){
        var pressure = new BloodPressure(122,82);

        var diaryEntry = new DiaryEntry(DiaryEntry.DiaryEntryIdentifier.of(UUID.randomUUID()
        ), LocalDateTime.now(), pressure);

        var model = EntityModel.of(diaryEntry);

        diaryManagement.updateDiary(diaryEntry);

        model.add(Link.of("/diary/{segment}").expand(Map.of("segment",diaryEntry.getIdentifier().toString())));

        return ResponseEntity.ok(model);


    }
}
