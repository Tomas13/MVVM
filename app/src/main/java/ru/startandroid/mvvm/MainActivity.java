package ru.startandroid.mvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.et_user_id)
    EditText etUserId;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.ready.observe(this, aBoolean -> {
            if (aBoolean.booleanValue()) subscribe();
        });


        if (viewModel.getUser() != null){
            subscribe();
        }


        viewModel.getSnackbarMessage().observe(this,
                (SnackbarMessage.SnackbarObserver) snackbarMessageResourceId ->
                        SnackbarUtils.showSnackbar(tvUser,
                                getString(snackbarMessageResourceId)));


    }

    private void subscribe() {
        viewModel.getUser().observe(this, user -> {
            tvUser.setText(user.toString());
        });
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        viewModel.init(etUserId.getText().toString());
    }
}
