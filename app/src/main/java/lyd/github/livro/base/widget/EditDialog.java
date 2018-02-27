package lyd.github.livro.base.widget;

import android.app.Activity;
import android.text.TextUtils;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

/**
 * @author shawn
 * @date 18/2/27
 * @desription 输入框dialog
 */

public class EditDialog {

    private QMUIDialog.EditTextDialogBuilder mDialogBuilder;

    private OnDialogClickListener onDialogClickListener;

    public EditDialog(Activity activity, String title, String hint, String... btns) {
        mDialogBuilder = new QMUIDialog.EditTextDialogBuilder(activity);
        mDialogBuilder.setTitle(TextUtils.isEmpty(title) ? "提示" : title).setPlaceholder(TextUtils.isEmpty(hint) ? "" : hint);
        //不输入按钮名称时，默认添加取消确定按钮
        if (btns == null) {
            btns = new String[2];
            btns[0] = "取消";
            btns[1] = "确认";
        }
        for (int i = 0; i < btns.length; i++) {
            final int position = i;
            mDialogBuilder.addAction("确定", new QMUIDialogAction.ActionListener() {
                @Override
                public void onClick(QMUIDialog dialog, int index) {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onClick(position, mDialogBuilder.getEditText().getText().toString());
                    }
                }
            });
        }
    }

    public void show() {
        if (mDialogBuilder != null) {
            mDialogBuilder.show();
        }
    }

    public void setOnDialogClickListener(OnDialogClickListener onDialogClickListener) {
        this.onDialogClickListener = onDialogClickListener;
    }

    public interface OnDialogClickListener {
        void onClick(int position, String text);
    }
}
