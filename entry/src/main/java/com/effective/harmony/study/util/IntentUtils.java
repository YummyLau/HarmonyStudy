package com.effective.harmony.study.util;

import com.effective.harmony.study.ability.page.MainAbility;
import com.effective.harmony.study.ability.service.ServiceAbility;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;

public class IntentUtils {

    public static final Intent getMainAbilityIntent(AbilitySlice slice) {
        Intent toMain = new Intent();
        Operation operation = new Intent.OperationBuilder().withDeviceId("")
                .withBundleName(slice.getBundleName())
                .withAbilityName(MainAbility.class.getName())
                .build();
        toMain.setOperation(operation);
        return toMain;
    }

    public static final Intent getCountServiceAbilityIntent(AbilitySlice slice) {
        Intent toCountService = new Intent();
        Operation operation = new Intent.OperationBuilder().withDeviceId("")
                .withBundleName(slice.getBundleName())
                .withAbilityName(ServiceAbility.class.getName())
                .build();
        toCountService.setOperation(operation);
        return toCountService;
    }
}
