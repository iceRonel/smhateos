package org.rk.smhateos.diary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DiaryEntry {

    @JsonIgnore
    private DiaryEntryIdentifier identifier;

    private LocalDateTime reportedAt;

    private BloodPressure pressure;


    public DiaryEntry (DiaryEntryIdentifier id, LocalDateTime reportedAt, BloodPressure pressure){

        this.identifier = id;
        this.reportedAt = reportedAt;
        this.pressure =pressure;

    }

    @Value(staticConstructor = "of")
    public static class DiaryEntryAdded{
        DiaryEntry entry;
    }


    @EqualsAndHashCode
    @RequiredArgsConstructor(staticName = "of")
    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    public static class DiaryEntryIdentifier {

        private final UUID diaryEntryId;


        @Override
        public String toString() {
            return diaryEntryId.toString();
        }
    }
}
