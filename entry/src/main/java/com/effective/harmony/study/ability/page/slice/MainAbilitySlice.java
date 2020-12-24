package com.effective.harmony.study.ability.page.slice;

import com.effective.harmony.study.ResourceTable;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.window.dialog.ToastDialog;

/**
 * Hello world ability slice
 */
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        findComponentById(ResourceTable.Id_text_helloworld).setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                ToastDialog toastDialog = new ToastDialog(MainAbilitySlice.this);
                toastDialog.setText("跳转到Main2AbilitySlice");
                toastDialog.show();
                present(new Main2AbilitySlice(),new Intent());
            }
        });

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}