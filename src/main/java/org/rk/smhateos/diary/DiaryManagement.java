package org.rk.smhateos.diary;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.rk.smhateos.diary.DiaryEntry.DiaryEntryAdded;

@Service
@RequiredArgsConstructor
@Log4j2
public class DiaryManagement {

    private final ApplicationEventPublisher eventPublisher;


    public void updateDiary(DiaryEntry entry) {

        var event = DiaryEntryAdded.of(entry);
        eventPublisher.publishEvent(event);


    }


    @ApplicationModuleListener
    public void on(DiaryEntryAdded entryAdded) {

        log.info("event {} arrived", entryAdded);
    }
}