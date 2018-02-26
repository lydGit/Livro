package lyd.github.livro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import lyd.github.livro.R;
import lyd.github.livro.base.utils.StatusBarUtil;


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
        initStatusBar();
        //设置标题
        tvCommonTitleName.setText(getTitleName());
        //初始数据
        init();
    }

    /**
     * 初始状态栏
     */
    private void initStatusBar(){
        //设置状态栏颜色
        StatusBarUtil.setStatusBarColor(this, R.color.colorTheme);
        //获取Activity根布局的子布局(则layout布局)，动态设置fitsSystemWindows＝true属性
        ViewGroup contentParent = (ViewGroup) findViewById(android.R.id.content);
        //获取子布局的数量，如果count＝1，则默认为layout布局
        if (contentParent.getChildCount() == 1) {
            contentParent.getChildAt(0).setFitsSystemWindows(true);
        }
    }

    @OnClick(R.id.iv_common_title_back)
    public void back() {
        finish();
    }
}
