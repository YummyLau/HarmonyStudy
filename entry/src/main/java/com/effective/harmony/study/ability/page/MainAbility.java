package com.effective.harmony.study.ability.page;

import com.effective.harmony.study.ability.page.slice.MainAbilitySlice;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * Page Ability
 * created by yummylau on 2020/12/24
 */
public class MainAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}