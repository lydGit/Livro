package lyd.github.livro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import lyd.github.livro.R;


/**
 * @author shawn
 * @date 18/2/22
 * @desription 带标题activity基类
 */

public abstract class BaseTitleActivity extends BaseActivity {

    @InjectView(R.id.iv_common_title_back)
    ImageView ivCommonTitleBack;
    @InjectView(R.id.tv_common_title_name)
    TextView tvCommonTitleName;

    public abstract int getLayoutId();

    public abstract String getTitleName();

    public abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.inject(this);
        //设置标题
        tvCommonTitleName.setText(getTitleName());
        //初始数据
        init();
    }

    @OnClick(R.id.iv_common_title_back)
    public void back() {
        finish();
    }
}
