package com.effective.harmony.study.ability.data;

import ohos.aafwk.ability.Ability;
import ohos.rpc.MessageParcel;
import ohos.utils.net.Uri;

import java.io.*;

/**
 * Data Ability，用于提供外部程序访问数据入口,文件数据
 * created by yummylau on 2020/12/24
 */
public class FileAbility extends Ability {

    /**
     * 文件存储
     *
     * @param uri
     * @param mode
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public FileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        try {
            MessageParcel messageParcel = MessageParcel.obtain();
            File file = new File(uri.getDecodedPathList().get(1));
            if (mode == null || !"rw".equals(mode)) {
                file.setReadOnly();
            }
            FileInputStream fileIs = new FileInputStream(file);
            FileDescriptor fd = fileIs.getFD();
            return messageParcel.dupFileDescriptor(fd);
        } catch (IOException e) {
            return super.openFile(uri, mode);
        }
    }
}
