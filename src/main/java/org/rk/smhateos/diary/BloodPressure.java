package org.rk.smhateos.diary;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
@RequiredArgsConstructor
@Data
public class BloodPressure {


    private Integer systolic;
    private Integer diastolic;


    public BloodPressure(int systolic, int diastolic){
        this.diastolic = diastolic;
        this.systolic = systolic;
    }






}
