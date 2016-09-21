package com.tneciv.blueprint.common.utils;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * 封装一些常用的关于Android6.0权限的方法
 * Created by Tneciv on 8/18/16.
 */
public class PermissionTool {
    /**
     * 获取权限
     *
     * @param fragment
     * @param permissions
     * @param requestCode
     * @return 如果有需要获取的权限返回true，权限都有则返回false
     */
    public static boolean requestPermission(Fragment fragment, String[] permissions, int requestCode) {
        ArrayList<String> listPermission = new ArrayList<>(permissions.length);

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(fragment.getActivity(), permission) != PackageManager.PERMISSION_GRANTED) {
                listPermission.add(permission);
            }
        }
        // 有权限未获取
        if (listPermission.size() != 0) {
            //FragmentCompat.requestPermissions(fragment, permissions, requestCode);
            return true;
        }

        return false;
    }

    /**
     * 返回是否有拒绝的权限
     *
     * @param permissions
     * @param grantResults
     * @return 如果权限都通过则返回null
     */
    public static String hasDeniedPermission(String[] permissions, int[] grantResults) {
        int length = Math.min(permissions.length, grantResults.length);
        for (int i = 0; i < length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                return permissions[i];
            }
        }
        return null;
    }

    /**
     * 显示权限拒绝对话框
     * 点击设置会跳转到应用详情页面
     *
     * @param activity
     * @param permission    拒绝的权限类型，新增权限需要在方法中新增说明
     * @param clickListener 无论点击设置还是取消都会执行的操作
     */
    public static void showPermissionDeniedDialog(final Activity activity, String permission, final DialogInterface.OnClickListener clickListener) {
        //String message = "";
        // 根据不同的权限类型提示不同的说明
        //if (permission.equals(Manifest.permission.CAMERA)) {
        //    message = activity.getString(R.string.super_camera_permission_grant_denied);
        //} else if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
        //    message = activity.getString(R.string.super_write_permission_grant_denied);
        //} else if (permission.equals(Manifest.permission.RECORD_AUDIO)) {
        //    message = activity.getString(R.string.super_record_permission_grant_denied);
        //}
        //AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //builder.setMessage(message)
        //        .setCancelable(false)
        //        .setPositiveButton(R.string.super_setting, new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialog, int which) {
        //                // 打开应用详情界面
        //                Intent intent = new Intent();
        //                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        //                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        //                activity.startActivity(intent);
        //
        //                dialog.cancel();
        //                if (clickListener != null) {
        //                    clickListener.onClick(dialog, which);
        //                }
        //            }
        //        })
        //        .setNegativeButton(R.string.super_cancel, new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialog, int which) {
        //                dialog.cancel();
        //                if (clickListener != null) {
        //                    clickListener.onClick(dialog, which);
        //                }
        //            }
        //        });
        //builder.create().show();
    }
}
