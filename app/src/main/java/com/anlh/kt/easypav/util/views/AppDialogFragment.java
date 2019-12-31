package com.anlh.kt.easypav.util.views;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.anlh.kt.easypav.R;
import com.anlh.kt.easypav.util.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppDialogFragment extends DialogFragment {

    @BindView(R.id.app_dialog_container)
    ConstraintLayout appDialogContainer;
    @BindView(R.id.app_dialog_message)
    TextView appDialogMessage;
    @BindView(R.id.app_dialog_action_button)
    Button appDialogActionButton;
    @BindView(R.id.app_dialog_icon_status)
    AppCompatImageView appDialogIconStatus;

    @BindView(R.id.app_dialog_progress_bar)
    ProgressBar appDialogProgressBar;


    public static AppDialogFragment newInstance(int type, String message, boolean reset) {
        AppDialogFragment f = new AppDialogFragment();
        Bundle args = new Bundle();
        args.putInt(AppConstants.APP_DIALOG_PARAM_TYPE, type);
        args.putString(AppConstants.APP_DIALOG_PARAM_MESSAGE, message);
        args.putBoolean(AppConstants.APP_DIALOG_PARAM_RESET, reset);
        f.setArguments(args);
        return f;
    }

    public static AppDialogFragment newInstance(int type, String message) {
        AppDialogFragment f = new AppDialogFragment();
        Bundle args = new Bundle();
        args.putInt(AppConstants.APP_DIALOG_PARAM_TYPE, type);
        args.putString(AppConstants.APP_DIALOG_PARAM_MESSAGE, message);
        f.setArguments(args);
        return f;
    }

    public static AppDialogFragment newInstance(int type) {
        AppDialogFragment f = new AppDialogFragment();
        Bundle args = new Bundle();
        args.putInt(AppConstants.APP_DIALOG_PARAM_TYPE, type);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_app, container, false);
        ButterKnife.bind(this, view);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setupViews();
        return view;
    }

    @OnClick(R.id.app_dialog_action_button)
    public void appDialogActionButtonPressed() {
        getDialog().dismiss();
    }

    private void setupViews() {
        int type = getArguments().getInt(AppConstants.APP_DIALOG_PARAM_TYPE);
        if (type == AppConstants.DIALOG_TYPE_LOADER) {
            appDialogContainer.setVisibility(View.GONE);
            appDialogIconStatus.setVisibility(View.GONE);
            appDialogProgressBar.setVisibility(View.VISIBLE);
        } else if (type == AppConstants.DIALOG_TYPE_ERROR) {
            String message = getArguments().getString(AppConstants.APP_DIALOG_PARAM_MESSAGE, "");
            appDialogContainer.setVisibility(View.VISIBLE);
            appDialogIconStatus.setVisibility(View.VISIBLE);
            appDialogProgressBar.setVisibility(View.GONE);
            appDialogMessage.setText(message);
            appDialogIconStatus.setImageResource(R.drawable.ic_dialog_error);
        } else if (type == AppConstants.DIALOG_TYPE_SUCCESS){
            String message = getArguments().getString(AppConstants.APP_DIALOG_PARAM_MESSAGE, "");
            appDialogContainer.setVisibility(View.VISIBLE);
            appDialogIconStatus.setVisibility(View.VISIBLE);
            appDialogProgressBar.setVisibility(View.GONE);
            appDialogMessage.setText(message);
            appDialogIconStatus.setImageResource(R.drawable.ic_dialog_success);
        }

    }
}
