package org.rk.smhateos.diary;

import org.springframework.stereotype.Component;


public class DiaryMapperImpl implements DiaryMapper{
    @Override
    public DiaryDto map(DiaryEntry entry) {
        if (entry==null){
            return null;
        }

        DiaryDto diaryDto = new DiaryDto();
        diaryDto.setId(entry.getIdentifier().toString());
        diaryDto.setSystolic(entry.getPressure().getSystolic());

        return diaryDto;

    }
}
