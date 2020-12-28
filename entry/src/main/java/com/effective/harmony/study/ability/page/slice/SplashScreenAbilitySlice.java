package com.effective.harmony.study.ability.page.slice;

import com.effective.harmony.study.ResourceTable;

import com.effective.harmony.study.util.IntentUtils;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.eventhandler.InnerEvent;

/**
 * 闪屏片段
 * created by yummylau on 2020/12/28
 */
public class SplashScreenAbilitySlice extends AbilitySlice {
    private static final int COUNT_DOWN_EVENT = 1;
    private static final int COUNT_DOWN_TIME = 5;
    private static final int COUNT_DOWN_PERIOD = 1000;

    private Text skipButton;
    private Image loadingPic;

    private Intent redirectIntent;
    private CountDownHandler handler;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_splash_screen_layout);
        initView();
        initListener();
        loadData();
    }

    private void initView() {
        skipButton = (Text) findComponentById(ResourceTable.Id_skip_button_text);
        loadingPic = (Image) findComponentById(ResourceTable.Id_loading_pic);
    }

    private void initListener() {
        skipButton.setClickedListener(component -> {
            startAbility(redirectIntent);
            terminateAbility();
            if (handler != null) {
                handler.removeAllEvent();
            }
        });
    }

    private void loadData() {
        redirectIntent = IntentUtils.getMainAbilityIntent(this);
        handler = new CountDownHandler(EventRunner.current());
    }

    @Override
    public void onActive() {
        super.onActive();
        handler.sendEvent(COUNT_DOWN_EVENT, 0);
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    protected void onBackground() {
        super.onBackground();
        if (handler != null) {
            handler.removeAllEvent();
        }
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        if (handler != null) {
            handler.removeAllEvent();
        }
    }

    /**
     * Countdown handler
     */
    private class CountDownHandler extends EventHandler {

        private int countDown = COUNT_DOWN_TIME;

        CountDownHandler(EventRunner runner) {
            super(runner);
        }

        @Override
        protected void processEvent(InnerEvent event) {
            super.processEvent(event);
            switch (event.eventId) {
                case COUNT_DOWN_EVENT:
                    skipButton.setText("跳过 " + countDown);
                    countDown--;
                    if (countDown >= 0) {
                        handler.sendEvent(COUNT_DOWN_EVENT, COUNT_DOWN_PERIOD);
                    } else {
                        startAbility(redirectIntent);
                        terminateAbility();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}