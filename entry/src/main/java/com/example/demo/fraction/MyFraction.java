package com.example.demo.fraction;

import com.example.demo.fraction.slice.MyFractionSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MyFraction extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MyFractionSlice.class.getName());
    }
}
