package com.learn.localClass;

public class Button {

    private String title;
    private OnClickListener onClickListener;

    public Button(String title) {
        this.title = title;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        onClickListener.onClick(title);
    }

    public interface OnClickListener {
        void onClick(String title);
    }
}
