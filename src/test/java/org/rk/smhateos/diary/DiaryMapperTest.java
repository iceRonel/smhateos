package org.rk.smhateos.diary;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiaryMapperTest {



    @Test
    public void shouldMapDiary(){
        var pressure = new BloodPressure(122,82);

        var diaryEntry = new DiaryEntry(DiaryEntry.DiaryEntryIdentifier.of(UUID.randomUUID()
        ), LocalDateTime.now(), pressure);


        DiaryDto diaryDto = DiaryMapper.INSTANCE.map(diaryEntry);

        assertThat(diaryDto).isNotNull();
        assertThat(diaryDto.getId()).isEqualTo(diaryEntry.getIdentifier().toString());

    }

}